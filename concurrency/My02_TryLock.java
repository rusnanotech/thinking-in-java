package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * My02_TryLock.
 *
 * @author Vasily_Markov
 */
public class My02_TryLock {
    private static final int NUM_OF_THREADS = 10;

    static class LockTester {
        private final Lock lock = new ReentrantLock();

        public void test() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " before tryLock()");
            if (lock.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " captured lock");
                    TimeUnit.SECONDS.sleep(5);
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " released lock");
                }
            } else {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final LockTester tester = new LockTester();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_OF_THREADS);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    tester.test();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            executorService.execute(task);
        }
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
