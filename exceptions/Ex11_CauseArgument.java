/****************** Exercise 11 ******************
 * Repeat the previous exercise, but inside the
 * catch clause, wrap g()'s exception in a
 * RuntimeException.
 ***********************************************/
package biz.markov.thinking.exceptions;

public class Ex11_CauseArgument {
   public static void f() throws Exception {
      throw new Ex10_Exception1();
   }
   
   public static void g() throws Exception {
      try {
         f();
      } catch (Ex10_Exception1 e) {
         e.printStackTrace(System.out);
         throw new RuntimeException(e);
      }
   }
   
   public static void main(String[] args) {
      try {
         g();
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
   }
}
