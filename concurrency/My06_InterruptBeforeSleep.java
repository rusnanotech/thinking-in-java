package biz.markov.thinking.concurrency;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * My06_InterruptBeforeSleep.
 *
 * @author Vasily_Markov
 */
public class My06_InterruptBeforeSleep {
    static void m() {
        try {
            System.out.println("Waiting for input");
            System.in.read();
            TimeUnit.SECONDS.sleep(10);
            System.out.println("Not interrupted");
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public static void main(String[] args) {
        Thread th = new Thread() {
            public void run() {
                m();
            }
        };

        th.start();
        th.interrupt();
    }
}
