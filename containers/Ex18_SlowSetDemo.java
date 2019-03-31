/****************** Exercise 18 *****************
 * Using SlowMap.java for inspiration, create a
 * SlowSet.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.Arrays;
import java.util.Set;

public class Ex18_SlowSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new Ex18_SlowSet<Integer>();
        set.addAll(Arrays.asList(1, 1, 2, 7, 9, 9, 3, 1, 4, 5, 5, 7));
        System.out.println(set);
    }
}