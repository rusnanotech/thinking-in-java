package biz.markov.thinking.containers.lib;

import java.util.*;

public class CollectionUtils {

    /**
     * Checks two Set implementations for equality.
     * Returns true if the two sets are equal and have the same order.
     * */
    public static boolean isEqualsByContentAndOrder(Collection<?> set1, Collection<?> set2) {
        boolean result = true;
        Iterator<?> itr1 = set1.iterator();
        Iterator<?> itr2 = set2.iterator();

        while (itr1.hasNext() && itr2.hasNext()) {
            if (!itr1.next().equals(itr2.next())) {
                result = false;
                break;
            }
        }

        if (itr1.hasNext() != itr2.hasNext()) {
            result = false;
        }

        return result;
    }

    public static boolean isEqualsByContent(Collection<?> set1, Collection<?> set2) {
        return set1.containsAll(set2) && set2.containsAll(set1);
    }

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<Integer>(Arrays.asList(100, 152, 838, 47));
        Set<Integer> treeSet1 = new TreeSet<Integer>(Arrays.asList(100, 152, 838, 47));
        Set<Integer> treeSet2 = new TreeSet<Integer>(Arrays.asList(100, 152, 838, 47));
        Set<Integer> treeSet3 = new TreeSet<Integer>(Arrays.asList(100, 152, 838, 47, 999));
        Set<Integer> treeSet4 = new TreeSet<Integer>(Arrays.asList(100, 150, 838, 47));

        assert (!isEqualsByContentAndOrder(treeSet1, hashSet));
        assert (isEqualsByContentAndOrder(treeSet1, treeSet2));
        assert (!isEqualsByContentAndOrder(treeSet2, treeSet3));
        assert (!isEqualsByContentAndOrder(treeSet1, treeSet4));

        assert (isEqualsByContent(treeSet1, hashSet));
        assert (isEqualsByContent(treeSet1, treeSet2));
        assert (!isEqualsByContent(treeSet2, treeSet3));
        assert (!isEqualsByContent(treeSet1, treeSet4));

        assert (isEqualsByContentAndOrder(new HashSet(), new LinkedHashSet()));
    }
}
