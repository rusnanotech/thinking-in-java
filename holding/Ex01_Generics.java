/****************** Exercise 1 ******************
 * Create a new class called Gerbil with an int
 * gerbilNumber initialized in the constructor.
 * Give it a method called hop() that prints out
 * which gerbil number this is, and that it’s hopping.
 * Create an ArrayList and add Gerbil objects to
 * the List. Now use the get() method to move
 * through the List and call hop() for each Gerbil.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.ArrayList;

class Ex01_Gerbil {
    private static int counter = 0;
    private final int gerbilNumber;

    Ex01_Gerbil() {
        gerbilNumber = counter++;
    }

    void hop() {
        System.out.println("Gerbil " + gerbilNumber + " is hoping");
    }
}

public class Ex01_Generics {
    public static void main(String[] args) {
        ArrayList<Ex01_Gerbil> gerbils = new ArrayList<Ex01_Gerbil>();

        for (int i = 0; i < 8; i++)
            gerbils.add(new Ex01_Gerbil());

        for (Ex01_Gerbil gerbil : gerbils)
            gerbil.hop();
    }
}
