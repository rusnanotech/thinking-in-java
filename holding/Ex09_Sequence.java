/****************** Exercise 9 ******************
 * Modify innerclasses/Ex09_Sequence.java so that
 * Ex09_Sequence works with an Iterator instead of a
 * Selector.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

public class Ex09_Sequence {
    private Object[] items;
    private int next = 0;

    public Ex09_Sequence(int size) { items = new Object[size]; }

    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }

    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private int next = 0;
            public boolean hasNext() { return next < items.length; }
            public Object next() {
                if(next < items.length)
                    return items[next++];
                return null;
            }
            public void remove() { }
        };
    }

    public static void main(String[] args) {
        Ex09_Sequence sequence = new Ex09_Sequence(10);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Iterator<Object> itr = sequence.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}
