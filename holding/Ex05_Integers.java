/****************** Exercise 5 ******************
 * Use Integers instead of Pets to modify
 * ListFeatures.java (remember autoboxing).
 * Explain any difference in results.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;
import static net.mindview.util.Print.print;

public class Ex05_Integers {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Integer> ints = new ArrayList<Integer>
                (Arrays.asList(9, 8, 1, 7, 0, 6, 9, 3, 0, 1, 5));
        print("1: " + ints);
        Integer h = 4;
        ints.add(h); // Automatically resizes
        print("2: " + ints);
        print("3: " + ints.contains(h));
        ints.remove(h); // Remove by object
        Integer p = ints.get(2);
        print("4: " +  p + " " + ints.indexOf(p)); // Shows index of first matched integer
        Integer c = 0;
        print("5: " + ints.indexOf(c)); // Difference: finds index
        print("6: " + ints.remove(c)); // Difference: removes first matched integers (0)
        // Must be the exact object:
        print("7: " + ints.remove(p));
        print("8: " + ints);
        ints.add(3, 4); // Insert at an index
        print("9: " + ints);
        List<Integer> sub = ints.subList(1, 4);
        print("subList: " + sub);
        print("10: " + ints.containsAll(sub));
        Collections.sort(sub); // In-place sort
        print("sorted subList: " + sub);
        // Order is not important in containsAll():
        print("11: " + ints.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        print("shuffled subList: " + sub);
        print("12: " + ints.containsAll(sub));
        List<Integer> copy = new ArrayList<Integer>(ints);
        sub = Arrays.asList(ints.get(1), ints.get(4));
        print("sub: " + sub);
        copy.retainAll(sub);
        print("13: " + copy);
        copy = new ArrayList<Integer>(ints); // Get a fresh copy
        copy.remove(2); // Remove by index
        print("14: " + copy);
        copy.removeAll(sub);
        print("15: " + copy);
        copy.set(1, 11); // Replace an element
        print("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle
        print("17: " + copy);
        print("18: " + ints.isEmpty());
        ints.clear(); // Remove all elements
        print("19: " + ints);
        print("20: " + ints.isEmpty());
        ints.addAll(Arrays.asList(12, 13, 14, 15));
        print("21: " + ints);
        Object[] o = ints.toArray();
        print("22: " + o[3]);
        Integer[] pa = ints.toArray(new Integer[0]);
        print("23: " + pa[3]);
    }
}

