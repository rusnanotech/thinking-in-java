/****************** Exercise 9 *****************
 * Create an interface with at least one method,
 * and implement it by defining an
 * inner class within a method that returns a
 * reference to your interface.
 ***********************************************/
package biz.markov.thinking.innerclasses;

class Ex09_Outer {
    Ex09_Interface g() {
        class Inner implements Ex09_Interface {
            public void f() {
                System.out.println("f()");
            }
        }

        return new Inner();
    }
}

public class Ex09_WithinMethod {
    public static void main(String[] args) {
        Ex09_Interface a = new Ex09_Outer().g();

        a.f();
    }
}
