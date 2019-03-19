/****************** Exercise 3 ******************
 * Using Countries, fill a Set with the same data
 * multiple times, then verify that the Set ends up
 * with only one of each instance. Try this with
 * HashSet, LinkedHashSet, and TreeSet.
 ************************************************/
package biz.markov.thinking.containers;

import net.mindview.util.Countries;

import java.util.*;

public class Ex03_ElementDuplication {
    public static <T> Collection<T> getDuplicated(Collection<T> collection) {
        collection.addAll(collection);
        return collection;
    }

    public static void main(String[] args) {
        List<String> countryList = Countries.names(5);
        Set<String> countryHS = new HashSet<String>(countryList);
        Set<String> countryLHS = new HashSet<String>(countryList);
        Set<String> countryTS = new TreeSet<String>(countryList);

        System.out.println(getDuplicated(countryList));
        System.out.println(getDuplicated(countryHS));
        System.out.println(getDuplicated(countryLHS));
        System.out.println(getDuplicated(countryTS));
    }
}
