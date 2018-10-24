/****************** Exercise 15 *****************
 * Create a class with a non-default constructor
 * (one with arguments) and no default constructor
 * (no "no-arg" constructor). Create a second class
 * with a method that returns a reference to
 * an object of the first class. Create the object
 * you return by making an anonymous inner
 * class inherit from the first class.
 ***********************************************/
package biz.markov.thinking.innerclasses;

class Ex15_Base {
    private long l;

    Ex15_Base(long l) {
        this.l = l;
    }

    long m() {
        return l;
    }

    void p() {}
}

class Ex15_Second {
    Ex15_Base getBase(long l) {
        return new Ex15_Base(l) {
            void p() {
                System.out.println(m());
            }
        };
    }
}

public class Ex15_NonDefaultConstructor {
    public static void main(String[] args) {
        new Ex15_Second().getBase(25752248).p();
    }
}
