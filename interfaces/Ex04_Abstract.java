/****************** Exercise 4 *****************
 * Create an abstract class with no methods.
 * Derive a class and add a method. Create a
 * static method that downcasts a reference from
 * the base class to the derived class and calls
 * the method. Demonstrate that it works in main().
 * Eliminate the need for the downcast by moving
 * the abstract declaration to the base class.
 ***********************************************/
package biz.markov.thinking.interfaces;

abstract class Ex04_Base {
    abstract void print();
}

class Ex04_Derived extends Ex04_Base {
    void print() {
        System.out.println("Ex04_Derived.print()");
    }
}

public class Ex04_Abstract {
    static void callWithCast(Ex04_Base base) {
        ((Ex04_Derived)base).print();
    }

    static void call(Ex04_Base base) {
        base.print();
    }

    public static void main(String args[]) {
        Ex04_Derived derived = new Ex04_Derived();

        call(derived);
        callWithCast(derived);
    }
}
