package biz.markov.thinking.holding;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class My04_IteratorIndex {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[10]);
        ListIterator<Integer> iterator = list.listIterator();
        for (int i = 0; iterator.hasNext(); i++) {
            iterator.next();
            iterator.set(i * 10);
        }
        int index;

        index = 0;
        iterator = list.listIterator(index);
        System.out.println("\nInitial index: " + index);
        while (iterator.hasNext()) {
            System.out.print("next index: " + iterator.nextIndex());
            System.out.println("\tnext value: " + iterator.next());
        }

        index = 9;
        iterator = list.listIterator(index);
        System.out.println("\nInitial index: " + index);
        while (iterator.hasPrevious()) {
            System.out.print("previous index: " + iterator.previousIndex());
            System.out.println("\tprevious value: " + iterator.previous());
        }
    }
}
