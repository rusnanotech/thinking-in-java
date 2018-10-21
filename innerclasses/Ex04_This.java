/****************** Exercise 4 *****************
 * Add a method to the class Sequence.SequenceSelector
 * that produces the reference to the outer class
 * Sequence.
 ***********************************************/
package biz.markov.thinking.innerclasses;

import biz.markov.thinking.innerclasses.pkg.*;

class Ex04_String {
    private String s;

    Ex04_String(String s) {
        this.s = s;
    }

    public String toString() {
        return s;
    }
}

public class Ex04_This {
    public static void main(String[] args) {
        Ex04_Sequence sequence = new Ex04_Sequence(4);
        Ex04_Selector selector = sequence.selector();

        //  Modified loop body:
        for (int i = 1; i <= 4; i++)
            selector.getSequence().add("string_" + i);

        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}
