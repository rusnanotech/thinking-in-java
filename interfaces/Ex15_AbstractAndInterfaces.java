/****************** Exercise 15 ******************
 * Modify Exercise 14 by creating an abstract class
 * and inheriting it into the derived class.
 ***********************************************/
package biz.markov.thinking.interfaces;

interface Ex15_A1 {
    void a1();
    void a2();
}

interface Ex15_B1 {
    void b1();
    void b2();
}

interface Ex15_C1 {
    void c1();
    void c2();
}

interface Ex15_D2 extends Ex15_A1, Ex15_B1, Ex15_C1 {
    void d();
}

/* Modified class */
abstract class Ex15_E1 {
    public void e() {
        System.out.println(getClass().getSimpleName() + ".e()");
    }
    abstract void f();
}

class Ex15_F2 extends Ex15_E1 implements Ex15_D2 {
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
    public void f() {
        System.out.println(getClass().getSimpleName() + ".f()");
    }
}

public class Ex15_AbstractAndInterfaces {
    public static void a(Ex15_A1 a) {
        a.a1();
        a.a2();
    }
    public static void b(Ex15_B1 b) {
        b.b1();
        b.b2();
    }
    public static void c(Ex15_C1 c) {
        c.c1();
        c.c2();
    }
    public static void d(Ex15_D2 d) {
        d.d();
    }
    public static void e(Ex15_E1 e) {
        e.e();
        e.f();
    }
    public static void main(String[] args) {
        Ex15_F2 x = new Ex15_F2();
        a(x);
        b(x);
        c(x);
        d(x);
        e(x);
    }
}