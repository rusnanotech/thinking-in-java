/****************** Exercise 6 *****************
 * Create an interface with at least one method,
 * in its own package. Create a class in a
 * separate package. Add a protected inner class
 * that implements the interface. In a third
 * package, inherit from your class and, inside a
 * method, return an object of the protected
 * inner class, upcasting to the interface during
 * the return.
 ***********************************************/
// Package 3
package biz.markov.thinking.innerclasses;

import biz.markov.thinking.innerclasses.pkg.Ex06_Interface;
import biz.markov.thinking.innerclasses.pkg2.Ex06_Outer;

public class Ex06_Upcasting extends Ex06_Outer {
    public Ex06_Interface getInner() {
        return new Ex06_Inner();
    }

    public static void main(String[] args) {
        Ex06_Upcasting derived = new Ex06_Upcasting();
        Ex06_Interface inner = derived.getInner();

        inner.f();
        System.out.println(inner.g("ood"));
    }
}
