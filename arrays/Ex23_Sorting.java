/****************** Exercise 23 *****************
 * Create an array of Integer, fill it with random
 * int values (using autoboxing), and sort it into
 * reverse order using a Comparator.
 ************************************************/
package biz.markov.thinking.arrays;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

public class Ex23_Sorting {
   static final int SIZE = 9;
   
   public static void main(String[] args) {
      Integer[] a = Generated.array(
         Integer.class, new RandomGenerator.Integer(), SIZE);
      System.out.println(Arrays.toString(a));
   
      Arrays.sort(a, Collections.<Integer>reverseOrder());
      System.out.println(Arrays.toString(a));
   }
}
