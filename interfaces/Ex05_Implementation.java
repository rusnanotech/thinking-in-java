/****************** Exercise 5 ******************
 * Create an interface with three methods in its
 * own package. Implement the interface in a
 * different package.
 ***********************************************/
package biz.markov.thinking.interfaces;

import biz.markov.thinking.interfaces.pkg.Ex05_Interface;

public class Ex05_Implementation implements Ex05_Interface {
    String s = "Pi!";

    public void f() {
        g(s);
    }

    public void g(String s) {
        System.out.println("Ex04_Implementation.f(" + s + ")");
    }

    public double h() {
        return 3.14;
    }

    public static void main(String args[]) {
        Ex05_Interface i = new Ex05_Implementation();

        i.f();
        System.out.println(i.h());
    }
}
