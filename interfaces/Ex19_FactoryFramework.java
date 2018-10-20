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
    public static void play(ThingFactory tf) {
        Thing t = tf.getThing();
        t.toss();
    }

    public static void main(String[] args) {
        System.out.println("\nTossing coin:");
        CoinFactory cf = new CoinFactory();
        for (int i = 0; i < 10; i++)
            play(cf);

        System.out.println("\nTossing dice:");
        DiceFactory df = new DiceFactory();
        for (int i = 0; i < 10; i++)
            play(df);
    }
}
