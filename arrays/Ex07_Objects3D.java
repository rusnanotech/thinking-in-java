/****************** Exercise 7 *****************
 * Repeat the previous exercise for a 3-D array.
 ***********************************************/
package biz.markov.thinking.arrays;

import biz.markov.thinking.arrays.libs.BerylliumSphere;

public class Ex07_Objects3D {
   public static BerylliumSphere[][][]
   createArray(int dimension1, int dimension2, int dimension3) {
      BerylliumSphere[][][] a = new BerylliumSphere[dimension1][dimension2][dimension3];
   
      for (int i = 0; i < a.length; i++)
         for (int j = 0; j < a[i].length; j++)
            for (int k = 0; k < a[i][j].length; k++)
               a[i][j][k] = new BerylliumSphere();
         
      return a;
   }
   
   public static void printArray(BerylliumSphere[][][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[i].length; j++) {
            for (int k = 0; k < a[i][j].length; k++)
               System.out.format("%-12s", a[i][j][k]);
            System.out.println();
         }
         System.out.println();
      }
   }
   
   public static void main(String[] args) {
      BerylliumSphere[][][] a;
      
      a = createArray(4, 5, 3);
      printArray(a);
   
      System.out.println("------------");
   
      a = createArray(3, 10, 2);
      printArray(a);
   }
}
