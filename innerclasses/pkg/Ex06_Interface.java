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
// Package 1
package biz.markov.thinking.innerclasses.pkg;

public interface Ex06_Interface {
    void f();
    Object g(Object o);
}
