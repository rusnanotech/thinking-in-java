/****************** Exercise 10 *****************
 * Create a class with a finalize() method that
 * prints a message. In main(), create an object
 * of your class. Explain the behavior of your
 * program.
 ************************************************/
package biz.markov.thinking.initialization;

public class Ex10_Finalize {
    protected void finalize() {
        System.out.println("Finalized"); // Not printed in output
    }
    public static void main(String args[]) {
        new Ex10_Finalize();
    }
}
