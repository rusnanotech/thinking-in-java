/****************** Exercise 21 ******************
 * Create an interface with a nested class
 * and a static method that calls the methods
 * of your interface and displays the results.
 * Implement your interface and pass an instance of
 * your implementation to the method.
 ***********************************************/
package biz.markov.thinking.innerclasses;

interface Ex21_Interface {
    void f();

    class Nested {
        public static void g(Ex21_Interface b) {
            b.f();
        }
    }
}

public class Ex21 implements Ex21_Interface {
    public void f() {
        System.out.println("f()");
    }

    public static void main(String[] args) {
        Nested.g(new Ex21());
    }
}