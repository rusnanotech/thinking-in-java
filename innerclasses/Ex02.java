/****************** Exercise 2 *****************
 * Create a class that holds a String, with a
 * toString() method that displays this String.
 * Add several instances of your new class to a
 * Sequence object, then display them.
 ***********************************************/
package biz.markov.thinking.innerclasses;

import biz.markov.thinking.innerclasses.pkg.*;

class Ex02_String {
    private String s;

    Ex02_String(String s) {
        this.s = s;
    }

    public String toString() {
        return s;
    }
}

public class Ex02 {
    public static void main(String[] args) {
        Sequence sequence = new Sequence(4);
        for (int i = 1; i <= 4; i++)
            sequence.add(new Ex02_String("string_" + i));

        //  Can't define reference to object of inner class:
        //! SequenceSelector selector = sequence.selector();

        //  But it is achieved by reference to interface:
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }
}
