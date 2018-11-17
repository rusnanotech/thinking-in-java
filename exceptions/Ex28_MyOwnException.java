/****************** Exercise 28 ******************
 * Modify Exercise 4 so that the custom exception
 * class inherits from RuntimeException, and show
 * that the compiler allows you to leave out the
 * try block.
 ***********************************************/
package biz.markov.thinking.exceptions;

class Ex28_Exception extends RuntimeException {
   Ex28_Exception(String msg) { this.msg = msg; }
   
   private String msg;
   
   public void message() {
      System.out.println(msg);
   }
}

public class Ex28_MyOwnException {
   public static void main(String[] args) {
      throw new Ex28_Exception("My own exception");
   }
}
