/****************** Exercise 13 *****************
 * Modify Exercise 9 by adding a finally clause.
 * Verify that your finally clause is executed, even
 * if a NullPointerException is thrown.
 ***********************************************/
package biz.markov.thinking.exceptions;

public class Ex13_Finally {
   private int i = 0;
   
   public void f() throws Ex09_Exception1, Ex09_Exception2, Ex09_Exception3 {
      switch (i++ % 4) {
         case 0: throw new Ex09_Exception1();
         case 1: throw new Ex09_Exception2();
         case 2: throw new Ex09_Exception3();
         default: throw new NullPointerException();
      }
   }
   
   public static void main(String[] args) {
      Ex13_Finally test = new Ex13_Finally();
   
      for (int i = 0; i < 10; i++) {
         try {
            System.out.println("\nTrying " + i);
            test.f();
         } catch (Ex09_Exception1 e) {
            System.out.println("Catching exception 1");
            e.printStackTrace(System.out);
         } catch (Ex09_Exception2 e) {
            System.out.println("Catching exception 2");
            e.printStackTrace(System.out);
         } catch (Ex09_Exception3 e) {
            System.out.println("Catching exception 3");
            e.printStackTrace(System.out);
         } finally {
            System.out.println("finally " + i);
         }
      }
   }
}
