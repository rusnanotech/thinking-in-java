package biz.markov.thinking.interfaces;

import java.util.Random;

interface My03_Thing {
    void toss();
}

class My03_RandomGenerator {
    private static Random rand = new Random(System.currentTimeMillis());

    public static int getRandom(int i) {
        return rand.nextInt(i);
    }
}

class My03_Coin implements My03_Thing {
    private final static String[] sides = { "Heads", "Tails" };

    public void toss() {
        System.out.println(sides[My03_RandomGenerator.getRandom(2)]);
    }
}

class My03_Dice implements My03_Thing {
    public void toss() {
        System.out.println(1 + My03_RandomGenerator.getRandom(6));
    }
}

public class My03_Ex19_WithoutFactory {
    public static void play(My03_Thing t) {
        t.toss();
    }

    public static void main(String[] args) {
        System.out.println("\nTossing coin:");
        My03_Coin c = new My03_Coin();
        for (int i = 0; i < 10; i++)
            play(c);

        System.out.println("\nTossing dice:");
        My03_Dice d = new My03_Dice();
        for (int i = 0; i < 10; i++)
            play(d);
    }
}
