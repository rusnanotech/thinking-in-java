/****************** Exercise 3 *****************
 * Write a method that creates and initializes a
 * two-dimensional array of double. The size of
 * the array is determined by the arguments of
 * the method, and the initialization values are
 * a range determined by beginning and ending
 * values that are also arguments of the method.
 * Create a second method that will print the
 * array generated by the first method. In main()
 * test the methods by creating and printing
 * several different sizes of arrays.
 ***********************************************/
package biz.markov.thinking.arrays;

import biz.markov.thinking.arrays.libs.RandomDoubleGenerator;

import java.util.Arrays;
import java.util.Random;

public class Ex03_Double2D {
   public static double[][]
   createArray(int dimension1, int dimension2, double min, double max) {
      RandomDoubleGenerator gen =
         new RandomDoubleGenerator(new Random(System.nanoTime()), min, max);
      double[][] a = new double[dimension1][dimension2];
   
      for (int i = 0; i < a.length; i++)
         for (int j = 0; j < a[i].length; j++) {
            a[i][j] = gen.nextDouble();
         }
         
      return a;
   }
   
   public static void printArray(double[][] a) {
      for (int i = 0; i < a.length; i++) {
         for (int j = 0; j < a[i].length; j++)
            System.out.format("%.3f ", a[i][j]);
         System.out.println();
      }
   }
   
   public static void main(String[] args) {
      double[][] a;
      
      a = createArray(5, 3, 3.890, 9.0134);
      printArray(a);
   
      System.out.println();
   
      a = createArray(10, 2, 1000.0, 2000.0);
      printArray(a);
   }
}