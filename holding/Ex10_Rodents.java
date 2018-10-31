/****************** Exercise 10 ******************
 * change Exercise 9 in the Polymorphism chapter
 * to use an ArrayList to hold the Rodents and an
 * Iterator to move through their sequence.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

class Rodent {
    public String toString () {
        return "Rodent";
    }
}

class Hamster extends Rodent {
    public String toString () {
        return "Hamster";
    }
}

class Mouse extends Rodent {
    public String toString () {
        return "Mouse";
    }
}

class Gerbil extends Mouse {
    public String toString () {
        return "Gerbil";
    }
}

public class Ex10_Rodents {
    public static void main(String args[]) {
        List<Rodent> rodents = new ArrayList<Rodent>
                (Arrays.asList(new Rodent(), new Hamster(),
                        new Mouse(), new Gerbil()));

        for (Iterator<Rodent> itr = rodents.iterator();
              itr.hasNext();
              System.out.println(itr.next()));
    }
}
