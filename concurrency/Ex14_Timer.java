package biz.markov.thinking.concurrency;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/****************** Exercise 14 ************************
 * Demonstrate that java.util.Timer scales to large numbers
 * by creating a program that generates many Timer objects
 * that perform some simple task when the timeout completes.
 ******************************************************/
public class Ex14_Timer {
    private static final int MAX_DELAY = 10;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Timer timer = new Timer();

        for (int i = 0; i < 10; i++) {
            final int delay = random.nextInt(MAX_DELAY);
            timer.schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        System.out.println(delay + " " + this);
                    }
                },
                1000 * delay
            );
        }

        TimeUnit.SECONDS.sleep(10);
        System.exit(0);
    }
}
