/****************** Exercise 1 *****************
 * Modify Exercise 9 in the previous chapter so
 * Rodent is an abstract class. Make the
 * methods of Rodent abstract whenever possible.
 ***********************************************/
package biz.markov.thinking.interfaces;

abstract class Rodent {
    public abstract String toString ();
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

public class Ex01_Abstract {
    public static void main(String args[]) {
        Rodent[] rodents = { /*! new Rodent(),*/ new Hamster(), new Mouse(), new Gerbil(), };

        for (Rodent rodent : rodents)
            System.out.println(rodent);
    }
}
