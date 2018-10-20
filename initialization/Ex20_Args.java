/****************** Exercise 20 *****************
 * Create a main() that uses varargs instead
 * of the ordinary main() syntax. Print all the
 * elements in the resulting args array. Test it
 * with various numbers of command-line
 * arguments.
 ************************************************/
package biz.markov.thinking.initialization;

import java.util.Arrays;

public class Ex20_Args {
    public static void main(String... args) {
        System.out.print(Arrays.toString(args)); // program arguments are needed
    }
}
