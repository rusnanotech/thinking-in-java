/****************** Exercise 26 *****************
 * Create a class with an inner class that has a
 * non-default constructor (one that takes
 * arguments). Create a second class with an inner
 * class that inherits from the first inner class.
 ************************************************/
package biz.markov.thinking.innerclasses;

class Ex26_Outer {
    Ex26_Outer() {
        System.out.println("Outer()");
    }

    void f() {
        System.out.println("Ex26_Outer.f()");
    }

    class Inner {
        Inner(int i) {
            System.out.println("Inner(" + i + ")");
        }
    }
}

class Ex26_Derived extends Ex26_Outer.Inner {
    Ex26_Derived(Ex26_Outer outer, int i) {
        outer.super(i);
        System.out.println("Derived(outer, " + i + ")");
    }
}

public class Ex26_InheritingFromInner {
    public static void main(String[] args) {
        Ex26_Derived d = new Ex26_Derived(new Ex26_Outer(), 5);
        //! d.f();
    }
}
