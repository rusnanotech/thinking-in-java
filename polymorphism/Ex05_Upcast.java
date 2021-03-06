/****************** Exercise 5 ****************
 * Starting from Exercise 1, add a wheels()
 * method in Cycle, which returns the number of
 * wheels. Modify ride() to call wheels() and
 * verify that polymorphism works.
 ***********************************************/
package biz.markov.thinking.polymorphism;

import biz.markov.thinking.polymorphism.ex05cycles.*;

public class Ex05_Upcast {
    static void testDrive(Cycle c) {
        c.ride();
    }

    public static void main(String args[]) {
        Cycle cycle = new Cycle();
        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();

        testDrive(cycle);
        testDrive(unicycle);
        testDrive(bicycle);
        testDrive(tricycle);
    }
}
