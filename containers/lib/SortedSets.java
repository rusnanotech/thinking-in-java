package biz.markov.thinking.containers.lib;

import java.util.Iterator;
import java.util.SortedSet;

public class SortedSets {
    public static boolean isEquals(SortedSet<?> set1, SortedSet<?> set2) {
        Iterator<?> itr1 = set1.iterator();
        Iterator<?> itr2 = set2.iterator();

        while (itr1.hasNext() && itr2.hasNext()) {
            if (!itr1.next().equals(itr2.next())) {
                return false;
            }
        }

        return true;
    }
}
