/****************** Exercise 1 ******************
 * Create a List (try both ArrayList and LinkedList)
 * and fill it using Countries. Sort the list and
 * print it, then apply Collections.shuffle() to the
 * list repeatedly, printing it each time so you
 * can see how the shuffle() method randomizes the
 * list differently each time.
 ************************************************/
package biz.markov.thinking.containers;

import net.mindview.util.Countries;

import java.util.*;

public class Ex01_SortAndShuffle {
    public static void main(String[] args) {
        Random rnd = new Random(System.nanoTime());
        List<String> countriesAL = new ArrayList<String>(Countries.names(10));
        List<String> countriesLL = new LinkedList<String>(Countries.names(10));

        Collections.sort(countriesAL);
        System.out.println(countriesAL);
        Collections.shuffle(countriesAL, rnd);
        System.out.println(countriesAL + "\n");

        Collections.sort(countriesLL);
        System.out.println(countriesLL);
        Collections.shuffle(countriesLL, rnd);
        System.out.println(countriesLL);
    }
}
