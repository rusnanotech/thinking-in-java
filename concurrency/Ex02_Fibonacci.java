package biz.markov.thinking.concurrency;

/****************** Exercise 2 *****************
 * Following the form of generics/Fibonacci.java,
 * create a task that produces a sequence of n
 * Fibonacci numbers, where n is provided to the
 * constructor of the task. Create a number of these
 * tasks and drive them using threads.
 ***********************************************/
public class Ex02_Fibonacci {
    public static class Task implements Runnable {
        private static int count = 0;

        private final int id = count++;
        private final int max;

        public Task() {
            this(10);
        }

        public Task(int max) {
            this.max = max;
        }

        @Override
        public void run() {
            for (int i = 0; i < max; i++) {
                System.out.println("#" + id + " " + fib(i));
            }
        }

        private int fib(int n) {
            Thread.yield();
            if (n < 2) {
                return 1;
            }
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Task()).start();
        }
    }
}
