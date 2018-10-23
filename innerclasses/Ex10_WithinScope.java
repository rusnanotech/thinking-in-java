/****************** Exercise 10 *****************
 * Repeat Exercise 9 but define the inner
 * class within a scope within a method.
 ************************************************/
package biz.markov.thinking.innerclasses;

class Ex10_Outer {
    Ex09_Interface g(boolean b) {
        if (b) {
            class InnerA implements Ex09_Interface {
                public void f() {
                    System.out.println("InnerA.f()");
                }
            }

            return new InnerA();
        } else {
            class InnerB implements Ex09_Interface {
                public void f() {
                    System.out.println("InnerB.f()");
                }
            }

            return new InnerB();
        }
    }
}


public class Ex10_WithinScope {
    public static void main(String[] args) {
        Ex09_Interface a = new Ex10_Outer().g(true);
        Ex09_Interface b = new Ex10_Outer().g(false);

        a.f();
        b.f();
    }
}
