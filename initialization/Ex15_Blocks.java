/****************** Exercise 15 ****************
 * Create a class with a String that is
 * initialized using "instance initialization."
 ***********************************************/
package biz.markov.thinking.initialization;

class Ex15_Str {
    String s;
    {
        s = "String initialized";
        System.out.println(s);
    }
    Ex15_Str(int i) {
        System.out.println("Object " + i + " of class 'Ex15_Str' initialized");
    }
}

public class Ex15_Blocks {
    public static void main(String args[]) {
        new Ex15_Str(1);
        new Ex15_Str(2);
    }
}
