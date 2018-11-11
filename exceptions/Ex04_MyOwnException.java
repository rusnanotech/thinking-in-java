/****************** Exercise 4 ******************
 * Create your own exception class using the
 * extends keyword. Write a constructor for this
 * class that takes a String argument and stores
 * it inside the object with a String reference.
 * Write a method that prints out the stored
 * String. Create a try-catch clause to exercise
 * your new exception.
 ***********************************************/
package biz.markov.thinking.exceptions;

class Ex04_Exception extends Exception {
   Ex04_Exception(String msg) { this.msg = msg; }
   
   private String msg;
   
   public void message() {
      System.out.println(msg);
   }
}

public class Ex04_MyOwnException {
   public static void main(String[] args) {
      try {
         throw new Ex04_Exception("My own exception");
      } catch(Ex04_Exception e) {
         e.message();
      }
   }
}
