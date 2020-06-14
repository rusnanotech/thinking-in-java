package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/********************** Exercise 23 ***********************
 * Demonstrate that WaxOMatic.java works when
 * you use notify() instead of notifyAll().
 *********************************************************/
class Car {
    private boolean waxOn = false;
    private int waxedCount = 0;
    private int buffedCount = 0;

    public synchronized void waxed() {
        waxOn = true; // Ready to buff
        notify();
        waxedCount--;
        checkCount(waxedCount);
    }

    public synchronized void buffed() {
        waxOn = false; // Ready for another coat of wax
        notify();
        buffedCount--;
        checkCount(buffedCount);
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        waxedCount++;
        while (!waxOn) {
            wait();
        }
        checkCount(waxedCount);
    }

    public synchronized void waitForBuffing() throws InterruptedException {
        buffedCount++;
        while (waxOn) {
            wait();
        }
        checkCount(buffedCount);
    }

    private void checkCount(int count) {
        if (count != 0) {
            throw new RuntimeException("waitCount = " + waxedCount);
        }
    }
}

class WaxOn implements Runnable {
    private final Car car;

    public WaxOn(Car c) {
        car = c;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                printnb("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax On task");
    }
}

class WaxOff implements Runnable {
    private final Car car;

    public WaxOff(Car c) {
        car = c;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                printnb("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupt");
        }
        print("Ending Wax Off task");
    }
}

public class Ex23_WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
}