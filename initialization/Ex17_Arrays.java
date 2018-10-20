/****************** Exercise 17 *****************
 * Create a class with a constructor that takes
 * a String argument. During construction, print
 * the argument. Create an array of object
 * references to this class, but don't
 * create objects to assign into the
 * array. When you run the program, notice
 * whether the initialization messages from the
 * constructor calls are printed.
 ************************************************/
package biz.markov.thinking.initialization;

class Ex17_Type {
    Ex17_Type(String s) {
        System.out.println("Ex17_Type(" + s + ")");
    }
}

public class Ex17_Arrays {
    public static void main(String args[]) {
        Ex17_Type[] a = new Ex17_Type[5];
    }
}
