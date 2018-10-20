/****************** Exercise 10 *****************
 * Create a base class with two methods. In the
 * first method, call the second method. Inherit
 * a class and override the second method. Create
 * an object of the derived class, upcast it to
 * the base type, and call the first method.
 * Explain what happens.
 ***********************************************/
package biz.markov.thinking.polymorphism;

public class Ex10 {
    public static void main(String[] args) {
        biz.markov.thinking.polymorphism.shape.Ex10.main(args);
    }
}
