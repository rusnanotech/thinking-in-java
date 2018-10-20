/****************** Exercise 19 *****************
 * Write a method that takes a vararg String
 * array. Verify that you can pass either a
 * comma-separated list of Strings or a
 * String[] into this method.
 ************************************************/
package biz.markov.thinking.initialization;

import java.util.Arrays;

public class Ex19_Args {
    static void f(String... args) {
        System.out.print(Arrays.toString(args));
        System.out.println();
    }

    public static void main(String args[]) {
        f("ab", "cde", "f", "ghi");
        f(new String[] {"ABCD", "EF", "GHI"});
    }
}
