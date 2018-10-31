package biz.markov.thinking.holding;

import java.util.*;

public class My02_SubtractFromList {
    public static void main(String[] args) {
        System.out.println("\nCreating new list and sublist...");
        List<Integer> list = new ArrayList<Integer>
                (Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        List<Integer> alias = list;
        List<Integer> sub = list.subList(3, 6);
        System.out.println("list:  " + list);
        System.out.println("alias: " + alias);
        System.out.println("sub:   " + sub);
        System.out.println("list == alias: " + list.equals(alias));

        System.out.println("\nSubtracting sublist...");
        List<Integer> subtr = new ArrayList<Integer>(Arrays.asList(0, 1));
        list.removeAll(subtr); // Cause of exception
        list.remove((Integer)6); // Cause of exception
        System.out.println("subtr:   " + subtr);
        System.out.println("list:  " + list);
        System.out.println("alias: " + alias);
        //! System.out.println("sub:   " + sub); // Exception!
        System.out.println("list == alias: " + list.equals(alias));

        System.out.println("\nCreating new list...");
        list = new ArrayList<Integer>
                (Arrays.asList(0, 1, 7, 5, 1, 8, 7, 4, 2, 4, 8));
        System.out.println("list:  " + list);
        List<Integer> a = new ArrayList<Integer>(Arrays.asList(7, 8));
        System.out.println("Removing " + a);
        list.removeAll(a);
        System.out.println("list:  " + list);
        System.out.println("Removing " + 1);
        list.remove((Integer)1);
        System.out.println("list:  " + list);
        a = new ArrayList<Integer>(Arrays.asList(4));
        System.out.println("Removing " + a);
        list.removeAll(a);
        System.out.println("list:  " + list);
    }
}
