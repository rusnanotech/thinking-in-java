/****************** Exercise 4 *****************
 * Repeat the previous exercise for a
 * three-dimensional array.
 ***********************************************/
package biz.markov.thinking.arrays;

import biz.markov.thinking.arrays.libs.RandomDoubleGenerator;
import java.util.Random;

public class Ex04_Double3D {
   public static double[][][]
   createArray(int dimension1, int dimension2, int dimension3, double min, double max) {
      RandomDoubleGenerator gen =
         new RandomDoubleGenerator(new Random(System.nanoTime()), min, max);
      double[][][] a = new double[dimension1][dimension2][dimension3];
   
      for (int i = 0; i < a.length; i++)
         for (int j = 0; j < a[i].length; j++)
            for (int k = 0; k < a[i][j].length; k++) {
               a[i][j][k] = gen.nextDouble();
            }
         
      return a;
   }
   
   public static void printArray(double[][][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[i].length; j++) {
            for (int k = 0; k < a[i][j].length; k++) {
               System.out.format("%.3f ", a[i][j][k]);
            }
            System.out.println();
         }
         System.out.println();
      }
   }
   
   public static void main(String[] args) {
      double[][][] a;
      
      a = createArray(2, 5, 3, 3.890, 9.0134);
      printArray(a);
   
      System.out.println("---------------");
   
      a = createArray(3, 10, 2, 1000.0, 2000.0);
      printArray(a);
   }
}
