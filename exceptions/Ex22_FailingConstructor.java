/****************** Exercise 22 *****************
 * Create a class called FailingConstructor with a
 * constructor that might fail partway through the
 * construction process and throw an exception. In
 * main(), write code that properly guards against
 * this failure.
 ***********************************************/
package biz.markov.thinking.exceptions;

import java.util.*;

public class Ex22_FailingConstructor {
   private static Random rand = new Random(System.nanoTime());
   
   public Ex22_FailingConstructor() throws Exception {
      System.out.print("Initializing... ");
      if (rand.nextBoolean())
         throw new Exception("initialization failed");
      System.out.println("done");
   }
   
   public static void main(String[] args) {
      while (true)
         try {
            new Ex22_FailingConstructor();
            break;
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
   }
}
