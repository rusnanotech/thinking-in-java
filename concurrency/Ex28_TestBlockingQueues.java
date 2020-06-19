package biz.markov.thinking.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

import static biz.markov.thinking.concurrency.Ex20_CachedThreadPool.LiftOff;
import static net.mindview.util.Print.print;

/********************** Exercise 28 ***********************
 * Modify TestBlockingQueues.java by adding a new task that
 * places LiftOff on the BlockingQueue, instead of doing it
 * in main().
 *********************************************************/
class LiftOffRunner implements Runnable {
    private final BlockingQueue<LiftOff> rockets;
    private final String msg;

    public LiftOffRunner(String msg, BlockingQueue<LiftOff> queue) {
        rockets = queue;
        this.msg = msg;
    }

    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            print("Interrupted during put()");
        }
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                LiftOff rocket = rockets.take();
                print(msg + " " + rocket + " taken");
                rocket.run(); // Use this thread
            }
        } catch (InterruptedException e) {
            print("Waking from take()");
        }
        print("Exiting LiftOffRunner");
    }
}

class LiftOffCreator implements Runnable {
    private final LiftOffRunner runner;
    private final String msg;

    public LiftOffCreator(String msg, LiftOffRunner runner) {
        this.msg = msg;
        this.runner = runner;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            LiftOff rocket = new LiftOff(5);
            runner.add(rocket);
            print('\n' + msg + " " + rocket + " added");
        }
    }
}

public class Ex28_TestBlockingQueues {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    static void getKey() {
        try {
            // Compensate for Windows/Linux difference in the
            // length of the result produced by the Enter key:
            new BufferedReader(
                    new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getKey(String message) {
        print(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        print("\nStarted " + msg + " test");

        LiftOffRunner runner = new LiftOffRunner(msg, queue);
        Future<?> runnerFuture = executorService.submit(runner);
        Future<?> creatorFuture = executorService.submit(new LiftOffCreator(msg, runner));

        getKey("Press 'Enter' (" + msg + ")");

        runnerFuture.cancel(true);
        creatorFuture.cancel(true);

        print("Finished " + msg + " test\n");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", // Unlimited size
                new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue", // Fixed size
                new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue", // Size of 1
                new SynchronousQueue<LiftOff>());

        executorService.shutdown();
    }
}
