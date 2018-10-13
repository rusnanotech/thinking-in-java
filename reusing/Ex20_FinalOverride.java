package biz.markov.thinking.reusing;

class Ex20_Base {
    public void e() {
        System.out.println("Ex20_Base.e()");
    }

    private void f() {
        System.out.println("Ex20_Base.f()");
    }

    final void g() {
        System.out.println("Ex20_Base.g()");
    }

    private final void h() {
        System.out.println("Ex20_Base.h()");
    }
}

class Ex20_Derived extends Ex20_Base {
    @Override public void e() {
        System.out.println("Ex20_Derived.e()");
    }

    public void f() {
        System.out.println("Ex20_Derived.f()");
    }

/*  Not being compiled:
    @Override public void f() {
        System.out.println("Ex20_Derived.f()");
    }*/

/*  Illegal:
    public void g() {
        System.out.println("Ex20_Derived.g()");
    }*/

    public void h() {
        System.out.println("Ex20_Derived.h()");
    }
}

public class Ex20_FinalOverride {
    public static void main(String args[]) {
        Ex20_Derived a = new Ex20_Derived();
        a.e();
        a.f();
        a.g();
        a.h();
    }
}
