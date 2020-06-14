package biz.markov.thinking.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/********************** Exercise 24 ***********************
 * Solve a single-producer, single-consumer problem using
 * wait() and notifyAll(). The producer must not overflow
 * the receiver’s buffer, which can happen if the producer
 * is faster than the consumer. If the consumer is faster
 * than the producer, then it must not read the same data
 * more than once. Do not assume anything about the relative
 * speeds of the producer or consumer.
 *********************************************************/
public class Ex24_ProducerConsumer {
    public static class Producer implements Runnable {
        private int value = 1;
        private final Queue<Integer> buffer = new LinkedList<Integer>();

        public synchronized Integer produce() {
            try {
                while (buffer.isEmpty()) {
                    wait();
                }
                return buffer.poll();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void run() {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    if (buffer.isEmpty()) {
                        buffer.add(value++);
                        notifyAll();
                    }
                }
            }
        }
    }

    public static class Consumer implements Runnable {
        private final Queue<Integer> buffer = new LinkedList<Integer>();

        public synchronized void consume(Integer value) {
            if (value == null) {
                throw new IllegalStateException("Empty producer");
            }
            if (buffer.size() > 1) {
                throw new IllegalStateException("Consumer overflow");
            }

            try {
                while (!buffer.isEmpty()) {
                    wait();
                }
                buffer.add(value);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void run() {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    buffer.clear();
                    notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Producer producer = new Producer();
        final Consumer consumer = new Consumer();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(consumer);
        executorService.execute(producer);
        TimeUnit.SECONDS.sleep(1);
        executorService.execute(new Runnable() {
            public void run() {
                while (!Thread.interrupted()) {
                    consumer.consume(producer.produce());
                    if (producer.value % 10000 == 0) {
                        System.out.println(producer.value);
                    }
                }
            }
        });

        TimeUnit.SECONDS.sleep(10);
        System.out.println("Terminating: " + producer.value);
        System.exit(0);
    }
}
