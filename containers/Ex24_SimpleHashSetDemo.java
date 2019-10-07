/****************** Exercise 24 *****************
 * Following the example in SimpleHashMap.java,
 * create and test a SimpleHashSet.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Ex24_SimpleHashSetDemo {
    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, 1, 2, 5, 0, 8, 0, 8, 9, 4, 2, 5);
        List<Integer> removed = Arrays.asList(0, 1);
        List<Integer> retained = Arrays.asList(7, 8, 9);
        List<Integer> added = Arrays.asList(1, 2, 3, 3);
        Set<Integer> set = new Ex24_SimpleHashSet<Integer>(elements);

        System.out.println("initial: " + set);
        System.out.println("removeAll() " + removed + ": " + set.removeAll(removed));
        System.out.println("set: " + set);
        System.out.println("retainAll() " + retained + ": " + set.retainAll(retained));
        System.out.println("set: " + set);
        System.out.println("addAll() " + added + ": " + set.addAll(added));
        System.out.println("set: " + set);
        System.out.println("add() " + 6 + ": " + set.add(6));
        System.out.println("set: " + set);
        System.out.println("containsAll() " + removed + ": " + set.containsAll(removed));
        System.out.println("containsAll() " + added + ": " + set.containsAll(added));
        System.out.println("size(): " + set.size());
        System.out.println("clear()");
        set.clear();
        System.out.println("size(): " + set.size());
    }
}
