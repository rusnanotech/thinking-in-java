/****************** Exercise 2 *****************
 * Inherit a new class from class Detergent.
 * Override scrub() and add a new method called
 * sterilize().
 ***********************************************/
package biz.markov.thinking.reusing;
import biz.markov.thinking.reusing.lib.*;
import static net.mindview.util.Print.*;

public class Ex02_Inheritance extends Detergent {
    // Change a method:
    public void scrub() {
        append(" Ex02_Inheritance.scrub()");
        super.scrub(); // Call base-class version
    }

    // Add methods to the interface:
    public void sterilize() { append(" sterilize()"); }

    public static void main(String args[]) {
        Ex02_Inheritance x = new Ex02_Inheritance();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.sterilize();
        print(x);
        print("Testing base class:");
        Detergent.main(args);
    }
}
