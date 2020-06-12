package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/****************** Exercise 18 ************************
 * Create a non-task class with a method that calls
 * sleep() for a long interval. Create a task that calls
 * the method in the non-task class. In main(), start the
 * task, then call interrupt() to terminate it. Make sure
 * that the task shuts down safely.
 ******************************************************/
public class Ex18_Interruption {
    static void doSleep() {
        try {
            System.out.println("doSleep(): started");
            TimeUnit.DAYS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("doSleep(): interrupted");
        } finally {
            System.out.println("doSleep(): cleaned up");
        }
    }

    static class Task implements Runnable {
        public void run() {
            doSleep();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Task());
        Future<?> future = executorService.submit(new Task());

        TimeUnit.SECONDS.sleep(1);

        System.out.println("shutdownNow()");
        executorService.shutdownNow();

        TimeUnit.SECONDS.sleep(1);

        System.out.println("cancel(true)");
        future.cancel(true);
    }
}
