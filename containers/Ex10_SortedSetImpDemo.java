/****************** Exercise 10 *****************
 * Using a LinkedList as your underlying
 * implementation, define your own SortedSet.
 ***********************************************/
package biz.markov.thinking.containers;

import biz.markov.thinking.containers.lib.DemoPrinter;
import biz.markov.thinking.containers.lib.CollectionUtils;

import java.util.*;

public class Ex10_SortedSetImpDemo {
    public static <E> void test(List<E> list, SortedSet<E> set, E[] a) {
        String name = set.getClass().getSimpleName();
        System.out.println("is set empty? " + set.isEmpty());
        set.addAll(list);
        DemoPrinter.print(set, name);

        SortedSet<E> subSet = set.subSet(a[0], a[1]);
        DemoPrinter.print(subSet, "subSet(" + a[0] + ", " + a[1] + ")");

        SortedSet<E> headSet = set.headSet(a[1]);
        DemoPrinter.print(headSet, "headSet(" + a[1] + ")");

        DemoPrinter.print(set.tailSet(a[0]), "tailSet(" + a[0] + ")");

        System.out.println("subSet.addAll([" + a[4] + ", " + a[5] + "])");
        try {
            subSet.addAll(Arrays.asList(a[4], a[5]));
        } catch (Exception e) {
            System.out.println(e);
        }
        DemoPrinter.print(subSet, "subSet(" + a[0] + ", " + a[1] + ")");

        System.out.println("subSet.add(" + null + ")");
        try {
            subSet.add(null);
        } catch (Exception e) {
            System.out.println(e);
        }
        DemoPrinter.print(subSet, "subSet(" + a[0] + ", " + a[1] + ")");

        System.out.println("subSet.add(" + a[3] + ")");
        try {
            subSet.add(a[3]);
        } catch (Exception e) {
            System.out.println(e);
        }
        DemoPrinter.print(set, name);

        System.out.println("contains(" + a[0] + ") " + set.contains(a[0]));

        System.out.format("retainAll(%s, %s, %s)\n", a[0], a[1], a[2]);
        set.retainAll(Arrays.asList(a[0], a[1], a[2]));
        DemoPrinter.print(set, name);

        System.out.println();
    }

    static Comparator<Integer> DESC = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

    public static void main(String[] args) {
        Integer[] params1 = {3, 6, 4, 55, 5, 100};
        Integer[] params2 = {6, 3, 4, 55, 100, 5};
        for (int i = 0; i < 100; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int k = 0; k < 10; k++) {
                list.add((int) (Math.random() * 10));
            }
            DemoPrinter.print(list, i + " ArrayList");
            System.out.println("----------------------------------------------------");

            SortedSet<Integer> set10 = new TreeSet<Integer>();
            SortedSet<Integer> set20 = new Ex10_SortedSetImp<Integer>();
            SortedSet<Integer> set30 = new TreeSet<Integer>(DESC);
            SortedSet<Integer> set40 = new Ex10_SortedSetImp<Integer>(DESC);
            test(list, set10, params1);
            test(list, set20, params1);
            if (!CollectionUtils.isEqualsByContentAndOrder(set10, set20)) {
                System.out.println("sets are not equals");
                break;
            }

            System.out.println("Descending\n----------");
            test(list, set30, params2);
            test(list, set40, params2);
            if (!CollectionUtils.isEqualsByContentAndOrder(set30, set40)) {
                System.out.println("sets are not equals");
                break;
            }
        }
    }
}
