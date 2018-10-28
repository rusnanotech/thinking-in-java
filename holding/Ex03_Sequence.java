/****************** Exercise 3 ******************
 * Modify innerclasses/Sequence.java so you
 * can add any number of elements to it.
 ***********************************************/
package biz.markov.thinking.holding;

import biz.markov.thinking.innerclasses.pkg.Selector;
import java.util.*;

public class Ex03_Sequence {
    private List<Object> items = new ArrayList<Object>();
    public void add(Object x) {
        items.add(x);
    }
    private class Ex03_SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == items.size(); }
        public Object current() { return items.get(i); }
        public void next() { i++; }
    }
    public Selector selector() {
        return new Ex03_SequenceSelector();
    }
    public static void main(String[] args) {
        Ex03_Sequence sequence = new Ex03_Sequence();
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
