/****************** Exercise 18 *****************
 * Create objects to attach to the array of
 * references for Exercise 17.
 ************************************************/
package biz.markov.thinking.initialization;

class Ex18_Type {
    Ex18_Type(String s) {
        System.out.println("Ex18_Type(" + s + ")");
    }
}

public class Ex18_Arrays {
    public static void main(String args[]) {
        Ex18_Type[] a = new Ex18_Type[5];
        for (int i = 0; i < a.length; i++)
            a[i] = new Ex18_Type("string " + i);
    }
}
