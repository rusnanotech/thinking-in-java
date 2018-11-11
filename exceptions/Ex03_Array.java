/****************** Exercise 3 ******************
 * Write code to generate and catch an
 * ArrayIndexOutOfBoundsException.
 ***********************************************/
package biz.markov.thinking.exceptions;

public class Ex03_Array {
   public static void main(String[] args) {
      int[] a = { 1, 3, 8, };
      
      try {
         int k = a[a.length];
      } catch (ArrayIndexOutOfBoundsException e) {
         System.out.println(e);
      }
   }
}
