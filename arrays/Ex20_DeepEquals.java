/****************** Exercise 20 *****************
 * Demonstrate deepEquals() for multidimensional
 * arrays.
 ************************************************/
package biz.markov.thinking.arrays;

import java.util.Arrays;

public class Ex20_DeepEquals {
   public static IntegerHolder[][][] fill(IntegerHolder[][][] a, IntegerHolder o) {
      for (int i = 0; i < a.length; i++)
         for (int j = 0; j < a[i].length; j++)
            Arrays.fill(a[i][j], o);
      return a;
   }
   
   public static void main(String[] args) {
      IntegerHolder[][][] a1;
      IntegerHolder[][][] a2;
      
      IntegerHolder ih1 = new IntegerHolder(73);
      IntegerHolder ih2 = new IntegerHolder(73);
      
      a1 = fill(new IntegerHolder[2][2][2], ih1);
      a2 = fill(new IntegerHolder[2][2][2], ih2);
      System.out.println(Arrays.deepEquals(a1, a2));
   
      a2 = fill(new IntegerHolder[2][2][2], ih1);
      System.out.println(Arrays.deepEquals(a1, a2));
      
      a1 = fill(new IntegerHolder[2][2][2], new IntegerHolder2(73));
      a2 = fill(new IntegerHolder[2][2][2], new IntegerHolder2(73));
      System.out.println(Arrays.deepEquals(a1, a2));
   }
}
