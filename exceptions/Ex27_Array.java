/****************** Exercise 27 ******************
 * Modify Exercise 3 to convert the exception to a
 * RuntimeException.
 ***********************************************/
package biz.markov.thinking.exceptions;

public class Ex27_Array {
   public static void main(String[] args) {
      int[] a = { 1, 3, 8, };
      
      try {
         int k = a[a.length];
      } catch (ArrayIndexOutOfBoundsException e) {
         throw new RuntimeException(e);
      }
   }
}
