/****************** Exercise 30 ******************
 * Modify main() in Human.java so that the
 * technique in TurnOffChecking.java is used to
 * handle the different types of exceptions.
 ***********************************************/
package biz.markov.thinking.exceptions;

class Ex30_Annoyance extends RuntimeException {}
class Ex30_Sneeze extends Ex30_Annoyance {}

public class Ex30_Human {
   public static void throwRuntimeException(int i) {
      switch (i) {
         case 0: throw new Ex30_Sneeze();
         case 1: throw new Ex30_Annoyance();
      }
   }
   
   public static void main(String[] args) {
      // Catch the exact type:
      for (int i = 0; i < 2; i++)
         try {
            throwRuntimeException(i);
         } catch(Ex30_Sneeze s) {
            System.out.println("Caught Sneeze");
         } catch(Ex30_Annoyance a) {
            System.out.println("Caught Annoyance");
         }
   }
}
