/****************** Exercise 20 *****************
 * Create an interface containing a nested class.
 * Implement this interface and create an
 * instance of the nested class.
 ***********************************************/
package biz.markov.thinking.innerclasses;

interface Ex20_Interface {
    void f();

    class Nested {
        void g() {
            System.out.println("Nested.g()");
        }
    }
}

public class Ex20 implements Ex20_Interface {
    public void f() {
    }

    public static void main(String[] args) {
        Nested n = new Nested();
        n.g();
    }
}
