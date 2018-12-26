/****************** Exercise 31 *****************
 * Remove all the generics from
 * MultipleInterfaceVariants.java and modify the
 * code so that the example compiles.
 ************************************************/
package biz.markov.thinking.generics;

interface Payable<T> {}

class Employee implements Payable {}

class Hourly extends Employee implements Payable {}

public class Ex31 {
   public static void main(String[] args) {
      new Hourly();
   }
}
