/****************** Exercise 2 ******************
 * Write a method that takes an int argument and
 * returns an array of that size, filled with
 * BerylliumSphere objects.
 ************************************************/
package biz.markov.thinking.arrays;

import biz.markov.thinking.arrays.libs.BerylliumSphere;
import java.util.Arrays;

public class Ex02_ReturningArray {
   public static BerylliumSphere[] getSpheres(int n) {
      BerylliumSphere[] spheres = new BerylliumSphere[n];
   
      for (int i = 0; i < spheres.length; i++)
         spheres[i] = new BerylliumSphere();
      
      return spheres;
   }
   
   public static void main(String[] args) {
      System.out.println(Arrays.toString(getSpheres(5)));
   }
}
