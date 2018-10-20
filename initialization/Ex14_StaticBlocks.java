/****************** Exercise 14 *****************
 * Create a class with a static String field that
 * is initialized at the point of definition, and
 * another one initialized by the static
 * block. Add a static method that prints both
 * fields and demonstrates that they are both
 * initialized before they are used.
 ************************************************/
package biz.markov.thinking.initialization;

class Ex14_Str {
    static String str1 = "static string";
    static String str2;
    static {
        str2 = new String("static block string");
    }
    static void print() {
        System.out.println(str1);
        System.out.println(str2);
    }
}

public class Ex14_StaticBlocks {
    public static void main(String args[]) {
        Ex14_Str.print();
    }
}
