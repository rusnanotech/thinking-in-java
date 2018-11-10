/****************** Exercise 23 *****************
 * Starting with Statistics.java, create a
 * program that runs the test repeatedly and
 * looks to see if any one number tends to appear
 * more than the others in the results.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;
import java.util.Map.Entry;

public class Ex23_Statistics {
    public static final Comparator<Entry<Integer, Integer>> DESCENDING_ORDER =
            new Comparator<Entry<Integer, Integer>>() {
                public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
                    return e2.getValue().compareTo(e1.getValue());
                }
            };

    public static Map<Integer, Integer> test() {
        Random rand = new Random(System.nanoTime());
        Map<Integer,Integer> m =
                new HashMap<Integer,Integer>();

        for (int i = 0; i < 1000000000; i++) {
            int r = rand.nextInt(20);

            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }

        return m;
    }

    public static void main(String[] args) {
        Map<Integer,Integer> m = test();
        LinkedList<Entry<Integer, Integer>> l =
                new LinkedList<Entry<Integer, Integer>>(m.entrySet());

        Collections.sort(l, DESCENDING_ORDER);

        System.out.println("Most frequent: " + l.getFirst());
        System.out.println("Least frequent: " + l.getLast());
        System.out.println("Range: " + (l.getFirst().getValue() - l.getLast().getValue()) + "\n");
        for (Entry<Integer, Integer> e : l)
            System.out.println(e);
    }
}