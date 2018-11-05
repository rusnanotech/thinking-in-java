package biz.markov.thinking.holding;

import java.util.*;

public class My05_IteratorRemove {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(new Integer[10]));
        ListIterator<Integer> iterator = list.listIterator();
        for (int i = 0; iterator.hasNext(); i++) {
            iterator.next();
            iterator.set(i * 10);
        }
        System.out.println(list);

        iterator = list.listIterator();
        iterator.next();
        iterator.remove();
        System.out.println(list);
    }
}
