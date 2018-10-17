package biz.markov.thinking.polymorphism.shape;

class Ex10_base {
    void m1() {
        System.out.println("Ex10_Base.m1()");
        m2();
    }

    void m2() {
        System.out.println("Ex10_Base.m2()");
    }
}

class Ex10_Derived extends Ex10_base {
    void m2() {
        System.out.println("Ex10_Derived.m2()");
    }
}

public class Ex10 {
    public static void main(String args[]) {
        Ex10_base base = new Ex10_Derived();
        base.m1();
    }
}
