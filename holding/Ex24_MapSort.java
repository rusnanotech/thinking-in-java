/******************* Exercise 24 **************************
 * Fill a LinkedHashMap with String keys and objects.
 * Extract the pairs, sort them based on the keys, and
 * re-insert them into the Map.
 *********************************************************/
package biz.markov.thinking.holding;

import java.util.*;
import java.util.Map.Entry;

public class Ex24_MapSort {
    public static final Comparator<Entry<String, Ex07_A>> CASE_INSENSITIVE_ORDER =
            new Comparator<Entry<String, Ex07_A>>() {
                public int compare(Entry<String, Ex07_A> e1,
                                   Entry<String, Ex07_A> e2) {
                    return e1.getKey().compareToIgnoreCase(e2.getKey());
                }
            };

    public static void main(String[] args) {
        Map<String, Ex07_A> m = new LinkedHashMap<String, Ex07_A>();
        Ex04_Generator gen = new Ex04_Generator();

        for (int i = 0; i < 10; i++)
            m.put(gen.next(), new Ex07_A());

        System.out.println("Before: " + m);

        List<Entry<String, Ex07_A>> l =
                new ArrayList<Entry<String, Ex07_A>>(m.entrySet());
        Collections.sort(l, CASE_INSENSITIVE_ORDER);

        m.clear();
        for (Entry<String, Ex07_A> e : l)
            m.put(e.getKey(), e.getValue());

        System.out.println("After:  " + m);
    }
}
