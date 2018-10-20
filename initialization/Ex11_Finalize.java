/****************** Exercise 11 ****************
 * Modify Exercise 10 so your
 * finalize() will always be called.
 ***********************************************/
package biz.markov.thinking.initialization;

public class Ex11_Finalize {
    protected void finalize() {
        System.out.println("Finalized"); // Printed in output
    }
    public static void main(String args[]) {
        new Ex11_Finalize();
        System.gc();
        System.runFinalization();
    }
}
