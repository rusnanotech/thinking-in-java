/****************** Exercise 3 ******************
 * Create a class with a default constructor (one
 * that takes no arguments) that prints a
 * message. Create an object of this class.
 ************************************************/
package biz.markov.thinking.initialization;

class Ex03_Msg {
    Ex03_Msg() {
        System.out.println("Object created by default constructor");
    }
}

public class Ex03 {
    public static void main(String args[]) {
        new Ex03_Msg();
    }
}
