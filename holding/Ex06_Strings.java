/****************** Exercise 6 ******************
 * Using Strings instead of Pets, modify
 * ListFeatures.java . Explain any difference in
 * results.
 ***********************************************/
package biz.markov.thinking.holding;

//: holding/ListFeatures.java

import java.util.*;

import static net.mindview.util.Print.print;

public class Ex06_Strings {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Ex04_Generator gen = new Ex04_Generator();
        List<String> names = new ArrayList<String>(gen.fill(25));
        print("1: " + names);
        String h = "Hamm";
        names.add(h); // Automatically resizes
        print("2: " + names);
        print("3: " + names.contains(h));
        names.remove(h); // Remove by object
        String p = names.get(2);
        print("4: " +  p + " " + names.indexOf(p));
        String s = "Sid";
        print("5: " + names.indexOf(s));
        print("6: " + names.remove(s));
        // Must be the exact object:
        print("7: " + names.remove(p));
        print("8: " + names);
        names.add(3, "Lenny"); // Insert at an index
        print("9: " + names);
        List<String> sub = names.subList(1, 4);
        print("subList: " + sub);
        print("10: " + names.containsAll(sub));
        Collections.sort(sub); // In-place sort
        print("sorted subList: " + sub);
        // Order is not important in containsAll():
        print("11: " + names.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        print("shuffled subList: " + sub);
        print("12: " + names.containsAll(sub));
        List<String> copy = new ArrayList<String>(names);
        sub = Arrays.asList(names.get(1), names.get(4));
        print("sub: " + sub);
        copy.retainAll(sub);
        print("13: " + copy);
        copy = new ArrayList<String>(names); // Get a fresh copy
        copy.remove(2); // Remove by index
        print("14: " + copy);
        copy.removeAll(sub);
        print("15: " + copy);
        copy.set(1, "Bo"); // Replace an element
        print("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle
        print("17: " + copy);
        print("18: " + names.isEmpty());
        names.clear(); // Remove all elements
        print("19: " + names);
        print("20: " + names.isEmpty());
        names.addAll(gen.fill(4));
        print("21: " + names);
        Object[] o = names.toArray();
        print("22: " + o[3]);
        String[] pa = names.toArray(new String[0]);
        print("23: " + pa[3]);
    }
}
