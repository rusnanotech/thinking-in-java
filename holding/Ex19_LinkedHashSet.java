/******************* Exercise 19 *****************
 * Repeat Exercise 18 with a HashSet and
 * LinkedHashSet.
 *************************************************/
package biz.markov.thinking.holding;

import java.util.*;

public class Ex19_LinkedHashSet {
    static void printNames(Set<String> names) {
        for (String name : names)
            System.out.println(name);
        System.out.println();
    }

    public static void main(String[] args) {
        Set<String> names = new HashSet<String>(Arrays.asList(
                "Pushok", "Zubastik", "Hvostatik", "Malysh", "Ushastik"));

        printNames(names);

        names = new TreeSet<String>(names);
        names = new LinkedHashSet<String>(names);

        printNames(names);
    }
}
