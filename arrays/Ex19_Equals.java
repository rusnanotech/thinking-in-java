/****************** Exercise 19 *****************
 * Create a class with an int field that’s initialized
 * from a constructor argument. Create two arrays
 * of these objects, using identical initialization
 * values for each array, and show that Arrays.equals()
 * says that they are unequal. Add an equals() method
 * to your class to fix the problem.
 ************************************************/
package biz.markov.thinking.arrays;

import java.util.Arrays;

class IntegerHolder {
   private final int val;
   
   public IntegerHolder(int val) {
      this.val = val;
   }
   
   public int getVal() {
      return val;
   }
   
   @Override
   public String toString() {
      return Integer.toString(val);
   }
}

class IntegerHolder2 extends IntegerHolder {
   public IntegerHolder2(int val) {
      super(val);
   }
   
   @Override
   public boolean equals(Object holder) {
      return holder instanceof IntegerHolder &&
         getVal() == ((IntegerHolder) holder).getVal();
   }
}

public class Ex19_Equals {
   public static void main(String[] args) {
      IntegerHolder[] a1 = {
         new IntegerHolder(82), new IntegerHolder(23), new IntegerHolder(9)
      };
      IntegerHolder[] a2 = {
         new IntegerHolder(82), new IntegerHolder(23), new IntegerHolder(9)
      };
      System.out.println(Arrays.equals(a1, a2));
      
      a1 = new IntegerHolder[] {
         new IntegerHolder2(82), new IntegerHolder2(23), new IntegerHolder2(9)
      };
      a2 = new IntegerHolder[] {
         new IntegerHolder2(82), new IntegerHolder2(23), new IntegerHolder2(9)
      };
      System.out.println(Arrays.equals(a1, a2));
   }
}
