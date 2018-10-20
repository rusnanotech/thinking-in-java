/****************** Exercise 7 ******************
 * Create a class without a constructor, then
 * create an object of that class in main() to
 * verify that the default constructor is
 * automatically synthesized.
 ************************************************/
package biz.markov.thinking.initialization;

class Ex07_Type {
    String s = "Object initialized";
    void status() {
        System.out.println(s);
    }
}

public class Ex07 {
    public static void main(String args[]) {
        Ex07_Type obj = new Ex07_Type();
        obj.status();
    }
}
