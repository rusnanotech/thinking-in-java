package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/****************** Exercise 22 ***************************
 * Create an example of a busy wait. One task sleeps for a
 * while and then sets a flag to true. The second task
 * watches that flag inside a while loop (this is the busy
 * wait) and when the flag becomes true, sets it back to
 * false and reports the change to the console. Note how
 * much wasted time the program spends inside the busy wait,
 * and create a second version of the program that uses
 * wait() instead of the busy wait.
 ********************************************************/
public class Ex22_BusyWait {
    private static final int DELAY = 5;
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private static volatile boolean flag = false;

    public static void test(Runnable task1, Runnable task2) throws InterruptedException {
        executorService.execute(task1);
        executorService.execute(task2);
        TimeUnit.SECONDS.sleep(DELAY);
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = new Runnable() {
            public void run() {
                System.out.println("Watching true flag");
                while (!flag) {
                }
                System.out.println("Setting up flag to false");
                flag = false;
            }
        };
        Runnable task2 = new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(DELAY);
                } catch (InterruptedException ignored) {
                }
                flag = true;
            }
        };
        test(task1, task2);

        final Runnable task3 = new Runnable() {
            public void run() {
                System.out.println("Watching true flag");
                try {
                    synchronized (this) {
                        while (!flag) {
                            wait();
                        }
                    }
                } catch (InterruptedException ignored) {
                }
                System.out.println("Setting up flag to false");
                flag = false;
            }
        };
        Runnable task4 = new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(DELAY);
                } catch (InterruptedException ignored) {
                }
                flag = true;
                synchronized (task3) {
                    task3.notifyAll();
                }
            }
        };
        test(task3, task4);

        executorService.shutdown();
    }
}
