package biz.markov.thinking.holding;

import java.util.*;

public class My03_IteratorIndex {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[10]);
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.set(0);
        }
        int index;

        index = 0;
        System.out.println("\nInitial index: " + index);
        iterator = list.listIterator(index);
        System.out.println("nextIndex() before next(): " + iterator.nextIndex());
        System.out.println("next(); set(1)");
        iterator.next();
        iterator.set(1);
        System.out.println("nextIndex() after next(): " + iterator.nextIndex());
        System.out.println(list);

        index = 3;
        System.out.println("\nInitial index: " + index);
        iterator = list.listIterator(index);
        System.out.println("nextIndex() before next(): " + iterator.nextIndex());
        System.out.println("next(); set(1)");
        iterator.next();
        iterator.set(1);
        System.out.println("nextIndex() after next(): " + iterator.nextIndex());
        System.out.println(list);

        index = 9;
        System.out.println("\nInitial index: " + index);
        iterator = list.listIterator(index);
        System.out.println("previousIndex() before previous(): " + iterator.previousIndex());
        System.out.println("previous(); set(1)");
        iterator.previous();
        iterator.set(1);
        System.out.println("previousIndex() after previous(): " + iterator.previousIndex());
        System.out.println(list);
    }
}
