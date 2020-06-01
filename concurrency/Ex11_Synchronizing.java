package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/****************** Exercise 11 *****************
 * Create a class containing two data fields, and a
 * method that manipulates those fields in a multistep
 * process so that, during the execution of that method,
 * those fields are in an "improper state" (according to
 * some definition that you establish). Add methods to
 * read the fields, and create multiple threads to call
 * the various methods and show that the data is visible
 * in its "improper state." Fix the problem using the
 * synchronized keyword.
 ***********************************************/
public class Ex11_Synchronizing {
    public interface DataManipulator {
        void nextStep();

        long getFirst();

        long getLast();
    }

    public static class UnsafeDataManipulator implements DataManipulator {
        private long first = 1L;
        private long last = 2L;

        @Override
        public void nextStep() {
            first++;
            last = 2 * first;
        }

        @Override
        public long getFirst() {
            return first;
        }

        @Override
        public long getLast() {
            return last;
        }
    }

    public static class SafeDataManipulator implements DataManipulator {
        private static final int MAX_LOCK_COUNT = 2;

        private long first = 1L;
        private long last = 2L;
        private int lockCount = 0;

        @Override
        public synchronized void nextStep() {
            while (0 != lockCount) {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    throw new RuntimeException(exception);
                }
            }
            lockCount = MAX_LOCK_COUNT;

            first++;
            last = 2 * first;

            if (0 == first % (100000)) {
                System.out.println(Thread.currentThread().getName() + " " + this);
            }
        }

        @Override
        public synchronized long getFirst() {
            ensureConsistency();
            return first;
        }

        @Override
        public synchronized long getLast() {
            ensureConsistency();
            return last;
        }

        private void ensureConsistency() {
            if (--lockCount == 0) {
                notify();
            } else if (lockCount < 0) {
                throw new IllegalStateException("Property getter couldn't be accessed before nextStep()");
            }
        }

        @Override
        public String toString() {
            return "SafeDataManipulator{" +
                "first=" + first +
                ", last=" + last +
                ", lockCount=" + lockCount +
                '}';
        }
    }

    public static class Checker implements Runnable {
        private final DataManipulator manipulator;

        public Checker(DataManipulator manipulator) {
            this.manipulator = manipulator;
        }

        @Override
        public void run() {
            while (true) {
                manipulator.nextStep();
                long first = manipulator.getFirst();
                long last = manipulator.getLast();
                if (last % first != 0) {
                    System.out.println(
                        "Failed with " + manipulator.getClass().getSimpleName()
                            + ": last = " + last + " first = " + first
                    );
                    return;
                }
            }
        }
    }

    public static void test(DataManipulator manipulator, int threadCount) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++) {
            exec.execute(new Checker(manipulator));
        }
        exec.shutdown();
        exec.awaitTermination(5L, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        test(new UnsafeDataManipulator(), 10);
        test(new SafeDataManipulator(), 10);

        System.exit(0);
    }
}
