/****************** Exercise 2 ******************
 * Define an object reference and initialize it
 * to null. Try to call a method through this
 * reference. Now wrap the code in a try-catch
 * clause to catch the exception.
 ***********************************************/
package biz.markov.thinking.exceptions;

class Ex02_Obj { void f() {} }

public class Ex02_Null {
   public static void main(String[] args) {
      Ex02_Obj obj = null;
      
      try {
         obj.f();
      } catch(NullPointerException e) {
         e.printStackTrace(System.out);
      }
   
      System.out.println("ABC");
   }
}
