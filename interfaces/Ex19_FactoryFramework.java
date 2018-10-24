/****************** Exercise 19 ******************
 * Create a framework using Factory Methods that
 * performs both coin tossing and dice tossing.
 ***********************************************/
package biz.markov.thinking.interfaces;

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
    private final static String[] sides = { "Heads", "Tails" };

    public void toss() {
        System.out.println(sides[RandomGenerator.getRandom(2)]);
    }
}

class Dice implements Thing {
    public void toss() {
        System.out.println(1 + RandomGenerator.getRandom(6));
    }
}

class CoinFactory implements ThingFactory {
    public Thing getThing() {
        return new Coin();
    }
}

class DiceFactory implements ThingFactory {
    public Thing getThing() {
        return new Dice();
    }
}

public class Ex19_FactoryFramework {
    public static void play(final ThingFactory tf, final int n) {
        Thing t = tf.getThing();
        for (int i = 0; i < n; i++)
            t.toss();
    }

    public static void main(String[] args) {
        System.out.println("\nTossing coin:");
        CoinFactory cf = new CoinFactory();
        play(cf, 10);

        System.out.println("\nTossing dice:");
        DiceFactory df = new DiceFactory();
        play(df, 10);
    }
}
