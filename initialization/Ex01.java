/****************** Exercise 01 ****************
 * Create a class with an uninitialized
 * String reference. Demonstrate that this
 * reference is initialized by Java to null.
 ***********************************************/
package biz.markov.thinking.initialization;

class Ex01_String {
    String s;
}

public class Ex01 {
    public static void main(String args[]) {
        Ex01_String s = new Ex01_String();
        System.out.println(s.s);
    }
}
