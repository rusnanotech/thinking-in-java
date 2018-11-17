/****************** Exercise 23 *****************
 * Add a class with a dispose() method to the
 * previous exercise. Modify FailingConstructor so
 * that the constructor creates one of these
 * disposable objects as a member object, after which
 * the constructor might throw an exception, after
 * which it creates a second disposable member object.
 * Write code to properly guard against failure, and
 * in main() verify that all possible failure
 * situations are covered.
 ***********************************************/
package biz.markov.thinking.exceptions;

import java.util.Random;

class Ex23_Disposable {
   private final int i;
   
   public Ex23_Disposable(int i) {
      this.i = i;
      System.out.println("Creating object " + i);
   }
   
   public void dispose() {
      System.out.println("Disposing object " + i);
   }
}

class Ex23_Exception extends Exception {
   public Ex23_Exception(String s) {
      super(s);
      System.out.println("Error");
   }
}

public class Ex23_FailingConstructor {
   private static Random rand = new Random(System.nanoTime());
   private Ex23_Disposable d1;
   private Ex23_Disposable d2;
   
   public Ex23_FailingConstructor() throws Exception {
      System.out.println("\nInitializing... ");
      d1 = new Ex23_Disposable(1);
      try {
         if (rand.nextBoolean())
            throw new Ex23_Exception("Initialization failed");
      } catch (Exception e) {
         d1.dispose();
         throw e;
      }
      d2 = new Ex23_Disposable(2);
      System.out.println("Initialized");
   }
   
   public static void main(String[] args) {
      while (true)
         try {
            new Ex23_FailingConstructor();
            break;
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
   }
}
