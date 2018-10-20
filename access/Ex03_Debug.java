/****************** Exercise 3 ****************
 * Create two packages: debug and debugoff,
 * containing an identical class with a debug()
 * method. The first version displays its String
 * argument to the console, the second does nothing.
 * Import the class into a test program
 * using a static import line, and demonstrate
 * the conditional compilation effect.
 ***********************************************/
package biz.markov.thinking.access;
import static biz.markov.thinking.access.debug.Ex03_Dbg.*;
// import static biz.markov.thinking.access.debugoff.Ex03_Dbg.*;

public class Ex03_Debug {
    public static void main(String args[]) {
        debug("debug");
    }
}
