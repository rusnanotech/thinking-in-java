/****************** Exercise 24 *****************
 * Following the example in SimpleHashMap.java,
 * create and test a SimpleHashSet.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.*;

/**
 * Ex24_SimpleHashSetDemo.
 *
 * @author Vasily_Markov
 */
public class Ex24_SimpleHashSetDemo {
    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, 1, 2, 5, 0, 8, 0, 8, 9, 4, 2, 5);
        List<Integer> removed = Arrays.asList(0, 1);
        List<Integer> retained = Arrays.asList(7, 8, 9);
        List<Integer> added = Arrays.asList(1, 2, 3, 3);

        Set<Integer> set = new Ex24_SimpleHashSet<Integer>(elements);

        System.out.println("initial: " + set);
        set.removeAll(removed);
        System.out.println(removed + " removed: " + set);
        set.removeAll(retained);
        System.out.println(retained + " retained: " + set);
        set.addAll(added);
        System.out.println(added + " added: " + set);
        set.add(6);
        System.out.println(6 + " added: " + set);
        System.out.println(set.containsAll(removed));
        System.out.println(set.containsAll(added));
        System.out.println(set.size());
        set.clear();
        System.out.println(set.size());
    }
}
