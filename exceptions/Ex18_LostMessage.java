/****************** Exercise 18 *****************
 * Add a second level of exception loss to
 * LostMessage.java so that the HoHumException is
 * itself replaced by a third exception.
 ***********************************************/
package biz.markov.thinking.exceptions;

class VeryImportantException extends Exception {
   public String toString() {
      return "A very important exception!";
   }
}

class HoHumException extends Exception {
   public String toString() {
      return "A trivial exception";
   }
}

class Ex18_ThirdException extends Exception {
   public String toString() {
      return "A third exception";
   }
}

public class Ex18_LostMessage {
   void f() throws VeryImportantException {
      throw new VeryImportantException();
   }
   void dispose() throws HoHumException {
      throw new HoHumException();
   }
   void dispose2() throws Ex18_ThirdException {
      throw new Ex18_ThirdException();
   }
   public static void main(String[] args) {
      // Variant 1:
      try {
         Ex18_LostMessage lm = new Ex18_LostMessage();
         try {
            lm.f();
         } finally {
            try {
               lm.dispose();
            } finally {
               lm.dispose2();
            }
         }
      } catch(Exception e) {
         System.out.println(e);
      }
   
      // Variant 2:
      try {
         Ex18_LostMessage lm = new Ex18_LostMessage();
         try {
            try {
               lm.f();
            } finally {
               lm.dispose();
            }
         } finally {
            lm.dispose2();
         }
      } catch(Exception e) {
         System.out.println(e);
      }
   }
}
