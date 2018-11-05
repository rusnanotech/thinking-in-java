/****************** Exercise 14 *****************
 * Create an empty LinkedList<Integer>. Using a
 * ListIterator, add Integers to the List by always
 * inserting them in the middle of the List.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

class Ex14_Sequence {
    private List<Integer> list = new LinkedList<Integer>();
    private ListIterator<Integer> itr = list.listIterator();
    private boolean reverse = false;

    public void add(Integer i) {
        itr.add(i);
        if (reverse) {
            itr.previous();
            reverse = false;
        } else {
            reverse = true;
        }
    }

    public String toString () {
        return list.toString();
    }
}

public class Ex14_MiddleInsert {
    public static void main(String[] args) {
        Ex14_Sequence s = new Ex14_Sequence();

        for (int i = 0; i < 10; i++)
            s.add(i);

        System.out.println(s);
    }
}
