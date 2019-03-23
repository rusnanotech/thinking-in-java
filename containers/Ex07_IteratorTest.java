/****************** Exercise 7 *****************
 * Create both an ArrayList and a LinkedList, and
 * fill each using the Countries.names() generator.
 * Print each list using an ordinary Iterator, then
 * insert one list into the other by using a
 * ListIterator, inserting at every other location.
 * Now perform the insertion starting at the end of
 * the first list and moving backward.
 ***********************************************/
package biz.markov.thinking.containers;

import net.mindview.util.Countries;

import java.util.*;

public class Ex07_IteratorTest {

    /* Printing Iterable */
    public static void printItr(Iterable<String> itb) {
        int i = 0;
        for (String str : itb) {
            System.out.format("%2d %s\n", i++, str);
        }
        System.out.println();
    }

    /* Forward insertion of List elements */
    public static List<String> forwardInsertion(List<String> dest, List<String> src) {
        List<String> destNew = new ArrayList<String>(dest);
        ListIterator<String> destItr = destNew.listIterator();
        ListIterator<String> srcItr = src.listIterator();

        while (destItr.hasNext() && srcItr.hasNext()) {
            destItr.next();
            destItr.add(srcItr.next());
        }

        return destNew;
    }

    /* Backward insertion of List elements */
    public static List<String> backwardInsertion(List<String> dest, List<String> src) {
        List<String> destNew = new ArrayList<String>(dest);
        ListIterator<String> destItr = destNew.listIterator(dest.size());
        ListIterator<String> srcItr = src.listIterator();

        while (destItr.hasPrevious() && srcItr.hasNext()) {
            destItr.previous();
            destItr.add(srcItr.next());
            destItr.previous();
        }

        return destNew;
    }

    public static void main(String[] args) {
        List<String> l = Countries.names(16);

        // List<String> list0 = new ArrayList<String>(
        //         l.subList(0, l.size() / 2));
        // List<String> list1 = new LinkedList<String>(
        //         l.subList(l.size() / 2, l.size()));
        List<String> list0 = new ArrayList<String>(
                l.subList(0, 5));
        List<String> list1 = new LinkedList<String>(
                l.subList(6, 16));
        printItr(list0);
        printItr(list1);

        printItr(forwardInsertion(list0, list1));
        printItr(backwardInsertion(list0, list1));
    }
}
