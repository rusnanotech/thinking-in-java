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
// Package 2
package biz.markov.thinking.innerclasses.pkg2;

import biz.markov.thinking.innerclasses.pkg.Ex06_Interface;

public class Ex06_Outer {
    protected class Ex06_Inner implements Ex06_Interface {
        //  If the following public constructor doesn't exist
        //  creating of object directly within derived class
        //  won't be available.
        public Ex06_Inner() {}

        public void f() {
            System.out.print("Very ");
        }

        public String g(Object s) {
            return "g(" + s + ")";
        }
    }
}

