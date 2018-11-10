/****************** Exercise 10 *****************
 * Create a base class with two methods. In the
 * first method, call the second method. Inherit
 * a class and override the second method. Create
 * an object of the derived class, upcast it to
 * the base type, and call the first method.
 * Explain what happens.
 ***********************************************/
package biz.markov.thinking.polymorphism;

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
