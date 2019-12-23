/****************** Exercise 14 *****************
 * Create an array of each primitive type, then
 * fill each array by using CountingGenerator.
 * Print each array.
 ************************************************/
package biz.markov.thinking.arrays;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;
import static biz.markov.thinking.util.tij.Convert.*;

public class Ex14_PrimitiveArrays {
   static void printArray(Object[] a) {
      System.out.println(
         a.getClass().getSimpleName() + ": " + Arrays.toString(a));
   }
   
   static final int SIZE = 9;
   
   public static void main(String[] args) {
      boolean[] booleans = new boolean[SIZE];
      byte[] bytes = new byte[SIZE];
      char[] chars = new char[SIZE];
      short[] shorts = new short[SIZE];
      int[] ints = new int[SIZE];
      long[] longs = new long[SIZE];
      float[] floats = new float[SIZE];
      double[] doubles = new double[SIZE];
      
      Boolean[] booleansWrapped =
         Generated.array(toWrapped(booleans), new CountingGenerator.Boolean());
      printArray(booleansWrapped);
   
      Byte[] bytesWrapped =
         Generated.array(toWrapped(bytes), new CountingGenerator.Byte());
      printArray(bytesWrapped);
   
      Character[] charactersWrapped =
         Generated.array(toWrapped(chars), new CountingGenerator.Character());
      printArray(charactersWrapped);
   
      Short[] shortsWrapped =
         Generated.array(toWrapped(shorts), new CountingGenerator.Short());
      printArray(shortsWrapped);
   
      Integer[] intsWrapped =
         Generated.array(toWrapped(ints), new CountingGenerator.Integer());
      printArray(intsWrapped);
   
      Long[] longsWrapped =
         Generated.array(toWrapped(longs), new CountingGenerator.Long());
      printArray(longsWrapped);
   
      Float[] floatsWrapped =
         Generated.array(toWrapped(floats), new CountingGenerator.Float());
      printArray(floatsWrapped);
   
      Double[] doublesWrapped =
         Generated.array(toWrapped(doubles), new CountingGenerator.Double());
      printArray(doublesWrapped);
   }
}
