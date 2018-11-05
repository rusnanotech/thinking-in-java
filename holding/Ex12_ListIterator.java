/****************** Exercise 12 *****************
 * Create two List<Integer>s of the same size,
 * and populate one of them. Use ListIterators
 * to insert elements from the first List into
 * the second in reverse order. (You may want to
 * explore a number of different ways to solve
 * this problem.)
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Ex12_ListIterator {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(new Integer[10]);
        ListIterator<Integer> iterator1 = list1.listIterator();
        for (int i = 0; iterator1.hasNext(); i++) {
            iterator1.next();
            iterator1.set(i);
        }
        System.out.println("List 1:\n" + list1 + "\n");

        List<Integer> list2 = Arrays.asList(new Integer[list1.size()]);
        iterator1 = list1.listIterator();
        ListIterator<Integer> iterator2 = list2.listIterator(list2.size());

        while (iterator1.hasNext()) {
            iterator2.previous();
            iterator2.set(iterator1.next());
        }
        System.out.println("List 2:\n" + list2 + "\n");
    }
}