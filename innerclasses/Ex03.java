/****************** Exercise 3 *****************
 * Modify Exercise 1 so Outer has a private
 * String field (initialized by the constructor),
 * and Inner has a toString() that displays this
 * field. Create an object of type Inner and
 * display it.
 ***********************************************/
package biz.markov.thinking.innerclasses;

class Ex03_Outer {
    private String s = "mystery";

    class Ex03_Inner {
        public String toString() {
            return s;
        }
    }

    Ex03_Inner getInner() {
        return new Ex03_Inner();
    }
}

public class Ex03 {
    public static void main(String[] args) {
        Ex03_Outer.Ex03_Inner inner = new Ex03_Outer().getInner();
        System.out.println(inner);
    }
}
