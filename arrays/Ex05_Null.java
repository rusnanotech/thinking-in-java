/****************** Exercise 5 *****************
 * Demonstrate that multidimensional arrays of
 * non-primitive types are automatically initialized
 * to null.
 ***********************************************/
package biz.markov.thinking.arrays;

import java.util.Arrays;

public class Ex05_Null {
   public static void main(String[] args) {
      Object[][][][] a = new Object[2][2][2][2];
   
      System.out.println(Arrays.deepToString(a));
   }
}
