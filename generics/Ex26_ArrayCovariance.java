/****************** Exercise 26 *****************
 * Demonstrate array covariance using Numbers and
 * Integers.
 ************************************************/
package biz.markov.thinking.generics;

public class Ex26_ArrayCovariance {
   public static void main(String[] args) {
      Number[] a = new Integer[15];
      
      a[0] = 5;
      
      try {
         a[1] = (short) 8;
      } catch (Exception e) {
         System.out.println(e);
      }
   
      try {
         a[2] = 3.14;
      } catch (Exception e) {
         System.out.println(e);
      }
   }
}
