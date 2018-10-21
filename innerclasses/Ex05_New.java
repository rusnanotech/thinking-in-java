/****************** Exercise 5 *****************
 * Create a class with an inner class. In a
 * separate class, make an instance of the inner
 * class.
 ***********************************************/
package biz.markov.thinking.innerclasses;

class Ex05_Outer {
    Ex05_Outer() {
        System.out.println("Creating " + getClass().getSimpleName());
    }

    class Ex05_Inner {
        Ex05_Inner() {
            System.out.println("Creating " + getClass().getSimpleName());
        }
    }
}

public class Ex05_New {
    public static void main(String[] args) {
        new Ex05_Outer().new Ex05_Inner();
    }
}
