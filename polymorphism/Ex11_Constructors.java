/****************** Exercise 11 *****************
 * Add class Pickle to Sandwich.java.
 ***********************************************/
//: polymorphism/Ex11_Constructors.java
// Order of constructor calls.
package biz.markov.thinking.polymorphism;
import static net.mindview.util.Print.*;

class Meal {
  Meal() { print("Meal()"); }
}

class Bread {
  Bread() { print("Bread()"); }
}

class Cheese {
  Cheese() { print("Cheese()"); }
}

class Lettuce {
  Lettuce() { print("Lettuce()"); }
}

class Pickle extends Meal {
  Pickle() { print("Pickle()"); }
}

class Lunch extends Meal {
  Lunch() { print("Lunch()"); }
}

class PortableLunch extends Lunch {
  PortableLunch() { print("PortableLunch()");}
}

class Sandwich extends PortableLunch {
  private Bread b = new Bread();
  private Cheese c = new Cheese();
  private Lettuce l = new Lettuce();
  private Pickle p = new Pickle();
  public Sandwich() { print("Sandwich()"); }
  public static void main(String[] args) {
    new Sandwich();
  }
}

public class Ex11_Constructors {
  public static void main(String args[]) {
    Sandwich.main(args);
  }
}
