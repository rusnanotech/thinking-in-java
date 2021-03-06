/****************** Exercise 4 *****************
 * Add an overloaded constructor to Exercise 3 that
 * takes a String argument and prints it along with
 * your message.
 ***********************************************/
package biz.markov.thinking.initialization;

class Ex04_Msg {
    Ex04_Msg() {
        System.out.println("Object created by default constructor");
    }
    Ex04_Msg(int i) {
        System.out.println("Object " + i + " created by overloaded constructor");
    }
}

public class Ex04 {
    public static void main(String args[]) {
        new Ex04_Msg();
        new Ex04_Msg(1);
    }
}
