/****************** Exercise 29 ******************
 * Modify all the exception types in StormyInning.java
 * so that they extend RuntimeException, and show
 * that no exception specifications or try blocks are
 * necessary. Remove the ‘//!’ comments and show how
 * the methods can be compiled without specifications.
 ***********************************************/
package biz.markov.thinking.exceptions;

class Ex29_BaseballException extends RuntimeException {}
class Ex29_Foul extends Ex29_BaseballException {}
class Ex29_Strike extends Ex29_BaseballException {}

abstract class Ex29_Inning {
   public Ex29_Inning() throws Ex29_BaseballException {}
   public void event() throws Ex29_BaseballException {
      // Doesn't actually have to throw anything
   }
   public abstract void atBat() throws Ex29_Strike, Ex29_Foul;
   public void walk() {} // Throws no checked exceptions
}

class Ex29_StormException extends RuntimeException {}
class Ex29_RainedOut extends Ex29_StormException {}
class Ex29_PopFoul extends Ex29_Foul {}

interface Ex29_Storm {
   public void event() throws Ex29_RainedOut;
   public void rainHard() throws Ex29_RainedOut;
}

public class Ex29_StormyInning extends Ex29_Inning implements Ex29_Storm {
   // OK to add new exceptions for constructors, but you
   // must deal with the base constructor exceptions:
   public Ex29_StormyInning()
      throws Ex29_RainedOut, Ex29_BaseballException {}
   public Ex29_StormyInning(String s)
      throws Ex29_Foul, Ex29_BaseballException {}
   // Regular methods must conform to base class:
   public void walk() throws Ex29_PopFoul {} //Compile error
   // Interface CANNOT add exceptions to existing
   // methods from the base class:
   public void event(int i) throws Ex29_RainedOut {}
   // If the method doesn't already exist in the
   // base class, the exception is OK:
   public void rainHard() throws Ex29_RainedOut {}
   // You can choose to not throw any exceptions,
   // even if the base version does:
   public void event() {}
   // Overridden methods can throw inherited exceptions:
   public void atBat() throws Ex29_PopFoul {}
   public static void main(String[] args) {
      try {
         Ex29_StormyInning si = new Ex29_StormyInning();
         si.atBat();
      } catch(Ex29_PopFoul e) {
         System.out.println("Pop foul");
      } catch(Ex29_RainedOut e) {
         System.out.println("Rained out");
      } catch(Ex29_BaseballException e) {
         System.out.println("Generic baseball exception");
      }
      // Strike not thrown in derived version.
      try {
         // What happens if you upcast?
         Ex29_Inning i = new Ex29_StormyInning();
         i.atBat();
         // You must catch the exceptions from the
         // base-class Ex29_version of the method:
      } catch(Ex29_Strike e) {
         System.out.println("Strike");
      } catch(Ex29_Foul e) {
         System.out.println("Foul");
      } catch(Ex29_RainedOut e) {
         System.out.println("Rained out");
      } catch(Ex29_BaseballException e) {
         System.out.println("Generic baseball exception");
      }
   }
} ///:~
