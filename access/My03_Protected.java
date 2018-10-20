//: access/ChocolateChip2.java
package biz.markov.thinking.access;
import biz.markov.thinking.access.local.*;

public class My03_Protected {
  public static void main(String args[]) {
      Cookie x = new Cookie();
      //! x.bite(); // protected method
  }
} /* Output:
Cookie constructor
ChocolateChip2 constructor
bite
*///:~
