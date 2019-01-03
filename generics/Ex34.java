/****************** Exercise 34 *****************
 * Create a self-bounded generic type that contains
 * an abstract method that takes an argument of the
 * generic type parameter and produces a return value
 * of the generic type parameter. In a non-abstract
 * method of the class, call the abstract method and
 * return its result. Inherit from the self-bounded
 * type and test the resulting class.
 ************************************************/
package biz.markov.thinking.generics;

abstract class Ex34_AAA<T extends Ex34_AAA> {
   abstract T get(T o);
   
   T get() {
      return get((T) this);
   }
}

class Ex34_BBB extends Ex34_AAA<Ex34_BBB> {
   Ex34_BBB get(Ex34_BBB b) {
      return b;
   }
}

public class Ex34 {
   public static void main(String[] args) {
      Ex34_BBB b = new Ex34_BBB();
      System.out.println(b == b.get());
   }
}