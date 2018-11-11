/****************** Exercise 5 ******************
 * Create your own resumption-like behavior using
 * a while loop that repeats until an exception
 * is no longer thrown.
 ***********************************************/
package biz.markov.thinking.exceptions;

public class Ex05_Resumption {
   public static void main(String[] args) {
      int i = 0;
      
      while (true) {
         try {
            int j = 1 / (i++ / 10);
         } catch (ArithmeticException e) {
            System.out.println("" + i + "/10 = " + i / 10);
            continue;
         }
         break;
      }
   }
}
