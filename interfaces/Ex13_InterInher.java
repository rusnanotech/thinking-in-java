/****************** Exercise 13 ******************
 * Create an interface, inherit two new
 * interfaces from it, then multiply-inherit
 * a third interface from the second two.
 ***********************************************/
package biz.markov.thinking.interfaces;

interface Ex13_A {
    void f();
}

interface Ex13_B1 extends Ex13_A {
    double g(double x);
    long h(long x);
}

interface Ex13_B2 extends Ex13_A {
    String u();
}

interface Ex13_C extends Ex13_B1, Ex13_B2 {
    void v(char c);
}

public class Ex13_InterInher implements Ex13_C {
    public void f() {}
    public double g(double x) { return 0.0; }
    public long h(long x) { return 0; }
    public String u() { return ""; }
    public void v(char c) { }
    public static void main(String[] args) {
    }
}
