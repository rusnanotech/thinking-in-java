package biz.markov.thinking.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/********************** Exercise 25 ***********************
 * In the Chef class in Restaurant.java, return from run()
 * after calling shutdownNow() and observe the difference
 * in behavior.
 ********************** Exercise 26 ***********************
 * Add a BusBoy class to Restaurant.java. After the meal is
 * delivered, the WaitPerson should notify the BusBoy to
 * clean up.
 *********************************************************/
class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable {
    private final Ex26_Restaurant restaurant;

    public WaitPerson(Ex26_Restaurant r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null)
                        wait(); // ... for the chef to produce a meal
                }
                print("Waitperson got " + restaurant.meal);
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
                synchronized (restaurant.busBoy) {
                    restaurant.needsCleanUp = true;
                    restaurant.busBoy.meal = restaurant.meal;
                    restaurant.busBoy.notifyAll();
                }
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // Ready for another
                }
                synchronized (this) {
                    while (restaurant.needsCleanUp)
                        wait(); // ... for the busboy to clean up
                }
            }
        } catch (InterruptedException e) {
            print("WaitPerson interrupted");
        }
    }
}

class BusBoy implements Runnable {
    private final Ex26_Restaurant restaurant;
    volatile Meal meal;

    public BusBoy(Ex26_Restaurant r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (!restaurant.needsCleanUp)
                        wait(); // ... for the waiter to delivery a meal
                }
                print("Cleaning up " + meal);
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
                synchronized (restaurant.waitPerson) {
                    restaurant.needsCleanUp = false;
                    restaurant.waitPerson.notifyAll(); // Ready for another
                }
            }
        } catch (InterruptedException e) {
            print("Busboy interrupted");
        }
    }
}

class Chef implements Runnable {
    private final Ex26_Restaurant restaurant;
    private int count = 0;

    public Chef(Ex26_Restaurant r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null)
                        wait(); // ... for the meal to be taken
                }
                if (++count == 10) {
                    print("Out of food, closing");
                    restaurant.exec.shutdownNow();
                    return;
                }
                print("Order up!");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            }
        } catch (InterruptedException e) {
            print("Chef interrupted");
        }
    }
}

public class Ex26_Restaurant {
    Meal meal;
    boolean needsCleanUp = false;
    final ExecutorService exec = Executors.newCachedThreadPool();
    final WaitPerson waitPerson = new WaitPerson(this);
    final Chef chef = new Chef(this);
    final BusBoy busBoy = new BusBoy(this);

    public Ex26_Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(busBoy);
    }

    public static void main(String[] args) {
        new Ex26_Restaurant();
    }
}
