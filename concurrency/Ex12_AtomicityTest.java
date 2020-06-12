package biz.markov.thinking.concurrency;

import java.io.IOException;

/****************** Exercise 12 *****************
 * Repair AtomicityTest.java using the synchronized
 * keyword. Can you demonstrate that it is now
 * correct?
 ***********************************************/
public class Ex12_AtomicityTest {
    static class Incrementer implements Runnable {
        protected int value = 0;

        public int getValue() {
            return value;
        }

        public synchronized void increment() {
            value++;
            value++;
        }

        @Override
        public void run() {
            while (true) {
                increment();
            }
        }
    }

    static class RepairedIncrementer extends Incrementer {

        @Override
        public synchronized int getValue() {
            return value;
        }
    }

    public static void test(final Incrementer incrementer) {
        final String className = incrementer.getClass().getSimpleName();

        new Thread(
            new Runnable() {
                @Override
                public void run() {
                    System.out.println(className + " test - start");
                    new Thread(incrementer).start();
                    while (true) {
                        int value = incrementer.getValue();
                        if (value % 2 != 0) {
                            System.out.println(className + ": " + value + " - not passed");
                            break;
                        }
                    }
                }
            }
        ).start();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Starting tests");
        System.out.println("Press enter to terminate\n");

        test(new Incrementer());
        test(new RepairedIncrementer());

        System.in.read();
        System.exit(0);
    }
}
