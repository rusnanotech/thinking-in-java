/****************** Exercise 8 ******************
 * Write a class with a method that throws an
 * exception of the type created in Exercise 4.
 * Try compiling it without an exception
 * specification to see what the compiler says.
 * Add the appropriate exception specification.
 * Try out your class and its exception inside a
 * try-catch clause.
 ***********************************************/
package biz.markov.thinking.exceptions;

public class Ex08_Specification {
   public static void f() throws Ex04_Exception {
      throw new Ex04_Exception("My own exception");
   }
   
   /*! Unreported exception. Must be caught or declared to be thrown.
   
   public static void g() {
      throw new Ex04_Exception("My own exception");
   }
   */
   
   public static void main(String[] args) {
      try {
         f();
      } catch(Ex04_Exception e) {
         e.message();
      }
   }
}
