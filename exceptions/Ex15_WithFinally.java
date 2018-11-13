/****************** Exercise 15 *****************
 * Show that WithFinally.java doesn't fail by
 * throwing a RuntimeException inside the try
 * block.
 ***********************************************/
package biz.markov.thinking.exceptions;

public class Ex15_WithFinally {
   static Switch sw = new Switch();
   public static void main(String[] args) {
      try {
         sw.on();
         // Code that can throw exceptions...
         Ex14_OnOffSwitch.f();
      } catch(OnOffException1 e) {
         System.out.println("OnOffException1");
      } catch(OnOffException2 e) {
         System.out.println("OnOffException2");
      } finally {
         sw.off();
      }
   }
}