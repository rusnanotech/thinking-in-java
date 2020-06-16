package biz.markov.thinking.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.util.Print.print;

/********************** Exercise 27 ***********************
 * Modify Restaurant.java to use explicit Lock and Condition
 * objects.
 *********************************************************/
class WaitPerson2 implements Runnable {
    private final Ex27_Restaurant restaurant;
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    public WaitPerson2(Ex27_Restaurant r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant.meal == null)
                        condition.await(); // ... for the chef to produce a meal
                } finally {
                    lock.unlock();
                }
                print("Waitperson got " + restaurant.meal);
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
                restaurant.busBoy.lock.lock();
                try {
                    restaurant.needsCleanUp = true;
                    restaurant.busBoy.meal = restaurant.meal;
                    restaurant.busBoy.condition.signalAll();
                } finally {
                    restaurant.busBoy.lock.unlock();
                }
                restaurant.chef.lock.lock();
                try {
                    restaurant.meal = null;
                    restaurant.chef.condition.signalAll(); // Ready for another
                } finally {
                    restaurant.chef.lock.unlock();
                }
                lock.lock();
                try {
                    while (restaurant.needsCleanUp)
                        condition.await(); // ... for the busboy to clean up
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}

class BusBoy2 implements Runnable {
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();
    private final Ex27_Restaurant restaurant;
    volatile Meal meal;

    public BusBoy2(Ex27_Restaurant r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (!restaurant.needsCleanUp)
                        condition.await(); // ... for the waiter to delivery a meal
                } finally {
                    lock.unlock();
                }
                print("Cleaning up " + meal);
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
                restaurant.waitPerson.lock.lock();
                try {
                    restaurant.needsCleanUp = false;
                    restaurant.waitPerson.condition.signalAll(); // Ready for another
                } finally {
                    restaurant.waitPerson.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            print("Busboy interrupted");
        }
    }
}

class Chef2 implements Runnable {
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();
    private final Ex27_Restaurant restaurant;
    private int count = 0;

    public Chef2(Ex27_Restaurant r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant.meal != null)
                        condition.await(); // ... for the meal to be taken
                } finally {
                    lock.unlock();
                }
                if (++count == 10) {
                    print("Out of food, closing");
                    restaurant.exec.shutdownNow();
                    return;
                }
                print("Order up!");
                restaurant.waitPerson.lock.lock();
                try {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.condition.signalAll();
                } finally {
                    restaurant.waitPerson.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }
}

public class Ex27_Restaurant {
    Meal meal;
    boolean needsCleanUp = false;
    final ExecutorService exec = Executors.newCachedThreadPool();
    final WaitPerson2 waitPerson = new WaitPerson2(this);
    final Chef2 chef = new Chef2(this);
    final BusBoy2 busBoy = new BusBoy2(this);

    public Ex27_Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(busBoy);
    }

    public static void main(String[] args) {
        new Ex27_Restaurant();
    }
}
