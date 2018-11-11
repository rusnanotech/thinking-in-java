/****************** Exercise 9 ******************
 * Create three new types of exceptions. Write a
 * class with a method that throws all three. In
 * main(), call the method but only use a single
 * catch clause that will catch all three types
 * of exceptions.
 ***********************************************/
package biz.markov.thinking.exceptions;

import java.util.*;

class Ex09_Exception1 extends Exception {
   public Ex09_Exception1() { super("Exception 1"); }
}

class Ex09_Exception2 extends Exception {
   public Ex09_Exception2() { super("Exception 2"); }
}

class Ex09_Exception3 extends Exception {
   public Ex09_Exception3() { super("Exception 3"); }
}

class Ex09_Thrower {
   private static Random rand = new Random(System.nanoTime());
   private static Exception[] exceptions = {
      new Ex09_Exception1(),
      new Ex09_Exception2(),
      new Ex09_Exception3(),
   };
   
   public void f() throws Exception {
      throw exceptions[rand.nextInt(exceptions.length)];
   }
}

public class Ex09_BaseMethods {
   public static void main(String[] args) {
      Ex09_Thrower thrower = new Ex09_Thrower();
      
      for (int i = 0; i < 10; i++) {
         try {
            thrower.f();
         } catch (Exception e) {
            e.printStackTrace(System.out);
         }
      }
   }
}
