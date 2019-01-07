/****************** Exercise 6 *****************
 * Write a method that takes two int arguments,
 * indicating the two sizes of a 2-D array. The
 * method should create and fill a 2-D array of
 * BerylliumSphere according to the size arguments.
 ***********************************************/
package biz.markov.thinking.arrays;

import biz.markov.thinking.arrays.libs.BerylliumSphere;

public class Ex06_Objects2D {
   public static BerylliumSphere[][]
   createArray(int dimension1, int dimension2) {
      BerylliumSphere[][] a = new BerylliumSphere[dimension1][dimension2];
   
      for (int i = 0; i < a.length; i++)
         for (int j = 0; j < a[i].length; j++)
            a[i][j] = new BerylliumSphere();
         
      return a;
   }
   
   public static void printArray(BerylliumSphere[][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[i].length; j++)
            System.out.format("%-12s", a[i][j]);
         System.out.println();
      }
   }
   
   public static void main(String[] args) {
      BerylliumSphere[][] a;
      
      a = createArray(5, 3);
      printArray(a);
   
      System.out.println();
   
      a = createArray(10, 2);
      printArray(a);
   }
}
