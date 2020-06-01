package biz.markov.thinking.concurrency;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;
import static java.lang.Thread.NORM_PRIORITY;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/****************** Exercise 9 *****************
 * Modify SimplePriorities.java so that a custom
 * ThreadFactory sets the priorities of the threads.
 ***********************************************/
public class Ex09_Priorities {
    public static class ThreadFactoryImpl implements ThreadFactory {
        private int[] priorities = { MIN_PRIORITY, NORM_PRIORITY, MAX_PRIORITY };
        private int priorityIndex = 0;
        private int count = 1;
        private boolean varPriorityEnabled = false;

        @Override
        public Thread newThread(Runnable r) {
            int priority = NORM_PRIORITY;
            if (varPriorityEnabled) {
                priority = priorities[priorityIndex++ % priorities.length];
            }
            Thread thread = new Thread(r, "#" + count++ + "-" + priority);
            thread.setPriority(priority);
            return thread;
        }

        public ThreadFactoryImpl enableVarPriority() {
            varPriorityEnabled = true;
            return this;
        }
    }

    public static class HotTask implements Runnable {
        private volatile double number = 1.0;

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                for (int k = 0; k < 10000000; k++) {
                    number += number * ((double) k + Math.PI) / (Math.E - (double) k);
                    if (k % 100 == 0) {
                        Thread.yield();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test(new ThreadFactoryImpl());
        test(new ThreadFactoryImpl().enableVarPriority());
    }

    public static void test(ThreadFactory threadFactory) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(threadFactory);
        for (int i = 0; i < 9; i++) {
            exec.execute(new HotTask());
        }
        exec.awaitTermination(5, TimeUnit.SECONDS);
        exec.shutdown();
        System.out.println();
    }
}
