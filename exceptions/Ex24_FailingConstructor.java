/****************** Exercise 24 *****************
 * Add a dispose() method to the FailingConstructor
 * class and write code to properly use this class.
 ***********************************************/
package biz.markov.thinking.exceptions;

import java.util.Random;

public class Ex24_FailingConstructor {
   private static Random rand = new Random(System.nanoTime());
   private Ex23_Disposable d1;
   private Ex23_Disposable d2;
   
   public Ex24_FailingConstructor() throws Exception {
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
   
   public void dispose() {
      System.out.println("Disposing...");
      d2.dispose();
      d1.dispose();
      System.out.println("Disposed");
   }
   
   public static void main(String[] args) {
      Ex24_FailingConstructor fc;
      
      while (true)
         try {
            fc = new Ex24_FailingConstructor();
            break;
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
         
      fc.dispose();
   }
}
