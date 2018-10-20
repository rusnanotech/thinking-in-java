/****************** Exercise 3 ******************
 * Even if you don't create a constructor for
 * Cartoon(), the compiler will synthesize a
 * default constructor that calls the base-class
 * constructor. Prove that assertion.
 ***********************************************/
package biz.markov.thinking.reusing;
import static net.mindview.util.Print.*;

class Ex03_Art {
  Ex03_Art() { print("Ex03_Art constructor"); }
}

class Ex03_Drawing extends Ex03_Art {
  // Removed constructor
  // Ex03_Drawing() { print("Ex03_Drawing constructor"); }
}

public class Ex03_DefaultConstructor {
    public static void main(String args[]) {
        new Ex03_Drawing();
    }
}

/* Output:
Ex03_Art constructor
*///:~
