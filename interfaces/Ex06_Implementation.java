/****************** Exercise 6 ******************
 * Prove that all the methods in an interface are
 * automatically public.
 ***********************************************/
package biz.markov.thinking.interfaces;

import biz.markov.thinking.interfaces.pkg.Ex05_Interface;

public class Ex06_Implementation implements Ex05_Interface {
    //! void f() {}
    public void f() {}

    //! void g(String s) {}
    public void g(String s) {}

    //! double h() { return 3.14; }
    public double h() { return 3.14; }

    public static void main(String args[]) {
    }
}
