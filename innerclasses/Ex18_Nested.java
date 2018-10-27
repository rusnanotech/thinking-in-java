/****************** Exercise 18 *****************
 * Create a class containing a nested class.
 * In main(), create an instance of the nested
 * class.
 ************************************************/
package biz.markov.thinking.innerclasses;

public class Ex18_Nested {
    static class Nested {
        Nested() {
            System.out.println("Creating nested class");
        }
    }

    public static void main(String[] args) {
        Nested n = new Nested();
    }
}
