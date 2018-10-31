package biz.markov.thinking.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class My01_SubLists {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        //! list.add(4);

        System.out.println("\nCreating new list and sublist...");
        list = new ArrayList<Integer>(Arrays.asList(5, 4, 3, 2, 1, 0, 2, 2, 1, 1));
        List<Integer> sub = list.subList(1, 4);
        System.out.println("list: " + list);
        System.out.println("sub: " + sub);
        Integer i = 2;
        System.out.println("index of 2: " + list.indexOf(i));

        System.out.println("\nSorting sublist...");
        Collections.sort(sub);
        System.out.println("list: " + list);
        System.out.println("sub: " + sub);

        System.out.println("\nMaking a copy of the list...");
        List<Integer> copy = new ArrayList<Integer>(list);
        System.out.println("Making sublist...");
        List<Integer> copySub = copy.subList(1, 4);

        System.out.println("\nSubtracting sublist...");
        List<Integer> subtr = new ArrayList<Integer>(Arrays.asList(0, 1));
        list.removeAll(subtr);
        System.out.println("subtr: " + subtr);
        System.out.println("list: " + list);
        //! System.out.println("sub: " + sub); // Exception after subtracting sublist!
/*
        System.out.println("\nClearing sublist...");
        sub.clear(); // Exception after subtracting sublist!
        System.out.println("list: " + list);
        System.out.println("sub: " + sub);
*/
        System.out.println("\nClearing list");
        list.clear();
        System.out.println("list: " + list);

        System.out.println("\nClearing list (copy)...");
        copy.clear();
        System.out.println("list: " + copy);
        //! System.out.println("sub: " + copySub);  // Exception

        System.out.println("\nCreating new list and sublist...");
        list = new ArrayList<Integer>(Arrays.asList(5, 4, 3, 2, 1, 0, 2, 2, 1, 1));
        System.out.println("list: " + list);
        sub = list.subList(1, 4);
        System.out.println("sub: " + sub);

        System.out.println("\nSorting list...");
        Collections.sort(list);
        System.out.println("list: " + list);
        System.out.println("sub: " + sub);

        System.out.println("\nClearing sublist...");
        sub.clear();
        System.out.println("list: " + list);
        System.out.println("sub: " + sub);
    }
}
