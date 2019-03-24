package biz.markov.thinking.containers;

import biz.markov.thinking.containers.lib.DemoPrinter;
import biz.markov.thinking.containers.lib.SortedSets;

import java.util.*;

public class Ex10_SortedSetImpDemo {
    public static <E> void test(List<E> list, SortedSet<E> set, E[] a) {
        String name = set.getClass().getSimpleName();
        set.addAll(list);
        DemoPrinter.print(set, name);

        SortedSet<E> subSet = set.subSet(a[0], a[1]);
        DemoPrinter.print(subSet, "subSet(" + a[0] + ", " + a[1] + ")");

        SortedSet<E> headSet = set.headSet(a[1]);
        DemoPrinter.print(headSet, "headSet(" + a[1] + ")");
        DemoPrinter.print(set.tailSet(a[0]), "tailSet(" + a[0] + ")");

        System.out.println("subSet.add(" + a[4] + ", " + a[5] + ")");
        try {
            subSet.addAll(Arrays.asList(a[4], a[5]));
        } catch (Exception e) {
            System.out.println(e);
        }
        DemoPrinter.print(subSet, "subSet(" + a[0] + ", " + a[1] + ")");

        System.out.println("subSet.add(" + a[2] + ")");
        try {
            subSet.add(a[2]);
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

        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] params = {3, 6, 4, 55, 5, 100};
        for (int i = 0; i < 100; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int k = 0; k < 10; k++) {
                list.add((int) (Math.random() * 10));
            }
            DemoPrinter.print(list, i + " ArrayList");
            System.out.println("----------------------------------------");

            SortedSet<Integer> set10 = new TreeSet<Integer>();
            SortedSet<Integer> set20 = new Ex10_SortedSetImp<Integer>();
            test(list, set10, params);
            test(list, set20, params);

            if (!SortedSets.isEquals(set10, set20)) {
                System.out.println("sets are not equals");
                break;
            }
        }
    }
}
