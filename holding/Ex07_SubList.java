/****************** Exercise 7 *****************
 * Create a class and make an initialized array
 * of your class objects. Fill a List from
 * your array. Create a subset of your List using
 * subList(), then remove this subset from
 * your List.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

class Ex07_A {
    private static Random rand = new Random(System.nanoTime());
    private final int id = rand.nextInt(1000);

    public String toString() { return "obj-" + id; }
}

public class Ex07_SubList {
    public static void main(String[] args) {
        Ex07_A[] a = { new Ex07_A(), new Ex07_A(), new Ex07_A(), new Ex07_A(), new Ex07_A(), };
        System.out.println("\nCreating list and sublist...");
        List<Ex07_A> list = new ArrayList<Ex07_A>(Arrays.asList(a));
        List<Ex07_A> sublist = list.subList(1, 4);
        System.out.println("list: " + list);
        System.out.println("sublist: " + sublist);

        System.out.println("\nAdding new object to sublist...");
        Ex07_A obj = new Ex07_A();
        sublist.add(obj);
        System.out.println("object: " + obj);
        System.out.println("list: " + list);
        System.out.println("sublist: " + sublist);

        System.out.println("\nClearing sublist...");
        sublist.clear();
        System.out.println("list: " + list);
    }
}
