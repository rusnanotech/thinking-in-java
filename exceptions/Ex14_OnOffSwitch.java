/****************** Exercise 14 *****************
 * Show that OnOffSwitch.java can fail by
 * throwing a RuntimeException inside the try
 * block.
 ***********************************************/
package biz.markov.thinking.exceptions;

import static net.mindview.util.Print.print;

class OnOffException1 extends Exception {}
class OnOffException2 extends Exception {}

class Switch {
   private boolean state = false;
   public boolean read() { return state; }
   public void on() { state = true; print(this); }
   public void off() { state = false; print(this); }
   public String toString() { return state ? "on" : "off"; }
} ///:~

public class Ex14_OnOffSwitch {
   private static Switch sw = new Switch();
   public static void f()
      throws OnOffException1,OnOffException2 { throw new RuntimeException(); }
   public static void main(String[] args) {
      try {
         sw.on();
         // Code that can throw exceptions...
         f();
         sw.off();
      } catch(OnOffException1 e) {
         System.out.println("OnOffException1");
         sw.off();
      } catch(OnOffException2 e) {
         System.out.println("OnOffException2");
         sw.off();
      }
   }
}
