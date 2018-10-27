/****************** Exercise 23 *****************
 * Create an interface U with three methods.
 * Create a class A with a method that produces a
 * reference to a U by building an anonymous
 * inner class. Create a second class B that
 * contains an array of U. B should have one
 * method that accepts and stores a reference to
 * a U in the array, a second method that sets a
 * reference in the array (specified by the
 * method argument) to null, and a third method
 * that moves through the array and calls the
 * methods in U. In main(), create a group of A
 * objects and a single B. Fill the B with U
 * references produced by the A objects. Use the
 * B to call back into all the A objects. Remove
 * some of the U references from the B.
 ***********************************************/
package biz.markov.thinking.innerclasses;

interface U {
    long f();
    int g(int i);
    double h(double x);
}

class A {
    private static long count = 0;

    U getU() {
        return new U() {
            private long id = count++;

            public long f() {
                return id;
            }

            public int g(int i) {
                return i;
            }

            public double h(double x) {
                return x;
            }
        };
    }
}

class B {
    B(int n) {
        u = new U[n];
    }

    private U[] u;

    boolean add(U uu) {
        for (int i = 0; i < u.length; i++) {
            if (u[i] == null) {
                u[i] = uu;
                return true;
            }
        }
        return false;
    }

    boolean erase(int i) {
        if (0 <= i && i < u.length && u[i] != null) {
            u[i] = null;
            return true;
        } else
            return false;
    }

    void go() {
        for (int i = 0; i < u.length; i++) {
            if (u[i] != null) {
                System.out.print(u[i].f() + "\t");
                System.out.print(u[i].g(i * i) + "\t");
                System.out.println(u[i].h((double) i / u.length));
            } else
                System.out.println("-");
        }
    }
}

public class Ex23 {
    public static void main(String[] args) {
        A[] a = {
                new A(), new A(), new A(), new A(), new A(),
        };
        B b  = new B(a.length);

        for (int i = 0; i < a.length; i++)
            b.add(a[i].getU());

        b.go();

        b.erase(0);
        b.erase(3);
        b.erase(7);

        System.out.println();

        b.go();
    }
}
