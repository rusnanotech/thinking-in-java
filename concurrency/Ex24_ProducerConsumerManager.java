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
public class Ex24_ProducerConsumerManager implements Runnable {
    private final Consumer consumer;
    private final Producer producer;

    public Ex24_ProducerConsumerManager(Producer producer, Consumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                consumer.consume(producer.produce());
            }
        } catch (InterruptedException exception) {
            System.out.println("Interrupted");
        }
    }

    public static class Producer implements Runnable {
        private int value = 1;
        private final Queue<Integer> buffer = new LinkedList<Integer>();

        public synchronized Integer produce() throws InterruptedException {
            while (buffer.isEmpty()) {
                wait();
            }
            return ensureNotNull(buffer.poll());
        }

        private Integer ensureNotNull(Integer value) {
            if (value == null) {
                throw new IllegalStateException("Empty producer");
            }
            return value;
        }

        @Override
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

        public void consume(Integer value) throws InterruptedException {
            ensureBufferSize();
            synchronized (this) {
                while (!buffer.isEmpty()) {
                    wait();
                }
                buffer.add(value);
            }
        }

        private void ensureBufferSize() {
            if (buffer.size() > 1) {
                throw new IllegalStateException("Consumer overflow");
            }
        }

        @Override
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
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Ex24_ProducerConsumerManager manager = new Ex24_ProducerConsumerManager(producer, consumer);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.execute(manager);

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Terminating. Last producer value: " + producer.value);
        executorService.shutdownNow();
    }
}
