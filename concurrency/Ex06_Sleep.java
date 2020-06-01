package biz.markov.thinking.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/****************** Exercise 6 *****************
 * Create a task that sleeps for a random amount
 * of time between 1 and 10 seconds, then displays
 * its sleep time and exits. Create and run a quantity
 * (given on the command line) of these tasks.
 ***********************************************/
public class Ex06_Sleep {
    private static final int MAX_DURATION = 10;

    public static class Task implements Runnable {
        private static int count = 0;

        private final int id = count++;

        @Override
        public void run() {
            int duration = new Random().nextInt(MAX_DURATION);
            System.out.println("#" + id + " sleep for " + duration + "s start");
            try {
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                System.err.println("#" + id + " interrupted");
                return;
            }
            System.out.println("#" + id + " sleep for " + duration + " end");
        }

        public static void main(String[] args) {
            int numOfTasks = 10;
            if (args.length > 0) {
                numOfTasks = Integer.parseInt(args[0]);
            }

            ExecutorService exec = Executors.newCachedThreadPool();
            for (int i = 0; i < numOfTasks; i++) {
                exec.execute(new Task());
            }
            exec.shutdown();
        }
    }
}
