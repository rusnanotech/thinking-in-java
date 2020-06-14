package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/****************** Exercise 21 ******************
 * Create two Runnables, one with a run() that
 * starts and calls wait(). The second class should
 * capture the reference of the first Runnable object.
 * Its run() should call notifyAll() for the first
 * task after some number of seconds have passed so
 * that the first task can display a message. Test
 * your classes using an Executor.
 ***********************************************/
public class Ex21_WaitNotify {
    static class Task1 implements Runnable {
        public synchronized void run() {
            System.out.println("Before wait()");
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
            System.out.println("Waked up");
        }
    }

    static class Task2 implements Runnable {
        private final Runnable task;

        Task2(Runnable task) {
            this.task = task;
        }

        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ignored) {
            }
            synchronized (task) {
                task.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Runnable task1 = new Task1();
        Runnable task2 = new Task2(task1);
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.shutdown();
    }
}
