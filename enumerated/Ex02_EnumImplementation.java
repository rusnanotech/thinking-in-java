/****************** Exercise 2 *****************
 * Instead of implementing an interface, make
 * next() a static method. What are the benefits
 * and drawbacks of this approach?
 ***********************************************/
package biz.markov.thinking.enumerated;

import java.util.Random;

enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private static Random rand = new Random(47);

    public static CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class Ex02_EnumImplementation {
    public static <T> void printNext() {
        System.out.print(CartoonCharacter.next() + ", ");
    }

    public static void main(String[] args) {
        // Choose any instance:
        for (int i = 0; i < 10; i++)
            printNext();
    }
} /* Output:
BOB, PUNCHY, BOB, SPANKY, NUTTY, PUNCHY, SLAPPY, NUTTY, NUTTY, SLAPPY,
*///:~
