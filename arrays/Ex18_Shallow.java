/****************** Exercise 18 *****************
 * Create and fill an array of BerylliumSphere.
 * Copy this array to a new array and show that it’s
 * a shallow copy.
 ************************************************/
package biz.markov.thinking.arrays;

import biz.markov.thinking.arrays.libs.BerylliumSphere;
import net.mindview.util.Generated;

import java.util.Arrays;

public class Ex18_Shallow {
   static final int SIZE = 9;
   
   public static void main(String[] args) {
      BerylliumSphere[] spheres = Generated.array(
         BerylliumSphere.class, new BerylliumSphere.Generator(), SIZE);
      BerylliumSphere[] spheres1 = new BerylliumSphere[SIZE];
      System.arraycopy(spheres, 0, spheres1, 0, SIZE);
      
      System.out.println(Arrays.toString(spheres));
      System.out.println(Arrays.toString(spheres1));
      
      spheres[0] = new BerylliumSphere();
   
      System.out.println(Arrays.toString(spheres));
      System.out.println(Arrays.toString(spheres1));
   }
}
