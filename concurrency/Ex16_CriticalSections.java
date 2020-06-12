package biz.markov.thinking.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/****************** Exercise 16 ************************
 * Modify Exercise 15 to use explicit Lock objects.
 ******************************************************/
public class Ex16_CriticalSections extends Ex15_CriticalSections {
    private final Lock[] locks = {
        new ReentrantLock(),
        new ReentrantLock(),
        new ReentrantLock(),
        new ReentrantLock(),
    };

    @Override
    void onSame1() {
        count(locks[0], "onSameObject1()");
    }

    @Override
    void onSame2() {
        count(locks[0], "onSameObject2()");
    }

    @Override
    void onSame3() {
        count(locks[0], "onSameObject3()");
    }

    @Override
    void onDifferent1() {
        count(locks[1], "onDifferent1()");
    }

    @Override
    void onDifferent2() {
        count(locks[2], "onDifferent2()");
    }

    @Override
    void onDifferent3() {
        count(locks[3], "onDifferent3()");
    }

    private void count(Lock lock, String msg) {
        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(msg + ": " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException ignored) {
                }
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        test(new Ex16_CriticalSections());
    }
}
