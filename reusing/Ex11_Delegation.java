/****************** Exercise 11 *****************
 * Modify Detergent.java so it uses delegation.
 ***********************************************/
package biz.markov.thinking.reusing;
//: reusing/Ex11_Delegation.java
// Inheritance syntax & properties.

import static net.mindview.util.Print.print;

class Ex11_Cleanser {
  private String s = "Ex11_Cleanser";
  public void append(String a) { s += a; }
  public void dilute() { append(" dilute()"); }
  public void apply() { append(" apply()"); }
  public void scrub() { append(" scrub()"); }
  public String toString() { return s; }
  public static void main(String[] args) {
    Ex11_Cleanser x = new Ex11_Cleanser();
    x.dilute(); x.apply(); x.scrub();
    print(x);
  }
}

class Ex11_Detergent {
  // Create 'base' object:
  Ex11_Cleanser c = new Ex11_Cleanser();
  // Change a method:
  public void scrub() {
    c.append(" Ex11_Detergent.scrub()");
    c.scrub(); // Call base-class version
  }
  // Add methods to the interface:
  public void foam() { c.append(" foam()"); }
  // Delegations
  public void append(String a) { c.append(a); }
  public void dilute() { c.dilute(); }
  public void apply() { c.apply(); }
  public String toString() { return c.toString(); }
  // Test the new class:
  static void main(String[] args) {
    Ex11_Detergent x = new Ex11_Detergent();
    x.dilute();
    x.apply();
    x.scrub();
    x.foam();
    print(x);
    print("Testing base class:");
    Ex11_Cleanser.main(args);
  }	
}

public class Ex11_Delegation {
  public static void main(String args[]) {
      Ex11_Detergent.main(args);
  }
}

/* Output:
Ex11_Cleanser dilute() apply() Ex11_Detergent.scrub() scrub() foam()
Testing base class:
Ex11_Cleanser dilute() apply() scrub()
*///:~
