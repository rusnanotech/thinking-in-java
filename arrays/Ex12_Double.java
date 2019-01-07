/****************** Exercise 12 *****************
 * Create an initialized array of double using
 * CountingGenerator. Print the results.
 ************************************************/
package biz.markov.thinking.arrays;

import net.mindview.util.CountingGenerator;

import java.util.Arrays;

public class Ex12_Double {
   public static void main(String[] args) {
      double[] a = new double[9];
      CountingGenerator.Double gen = new CountingGenerator.Double();
   
      for (int i = 0; i < a.length; i++)
         a[i] = gen.next();
   
      System.out.println(Arrays.toString(a));
   }
}