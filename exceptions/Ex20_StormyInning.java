/****************** Exercise 20 *****************
 * Modify StormyInning.java by adding an
 * UmpireArgument exception type and methods
 * that throw this exception. Test the modified
 * hierarchy.
 ***********************************************/
package biz.markov.thinking.exceptions;

class UmpireArgument extends Exception {} // New exception
class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
   public Inning() throws BaseballException {}
   public void test() throws UmpireArgument {} // New method
   public void event() throws BaseballException {
      // Doesn't actually have to throw anything
   }
   public abstract void atBat() throws Strike, Foul;
   public void walk() {} // Throws no checked exceptions
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
   public void event() throws RainedOut;
   public void rainHard() throws RainedOut;
}

public class Ex20_StormyInning extends Inning implements Storm {
   // OK to add new exceptions for constructors, but you
   // must deal with the base constructor exceptions:
   public Ex20_StormyInning()
      throws RainedOut, BaseballException {}
   public Ex20_StormyInning(String s)
      throws Foul, BaseballException {}
   // Regular methods must conform to base class:
//! void walk() throws PopFoul {} //Compile error
   // Interface CANNOT add exceptions to existing
   // methods from the base class:
//! public void event() throws RainedOut {}
   // If the method doesn't already exist in the
   // base class, the exception is OK:
   public void rainHard() throws RainedOut {}
   // You can choose to not throw any exceptions,
   // even if the base version does:
   public void event() {}
   // Overridden methods can throw inherited exceptions:
   public void atBat() throws PopFoul {}
   public static void main(String[] args) {
      try {
         Ex20_StormyInning si = new Ex20_StormyInning();
         si.test();
      } catch(UmpireArgument e) {
         System.out.println("UmpireArgument exception");
      } catch(RainedOut e) {
         System.out.println("Rained out");
      } catch(BaseballException e) {
         System.out.println("Generic baseball exception");
      }
      try {
         Ex20_StormyInning si = new Ex20_StormyInning();
         si.atBat();
      } catch(PopFoul e) {
         System.out.println("Pop foul");
      } catch(RainedOut e) {
         System.out.println("Rained out");
      } catch(BaseballException e) {
         System.out.println("Generic baseball exception");
      }
      // Strike not thrown in derived version.
      try {
         // What happens if you upcast?
         Inning i = new Ex20_StormyInning();
         i.atBat();
         // You must catch the exceptions from the
         // base-class version of the method:
      } catch(Strike e) {
         System.out.println("Strike");
      } catch(Foul e) {
         System.out.println("Foul");
      } catch(RainedOut e) {
         System.out.println("Rained out");
      } catch(BaseballException e) {
         System.out.println("Generic baseball exception");
      }
   }
}
