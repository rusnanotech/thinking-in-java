/****************** Exercise 2 ******************
 * Modify SimpleCollection.java to use a Set for c.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

public class Ex02_Set {
    public static void main(String[] args) {
        Collection<Integer> c = new HashSet<Integer>();
        for(int i = 0; i < 10; i++)
            c.add(i); // Autoboxing
        c.add(1);
        for(Integer i : c)
            System.out.print(i + ", ");

        System.out.println();

        Collection<Integer> d = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++)
            d.add(i); // Autoboxing
        d.add(1);
        for(Integer i : d)
            System.out.print(i + ", ");
    }
}
