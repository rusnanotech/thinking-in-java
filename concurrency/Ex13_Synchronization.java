package biz.markov.thinking.concurrency;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/****************** Exercise 13 *****************
 * Repair SerialNumberChecker.java using the
 * synchronized keyword. Can you demonstrate that
 * it is now correct?
 ***********************************************/
public class Ex13_Synchronization {
    public static class CircuitSet {
        private final int[] data;
        private int index = 0;

        public CircuitSet(int size) {
            data = new int[size];
            Arrays.fill(data, -1);
        }

        public synchronized boolean add(int value) {
            if (contains(value)) {
                return false;
            } else {
                data[index++ % data.length] = value;
                return true;
            }
        }

        public synchronized boolean contains(int value) {
            for (int element : data) {
                if (element == value) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class NumberGenerator {
        private volatile int value = 0;
        private boolean isTerminated = false;

        public int next() {
            return value++;
        }

        public synchronized void terminate() {
            isTerminated = true;
        }

        public synchronized boolean isTerminated() {
            return isTerminated;
        }

        @Override
        public String toString() {
            return "NumberGenerator{" +
                "value=" + value +
                ", isTerminated=" + isTerminated +
                '}';
        }
    }

    public static class SynchronizedNumberGenerator extends NumberGenerator {

        public synchronized int next() {
            return super.next();
        }
    }

    public static class GeneratorTester implements Runnable {
        private final CircuitSet circuitSet = new CircuitSet(1000);
        private final NumberGenerator generator;

        public GeneratorTester(NumberGenerator generator) {
            this.generator = generator;
        }

        @Override
        public void run() {
            while (!generator.isTerminated()) {
                int number = generator.next();
                if (!circuitSet.add(number)) {
                    generator.terminate();
                    System.out.println(generator.getClass().getSimpleName() + " test - failed: " + number);
                    break;
                }
            }
        }
    }

    public static void test(final NumberGenerator generator) {
        final String generatorName = generator.getClass().getSimpleName();
        System.out.println(generatorName + " test - started");

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new GeneratorTester(generator));
        executorService.execute(new GeneratorTester(generator));
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (generator.isTerminated()) {
                        break;
                    }
                    System.out.println(generatorName + ": " + generator);
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Starting tests");
        System.out.println("Press enter to terminate\n");

        test(new NumberGenerator());
        test(new SynchronizedNumberGenerator());

        System.in.read();
        System.exit(0);
    }
}
