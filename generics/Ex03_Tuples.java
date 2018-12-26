/****************** Exercise 3 *****************
 * Create and test a SixTuple generic.
 ************************************************/
package biz.markov.thinking.generics;

import net.mindview.util.FiveTuple;
import net.mindview.thinking.typeinfo.pets.*;

class Ex03_Object {}

class SixTuple<A,B,C,D,E,F> extends FiveTuple<A,B,C,D,E> {
   public final F sixth;
   public SixTuple(A a, B b, C c, D d, E e, F f) {
      super(a, b, c, d, e);
      sixth = f;
   }
   
   public String toString() {
      return "(" + first + ", " + second + ", " + third + ", " +
         fourth + ", " + fifth + ", " + sixth + ")";
   }
}

public class Ex03_Tuples {
   public static void main(String[] args) {
      SixTuple<Integer, Double, String, Pet, Ex03_Object, Class<?>> tuple =
         new SixTuple<Integer, Double, String, Pet, Ex03_Object, Class<?>>(
            100, 3.14, "ABCD", Pets.randomPet(), new Ex03_Object(), Ex03_Tuples.class
         );
   
      System.out.println(tuple);
   }
}
