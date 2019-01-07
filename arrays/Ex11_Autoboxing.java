/****************** Exercise 11 *****************
 * Show that autoboxing doesn’t work with arrays.
 ************************************************/
package biz.markov.thinking.arrays;

public class Ex11_Autoboxing {
   public static void main(String[] args) {
      int[] a = { 1, 2, 3, 4, 5 };
      //! Integer[] b = a; // Compile-time error
      Integer [] b = { 1, 2, 3, 4, 5 };
      //! int[] c = b; // Compile-time error
   }
}
