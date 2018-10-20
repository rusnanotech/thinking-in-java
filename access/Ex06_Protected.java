/****************** Exercise 6 *****************
 * Create one class with protected data, and a
 * second class in the same file with a method
 * that manipulates that protected data.
 ***********************************************/
package biz.markov.thinking.access;

class Ex06_Data {
    protected int i = 4;
}

public class Ex06_Protected {
    public static void main(String args[]) {
        System.out.println(++(new Ex06_Data().i));
    }
}
