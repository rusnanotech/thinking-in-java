/****************** Exercise 17 ******************
 * Use anonymous inner classes to modify the solution
 * to Exercise 19 from the Interfaces chapter.
 ***********************************************/
package biz.markov.thinking.innerclasses;

import java.util.Random;

interface Thing {
    void toss();
}

interface ThingFactory {
    Thing getThing();
}

class RandomGenerator {
    private static Random rand = new Random(System.currentTimeMillis());

    public static int getRandom(int i) {
        return rand.nextInt(i);
    }
}

class Coin implements Thing {
    private Coin() {}
    private final static String[] sides = { "Heads", "Tails" };

    public void toss() {
        System.out.println(sides[RandomGenerator.getRandom(2)]);
    }

    public static ThingFactory factory =
        new ThingFactory() {
            public Thing getThing () {
                return new Coin();
            }
        };
}

class Dice implements Thing {
    private Dice() {}
    public void toss() {
        System.out.println(1 + RandomGenerator.getRandom(6));
    }

    public static ThingFactory factory =
        new ThingFactory() {
            public Thing getThing () {
                return new Dice();
            }
        };
}

public class Ex17_FactoryFramework {
    public static void play(final ThingFactory tf, final int n) {
        Thing t = tf.getThing();
        for (int i = 0; i < n; i++)
            t.toss();
    }

    public static void main(String[] args) {
        System.out.println("\nTossing coin:");
        play(Coin.factory, 10);

        System.out.println("\nTossing dice:");
        play(Dice.factory, 10);
    }
}
