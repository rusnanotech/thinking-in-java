/****************** Exercise 8 *****************
 * Determine whether an outer class has access to
 * the private elements of its inner class.
 ***********************************************/
package biz.markov.thinking.innerclasses;

public class Ex08_WithPrivateClass {
    private class Ex08_Inner {
        private int i = 912;
        double x = 0.092785;

        private void f() {
            System.out.println("f()");
        }

        void g() {
            System.out.println("g()");
        }
    }

    public void access() {
        Ex08_Inner inner = new Ex08_Inner();

        System.out.println(inner.i);
        System.out.println(inner.x);
        inner.f();
        inner.g();
    }

    public static void main(String[] args) {
        Ex08_WithPrivateClass outer = new Ex08_WithPrivateClass();
        outer.access();
    }
}
