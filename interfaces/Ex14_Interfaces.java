/****************** Exercise 14 ******************
 * Create three interfaces, each with two methods.
 * Inherit a new interface from each, adding
 * a new method. Use the new interface to create
 * a class, and inherit from a concrete class.
 * Now write four methods, each of which takes one
 * of the four interfaces as an argument. Create
 * an object of your class in main(), and pass it
 * to each of the methods.
 ***********************************************/
package biz.markov.thinking.interfaces;

interface Ex14_A1 {
    void a1();
    void a2();
}

interface Ex14_B1 {
    void b1();
    void b2();
}

interface Ex14_C1 {
    void c1();
    void c2();
}

interface Ex14_D2 extends Ex14_A1, Ex14_B1, Ex14_C1 {
    void d();
}

class Ex14_E1 {
    public void e() {
        System.out.println(getClass().getSimpleName() + ".e()");
    }
}

class Ex14_F2 extends Ex14_E1 implements Ex14_D2 {
    public void a1() {
        System.out.println(getClass().getSimpleName() + ".a1()");
    }
    public void a2() {
        System.out.println(getClass().getSimpleName() + ".a2()");
    }
    public void b1() {
        System.out.println(getClass().getSimpleName() + ".b1()");
    }
    public void b2() {
        System.out.println(getClass().getSimpleName() + ".b2()");
    }
    public void c1() {
        System.out.println(getClass().getSimpleName() + ".c1()");
    }
    public void c2() {
        System.out.println(getClass().getSimpleName() + ".c2()");
    }
    public void d() {
        System.out.println(getClass().getSimpleName() + ".d()");
    }
}

public class Ex14_Interfaces {
    public static void a(Ex14_A1 a) {
        a.a1();
        a.a2();
    }
    public static void b(Ex14_B1 b) {
        b.b1();
        b.b2();
    }
    public static void c(Ex14_C1 c) {
        c.c1();
        c.c2();
    }
    public static void d(Ex14_D2 d) {
        d.d();
    }
    public static void e(Ex14_E1 e) {
        e.e();
    }
    public static void main(String[] args) {
        Ex14_F2 x = new Ex14_F2();
        a(x);
        b(x);
        c(x);
        d(x);
        e(x);
    }
}