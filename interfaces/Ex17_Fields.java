/****************** Exercise 17 ******************
 * Prove that the fields in an interface are
 * implicitly static and final.
 ***********************************************/
package biz.markov.thinking.interfaces;

interface Ex17_I {
    int NUM = 25;
}

public class Ex17_Fields implements Ex17_I {
    public static void main(String[] args) {

        // 1. Accessibility of static field inside static
        // main method without of creating object:
        System.out.println(NUM);

        // 2. Impossibility to change final value:
        //! NUM++;
    }
}
