package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * My05_ThrowFromSynchronized.
 *
 * @author Vasily_Markov
 */
public class My05_ThrowFromMonitor {
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    static synchronized void m() {
        throw new RuntimeException();
    }


    static void n() {
        lock1.lock();
        if (true) {
            throw new RuntimeException();
        }
        lock1.unlock();
    }

    static void k() {
        lock2.lock();
        try {
            throw new RuntimeException();
        } finally {
            lock2.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        System.err.println("\ntesting m()");
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    m();
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);

        System.err.println("\ntesting n()");
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    n();
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);

        System.err.println("\ntesting k()");
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    k();
                }
            });
        }

        TimeUnit.SECONDS.sleep(1);

        System.exit(0);
    }
}
