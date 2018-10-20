/****************** Exercise 1 ****************
 * Create a Cycle class, with subclasses
 * Unicycle, Bicycle, and Tricycle. Demonstrate
 * that an instance of each type can be upcast
 * to Cycle via a ride() method.
 ***********************************************/
package biz.markov.thinking.polymorphism;
import biz.markov.thinking.polymorphism.ex01cycles.*;

public class Ex01_Upcast {
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
