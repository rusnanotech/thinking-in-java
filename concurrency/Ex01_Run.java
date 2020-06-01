package biz.markov.thinking.concurrency;

/****************** Exercise 1 *****************
 * Implement a Runnable. Inside run(), print a
 * message, and then call yield(). Repeat this
 * three times, and then return from run(). Put
 * a startup message in the constructor and a
 * shutdown message when the task terminates. Create
 * a number of these tasks and drive them using
 * threads.
 ***********************************************/
public class Ex01_Run {

    public static class Task implements Runnable {
        private static int count = 0;

        private final int id = count++;
        private final int cycles;

        public Task() {
            this(5);
        }

        public Task(int cycles) {
            this.cycles = cycles;
            System.out.println("#" + id + " creating");
        }

        @Override
        public void run() {
            for (int i = 1; i < cycles; i++) {
                System.out.println("#" + id + " " + i);
                Thread.yield();
            }
            System.out.println("#" + id + " " + cycles + " end");
        }
    }

    public static void main(String[] args) {
        System.out.println("main - start");

        for (int i = 0; i < 10000; i++) {
            new Thread(new Task()).start();
        }

        System.out.println("main - end");
    }
}
