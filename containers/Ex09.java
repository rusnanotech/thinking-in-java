/****************** Exercise 9 *****************
 * Use RandomGenerator.String to fill a TreeSet,
 * but use alphabetic ordering. Print the TreeSet
 * to verify the sort order.
 ***********************************************/
package biz.markov.thinking.containers;

import net.mindview.util.RandomGenerator;

import java.util.Set;
import java.util.TreeSet;

public class Ex09 {
    public static void main(String[] args) {
        Set<String> stringSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        RandomGenerator.String gen = new RandomGenerator.String();

        for (int i = 0; i < 50; i++) {
            stringSet.add(gen.next());
        }

        System.out.println(stringSet);
    }
}