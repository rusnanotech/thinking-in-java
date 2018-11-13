/****************** Exercise 19 *****************
 * Repair the problem in LostMessage.java by
 * guarding the call in the finally clause.
 ***********************************************/
package biz.markov.thinking.exceptions;

public class Ex19_LostMessage {
   void f() throws VeryImportantException {
      throw new VeryImportantException();
   }
   void dispose() throws HoHumException {
      throw new HoHumException();
   }
   public static void main(String[] args) {
      try {
         Ex19_LostMessage lm = new Ex19_LostMessage();
         try {
            lm.f();
         } finally {
            try {
               lm.dispose();
            } catch (Exception e) {
               e.printStackTrace(System.out);
            }
         }
      } catch(Exception e) {
         e.printStackTrace(System.out);
      }
   }
}
