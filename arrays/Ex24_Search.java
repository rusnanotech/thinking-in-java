/****************** Exercise 24 *****************
 * Show that the class from Exercise 19 can be
 * searched.
 ************************************************/
package biz.markov.thinking.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Ex24_Search {
   static final Comparator<IntegerHolder> CMPR = new Comparator<IntegerHolder>() {
      @Override
      public int compare(IntegerHolder o1, IntegerHolder o2) {
         int val1 = o1.getVal(), val2 = o2.getVal();
         return val1 < val2 ? -1 : (val1 == val2 ? 0 : 1);
      }
   };
   
   public static void main(String[] args) {
      Random rand = new Random(19);
      IntegerHolder2[] a = new IntegerHolder2[9];
   
      for (int i = 0; i < a.length; i++)
         a[i] = new IntegerHolder2(rand.nextInt(10));
      
      IntegerHolder2 key = a[rand.nextInt(a.length)];
      System.out.println("key = " + key);
      
      System.out.println(Arrays.toString(a));
      for (int i = 0; i < a.length; i++)
         if (key.equals(a[i]))
            System.out.println("Ordinary search: i = " + i);
   
      Arrays.sort(a, CMPR);
      System.out.println(Arrays.toString(a));
      System.out.println("Binary search: i = " + Arrays.binarySearch(a, key, CMPR));
   }
}
