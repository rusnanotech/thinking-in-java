package biz.markov.thinking.containers.lib;

import java.util.Iterator;
import java.util.Set;

public class Sets {

    /**
     * Checks two Set implementations for equality.
     * Returns true if the two sets are equal and have the same order.
     * */
    public static boolean isEquals(Set<?> set1, Set<?> set2) {
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
