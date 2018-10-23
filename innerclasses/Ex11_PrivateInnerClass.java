/****************** Exercise 11 *****************
 * Create a private inner class that implements a
 * public interface. Write a method that returns
 * a reference to an instance of the private
 * inner class, upcast to the interface. Show
 * that the inner class is completely hidden by
 * trying to downcast to it.
 ************************************************/
package biz.markov.thinking.innerclasses;

class Ex11_Outer {
    private class Inner implements Ex09_Interface {
        public void f() {
            System.out.println("f()");
        }
    }

    Ex09_Interface getInner() {
        return new Inner();
    }
}

public class Ex11_PrivateInnerClass {
    public static void main(String[] args) {
        Ex09_Interface inner = new Ex11_Outer().getInner();

        inner.f();

        //  Downcasting is not allowed by compiler:
        //  ((Ex11_Outer.Inner)inner).f();
    }
}
