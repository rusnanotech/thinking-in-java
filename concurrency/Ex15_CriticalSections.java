package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/****************** Exercise 15 ************************
 * Create a class with three methods containing critical
 * sections that all synchronize on the same object. Create
 * multiple tasks to demonstrate that only one of these
 * methods can run at a time. Now modify the methods so
 * that each one synchronizes on a different object and
 * show that all three methods can be running at once.
 ******************************************************/
public class Ex15_CriticalSections {
    void onSame1() {
        synchronized (this) {
            count("onSame1()");
        }
    }

    void onSame2() {
        synchronized (this) {
            count("onSame2()");
        }
    }

    void onSame3() {
        synchronized (this) {
            count("onSame3()");
        }
    }

    enum Monitor {M1, M2, M3}

    void onDifferent1() {
        synchronized (Monitor.M1) {
            count("onDifferent1()");
        }
    }

    void onDifferent2() {
        synchronized (Monitor.M2) {
            count("onDifferent2()");
        }
    }

    void onDifferent3() {
        synchronized (Monitor.M3) {
            count("onDifferent3()");
        }
    }

    private void count(String msg) {
        for (int i = 0; i < 5; i++) {
            System.out.println(msg + ": " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException ignored) {
            }
            Thread.yield();
        }
    }

    public static void test(final Ex15_CriticalSections criticalSections) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            public void run() {
                criticalSections.onSame1();
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                criticalSections.onSame2();
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                criticalSections.onSame3();
            }
        });

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ignored) {
        }
        System.out.println();

        executorService.execute(new Runnable() {
            public void run() {
                criticalSections.onDifferent1();
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                criticalSections.onDifferent2();
            }
        });
        executorService.execute(new Runnable() {
            public void run() {
                criticalSections.onDifferent3();
            }
        });

        executorService.shutdown();
    }

    public static void main(String[] args) {
        test(new Ex15_CriticalSections());
    }
}
