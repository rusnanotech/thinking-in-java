/****************** Exercise 3 *****************
 * Create a base class with an abstract print()
 * method that is overridden in a derived class.
 * The overridden version of the method prints
 * the value of an int variable defined in the
 * derived class. Define this variable with a
 * nonzero value. Call print() in the
 * base-class constructor. Create an object of
 * the derived type in main(), then call its
 * print() method. Explain the results.
 ***********************************************/
package biz.markov.thinking.interfaces;

abstract class Ex03_Base {
    Ex03_Base() {
        print();
    }

    abstract void print();
}

class Ex03_Derived extends Ex03_Base {
    private int i = 23;

    void print() {
        System.out.println(i);
    }
}

public class Ex03_Abstract {
    public static void main(String args[]) {
        new Ex03_Derived().print();
    }
}
/* Output:
0
23
 */