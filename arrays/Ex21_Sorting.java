/****************** Exercise 21 *****************
 * Try to sort an array of the objects in Exercise
 * 18. Implement Comparable to fix the problem. Now
 * create a Comparator to sort the objects into reverse
 * order.
 ************************************************/
package biz.markov.thinking.arrays;

import biz.markov.thinking.arrays.libs.BerylliumSphere;
import net.mindview.util.Generated;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class BerylliumSphereComparable extends BerylliumSphere
   implements Comparable<BerylliumSphere> {
   public static final Comparator<BerylliumSphere> REVERSE_ORDER =
      new Comparator<BerylliumSphere>() {
         @Override
         public int compare(BerylliumSphere s1, BerylliumSphere s2) {
            long id1 = getID(s1), id2 = getID(s2);
            return id1 > id2 ? -1 : (id1 == id2 ? 0 : 1);
         }
      };
   
   // Using reflection for access to private 'id' field:
   private static long getID(BerylliumSphere sphere) {
      try {
         Field field = BerylliumSphere.class.getDeclaredField("id");
         field.setAccessible(true);
         return field.getLong(sphere);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
   
   @Override
   public int compareTo(BerylliumSphere sphere) {
      long id1 = getID(this), id2 = getID(sphere);
      return id1 < id2 ? -1 : (id1 == id2 ? 0 : 1);
   }
   
   @Override
   public String toString() {
      return super.toString() + "*";
   }
   
   public static class Generator
      implements net.mindview.util.Generator<BerylliumSphereComparable> {
      @Override
      public BerylliumSphereComparable next() {
         return new BerylliumSphereComparable();
      }
   }
}

public class Ex21_Sorting {
   static final int SIZE = 9;
   
   public static void main(String[] args) {
      BerylliumSphere[] spheres;
      
      spheres = Generated.array(
         BerylliumSphere.class, new BerylliumSphere.Generator(), SIZE);
      System.out.println(Arrays.toString(spheres));
      try {
         Arrays.sort(spheres);
      } catch (Exception e) {
         System.out.println(e.toString());
      }
   
      spheres = Generated.array(
         BerylliumSphereComparable.class, new BerylliumSphereComparable.Generator(), SIZE);
      System.out.println("original: " + Arrays.toString(spheres));
      
      Collections.shuffle(Arrays.asList(spheres));
      System.out.println("shuffled: " + Arrays.toString(spheres));
      
      Arrays.sort(spheres, Collections.reverseOrder());
      System.out.println("sorted (reversed): " + Arrays.toString(spheres));
      
      Arrays.sort(spheres);
      System.out.println("sorted: " + Arrays.toString(spheres));
      
      Arrays.sort(spheres, BerylliumSphereComparable.REVERSE_ORDER);
      System.out.println("sorted (reversed): " + Arrays.toString(spheres));
   }
}
