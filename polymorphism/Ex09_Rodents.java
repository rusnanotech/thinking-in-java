/****************** Exercise 9 *****************
 * Create an inheritance hierarchy of Rodent:
 * Mouse, Gerbil, Hamster, etc. In the base
 * class, provide methods that are common to all
 * Rodents, and override these in the derived
 * classes to perform different behaviors
 * depending on the specific type of Rodent.
 * Create an array of Rodent, fill it with
 * different specific types of Rodents, and call
 * your base-class methods to see what happens.
 ***********************************************/
package biz.markov.thinking.polymorphism;

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

public class Ex09_Rodents {
    public static void main(String args[]) {
        Rodent[] rodents = { new Rodent(), new Hamster(), new Mouse(), new Gerbil(), };

        for (Rodent rodent : rodents)
            System.out.println(rodent);
    }
}
