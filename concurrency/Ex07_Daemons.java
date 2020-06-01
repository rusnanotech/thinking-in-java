package biz.markov.thinking.concurrency;

import java.util.concurrent.TimeUnit;

/****************** Exercise 7 *****************
 * Experiment with different sleep times in
 * Daemons.java to see what happens.
 ***********************************************/
public class Ex07_Daemons {

    public static class Task implements Runnable {
        @Override
        public void run() {
            Thread[] threads = new Thread[10];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new SubTask());
            }
            for (int i = 0; i < threads.length; i++) {
                System.out.println(i + " isDaemon: " + threads[i].isDaemon());
            }
            for (;;) {
                Thread.yield();
            }
        }
    }

    public static class SubTask implements Runnable {
        @Override
        public void run() {
            for (;;) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Task());
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(args.length > 0 ? Integer.parseInt(args[0]) : 1);
    }
}
