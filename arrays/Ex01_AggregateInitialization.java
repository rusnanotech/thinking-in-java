/****************** Exercise 1 ******************
 * Create a method that takes an array of
 * BerylliumSphere as an argument. Call the method,
 * creating the argument dynamically. Demonstrate
 * that ordinary aggregate array initialization
 * doesn’t work in this case. Discover the only
 * situations where ordinary aggregate array
 * initialization works, and where dynamic aggregate
 * initialization is redundant.
 ************************************************/
package biz.markov.thinking.arrays;

import biz.markov.thinking.util.tij.BerylliumSphere;

import java.util.Arrays;

public class Ex01_AggregateInitialization {
   public static void process(BerylliumSphere[] spheres) {
      System.out.println(Arrays.toString(spheres));
   }
   
   public static void main(String[] args) {
      // Dynamic aggregate initialization:
      process(new BerylliumSphere[] {new BerylliumSphere(), new BerylliumSphere()});
   
      // Ordinary aggregate array initialization doesn't work:
      //! process({new BerylliumSphere(), new BerylliumSphere()});
      
      // Situation where ordinary aggregate array initialization works:
      BerylliumSphere[] spheres = {new BerylliumSphere(), new BerylliumSphere()};
   
      // Situation where dynamic aggregate array initialization is redundant:
      BerylliumSphere[] spheres2 =
         new BerylliumSphere[] {new BerylliumSphere(), new BerylliumSphere()};
      
   }
}
