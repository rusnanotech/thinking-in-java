package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * My04_Lock.
 *
 * @author Vasily_Markov
 */
public class My04_Lock {
    static class Locker {
        private Lock lock = new ReentrantLock();
        private boolean failed;

        Locker(boolean failed) {
            this.failed = failed;
        }

        void testLock() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " m() - start");
            if (failed) {
                System.out.println(Thread.currentThread().getName() + " m() - failed = true");
                throw new RuntimeException();
            }
            try {
                System.out.println(Thread.currentThread().getName() + " m() - try {}");
                throw new RuntimeException();
            } finally {
                System.out.println(Thread.currentThread().getName() + " m() - finally {}");
                lock.unlock();
            }
        }
    }

    static class Task implements Runnable {
        private Locker locker;

        Task(Locker locker) {
            this.locker = locker;
        }

        public void run() {
            locker.testLock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        boolean failed = false;
        if (args.length > 0) {
            failed = Boolean.parseBoolean(args[0]);
        }
        Locker locker = new Locker(failed);
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Task(locker));
        executorService.execute(new Task(locker));
        executorService.execute(new Task(locker));

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Terminating");
        System.exit(0);
    }
}
