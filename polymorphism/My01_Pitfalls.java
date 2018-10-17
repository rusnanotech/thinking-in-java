package biz.markov.thinking.polymorphism;

class My01_Base {
    Character c = 'B';

    final void f() {
        System.out.println("My01_Base.f()");
    }

    void g() {
        System.out.println("My01_Base.g()");
    }

    private void h() {
        System.out.println("My01_Base.h()");
    }

    static void m() {
        System.out.println("static My01_Base.m()");
    }

    void r() {
        System.out.println("My01_Base.r()");
    }
}

class My01_Derived extends My01_Base {
    Character c = 'D';

    /* Not allowed:
    void f() {
        System.out.println("My01_Derived.f()");
    }
    */

    void g() {
        System.out.println("My01_Derived.g()");
    }

    void h() {
        System.out.println("My01_Derived.h()");
    }

    static void m() {
        System.out.println("static My01_Derived.m()");
    }

    void x() {
        System.out.println("My01_Derived.x()");
    }
}

class My01_NextDerived extends My01_Derived {
    Character c = 'N';

    /* Not allowed:
    void f() {
        System.out.println("My01_NextDerived.f()");
    }
    */

    void g() {
        System.out.println("My01_NextDerived.g()");
    }

    void h() {
        System.out.println("My01_NextDerived.h()");
    }

    static void m() {
        System.out.println("static My01_NextDerived.m()");
    }

    void r() {
        System.out.println("My01_NextDerived.r()");
    }
}

public class My01_Pitfalls {
    public static void main(String args[]) {
        My01_Base base = new My01_Derived();
        base.g();
        //! base.h(); // attempt to call private My01_Base.h()
        ((My01_Derived) base).h();
        //! base.x();
        base.m();
        ((My01_Derived) base).m();
        System.out.println(base.c);
        System.out.println(((My01_Derived) base).c);

        My01_Base base2 = new My01_NextDerived();
        base2.g();
        //! base2.h(); // attempt to call private My01_Base.h()
        ((My01_Derived) base2).h(); // calls My01_NextDerived.h();
        ((My01_NextDerived) base2).h();
        //! base2.x();
        base2.m();
        ((My01_NextDerived) base2).m();
        System.out.println(base2.c);
        System.out.println(((My01_NextDerived) base2).c);

        My01_Derived derived = new My01_NextDerived();
        derived.g();
        derived.h(); // attempt to call private My01_Base.h()
        ((My01_NextDerived) derived).h();
        derived.x();
        derived.m();
        ((My01_NextDerived) base2).m();
        System.out.println(derived.c);
        System.out.println(((My01_NextDerived) derived).c);

        base.r();
        derived.r();
        base2.r();
    }
}
