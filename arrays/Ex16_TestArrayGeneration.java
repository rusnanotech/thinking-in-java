/****************** Exercise 16 *****************
 * Starting with CountingGenerator.java, create a
 * SkipGenerator class that produces new values by
 * incrementing according to a constructor argument.
 * Modify TestArrayGeneration.java to show that your
 * new class works correctly.
 ************************************************/
package biz.markov.thinking.arrays;

import java.util.*;
import net.mindview.util.*;
import biz.markov.thinking.arrays.libs.CountingGenerator2;
import static net.mindview.util.Print.*;

public class Ex16_TestArrayGeneration {
   public static void main(String[] args) {
      int size = 6;
      boolean[] a1 = ConvertTo.primitive(Generated.array(
         Boolean.class, new CountingGenerator2.Boolean(true), size));
      print("a1 = " + Arrays.toString(a1));
      byte[] a2 = ConvertTo.primitive(Generated.array(
         Byte.class, new CountingGenerator2.Byte(2252), size));
      print("a2 = " + Arrays.toString(a2));
      char[] a3 = ConvertTo.primitive(Generated.array(
         Character.class,
         new CountingGenerator2.Character(10), size));
      print("a3 = " + Arrays.toString(a3));
      short[] a4 = ConvertTo.primitive(Generated.array(
         Short.class, new CountingGenerator2.Short(51), size));
      print("a4 = " + Arrays.toString(a4));
      int[] a5 = ConvertTo.primitive(Generated.array(
         Integer.class, new CountingGenerator2.Integer(451), size));
      print("a5 = " + Arrays.toString(a5));
      long[] a6 = ConvertTo.primitive(Generated.array(
         Long.class, new CountingGenerator2.Long(8000), size));
      print("a6 = " + Arrays.toString(a6));
      float[] a7 = ConvertTo.primitive(Generated.array(
         Float.class, new CountingGenerator2.Float(0.308f), size));
      print("a7 = " + Arrays.toString(a7));
      double[] a8 = ConvertTo.primitive(Generated.array(
         Double.class, new CountingGenerator2.Double(702.337), size));
      print("a8 = " + Arrays.toString(a8));
      String[] a9 = Generated.array(
         String.class, new CountingGenerator2.String(7, 20), size);
      print("a9 = " + Arrays.toString(a9));
   }
}
