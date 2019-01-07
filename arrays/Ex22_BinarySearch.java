/****************** Exercise 22 *****************
 * Show that the results of performing a
 * binarySearch() on an unsorted array are
 * unpredictable.
 ************************************************/
package biz.markov.thinking.arrays;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;
import java.util.Collections;

public class Ex22_BinarySearch {
   static final int SIZE = 9;
   
   public static <T> void test(T[] a) {
      System.out.println(Arrays.toString(a));
      System.out.format("key   i   a[i]   key == a[i]\n");
      for (T key : a) {
         int i = Arrays.binarySearch(a, key);
         System.out.format("%s   %3d", key, i);
         if (i >= 0)
            System.out.format("     %s    %b\n", a[i], key.equals(a[i]));
         else
            System.out.println();
      }
   }
   
   public static void main(String[] args) {
      Integer[] a = Generated.array(
         Integer.class, new CountingGenerator.Integer(), SIZE);
      test(a);
      
      System.out.println();
      
      Collections.shuffle(Arrays.asList(a));
      test(a);
      
   }
}
