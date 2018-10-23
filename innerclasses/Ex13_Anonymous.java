/****************** Exercise 13 *****************
 * Repeat Exercise 9 using an anonymous inner
 * class.
 ***********************************************/
package biz.markov.thinking.innerclasses;

class Ex13_Outer {
    Ex09_Interface g() {
        return new Ex09_Interface() {
            public void f() {
                System.out.println("f()");
            }
        };
    }
}

public class Ex13_Anonymous {
    public static void main(String[] args) {
        Ex09_Interface a = new Ex13_Outer().g();

        a.f();
    }
}
