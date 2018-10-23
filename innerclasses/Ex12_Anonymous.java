/****************** Exercise 12 *****************
 * Repeat Exercise 7 using an anonymous inner
 * class.
 ***********************************************/
package biz.markov.thinking.innerclasses;

abstract class Ex12_Interface {
    abstract void access();

    public String toString() {
        return getClass().getSimpleName();
    }

}

public class Ex12_Anonymous {
    private char ch = '%';

    private void encode() {
        System.out.println("incrementing");
        ch++;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    Ex12_Interface get(final int i) {
        final int j = 2;

        return new Ex12_Interface() {
            public void access() {
                System.out.println(this + "within " + Ex12_Anonymous.this);
                //  (1st 'this' doesn't produce string because it references
                //  to anonymous class)

                System.out.println("Initial value: " + ch);
                System.out.println("adding");
                Ex12_Anonymous.this.ch += (i + j);

                Ex12_Anonymous.this.encode();

                System.out.println("Result: " + ch);
            }
        };
    }

    public static void main(String[] args) {
        Ex12_Anonymous outer = new Ex12_Anonymous();
        Ex12_Interface inner = outer.get(3);
        inner.access();
    }
}
