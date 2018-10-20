/****************** Exercise 8 *****************
 * Following the form of the example Lunch.java,
 * create a class called ConnectionManager that
 * manages a fixed array of Connection objects.
 * The client programmer must not be able to
 * create Connection objects, but only get them
 * via a static method in ConnectionManager.
 * ConnectionManager returns a null reference when
 * it runs out of objects. Test the classes in main().
 ***********************************************/
package biz.markov.thinking.access;
import biz.markov.thinking.access.local.Ex08_ConnectionManager;

public class Ex08_Client {
    public static void main(String args[]) {
        while (Ex08_ConnectionManager.connect() != null)
            ;

        Ex08_ConnectionManager.disconnect(1);

        Ex08_ConnectionManager.test(0);
        Ex08_ConnectionManager.test(1);
        Ex08_ConnectionManager.test(2);
        Ex08_ConnectionManager.test(3);
    }
}
