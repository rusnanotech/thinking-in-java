package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * My03_WaitInSynchronized.
 *
 * @author Vasily_Markov
 */
public class My03_WaitMonitor {
    static class Task implements Runnable {
        private final Monitor monitor;

        public Task(Monitor monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            monitor.m();
        }
    }

    static class Monitor {
        public synchronized void m() {
            System.out.println(Thread.currentThread().getName() + " m() - start");
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
            System.out.println(Thread.currentThread().getName() + " m() - end");
        }

        public synchronized void n() {
            System.out.println(Thread.currentThread().getName() + " n() - start");
            notify();
            System.out.println(Thread.currentThread().getName() + " n() - end");
        }
    }

    private static final int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < COUNT; i++) {
            executorService.execute(new Task(monitor));
        }
        executorService.shutdown();

        for (int i = 0; i < COUNT; i++) {
            TimeUnit.MILLISECONDS.sleep(250);
            monitor.n();
        }
    }
}
