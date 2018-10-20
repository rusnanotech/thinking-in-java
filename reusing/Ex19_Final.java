/****************** Exercise 19 *****************
 * Create a class with a blank final reference to
 * an object. Perform initialization of the
 * blank final inside all constructors.
 * Demonstrate that the final must
 * be initialized before use, and cannot
 * be changed once initialized.
 ***********************************************/
package biz.markov.thinking.reusing;

public class Ex19_Final {
    private final String str;
    private final int i;
    private final int[] a = new int[1];

    {
        System.out.println("Initializing i");
        i = 9842375;
        a[0] = 325;
    }

    Ex19_Final() {
        System.out.println("Constructing");
        str = "default string";
    }

    Ex19_Final(String str) {
        System.out.println("Constructing");
        this.str = str;
    }

    public String toString() {
        return str + " " + i + " " + a[0];
    }

    public static void main(String args[]) {
        Ex19_Final e1 = new Ex19_Final();
        System.out.println(e1);
        //! e1.str = "ABCD";
        //! e1.i++;
        //! e1.a = new int[5];
        e1.a[0] = 92153;
        System.out.println(e1);

        Ex19_Final e2 = new Ex19_Final("Vasya");
        System.out.println(e2);

    }
}
