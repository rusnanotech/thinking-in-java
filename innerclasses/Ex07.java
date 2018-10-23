/****************** Exercise 7 *****************
 * Create a class with a private field and a
 * private method. Create an inner class with a
 * method that modifies the outer-class field and
 * calls the outer-class method. In a second
 * outer-class method, create an object of the
 * inner class and call its method, then show
 * the effect on the outer-class object.
 ***********************************************/
package biz.markov.thinking.innerclasses;

public class Ex07 {
    private char ch = '%';

    private void encode() {
        System.out.println("incrementing");
        ch++;
    }

    class Ex07_Inner {
        void access() {
            System.out.println("Initial value: " + ch);
            System.out.println("adding");
            Ex07.this.ch += 5;

            Ex07.this.encode();

            System.out.println("Result: " + ch);
        }
    }

    public static void main(String[] args) {
        Ex07 outer = new Ex07();
        Ex07_Inner inner = outer.new Ex07_Inner();
        inner.access();
    }
}
