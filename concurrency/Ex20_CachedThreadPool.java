package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/****************** Exercise 20 ************************
 * Modify CachedThreadPool.java so that all tasks receive
 * an interrupt() before they are completed.
 ******************************************************/
public class Ex20_CachedThreadPool {
    public static class LiftOff implements Runnable {
        protected int countDown = 10; // Default
        private static int taskCount = 0;
        private final int id = taskCount++;

        public LiftOff() {
        }

        public LiftOff(int countDown) {
            this.countDown = countDown;
        }

        public String status() {
            return "#" + id + "(" +
                    (countDown > 0 ? countDown  + "), ": "Liftoff!)\n");
        }

        public void run() {
            while (!Thread.interrupted() && countDown-- > 0) {
                System.out.print(status());
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff(1000));
        Thread.yield();
        exec.shutdownNow();
    }
}
