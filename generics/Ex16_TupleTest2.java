/****************** Exercise 16 *****************
 * Add a SixTuple to Tuple.java, and test it in
 * TupleTest2.java.
 ************************************************/
package biz.markov.thinking.generics;

import net.mindview.thinking.generics.CountedObject;
import net.mindview.util.TwoTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.FiveTuple;

class Ex16_Tuple {
   public Ex16_Tuple() {
   }
   
   public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
      return new TwoTuple(a, b);
   }
   
   public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
      return new ThreeTuple(a, b, c);
   }
   
   public static <A, B, C, D> FourTuple<A, B, C, D> tuple(A a, B b, C c, D d) {
      return new FourTuple(a, b, c, d);
   }
   
   public static <A, B, C, D, E> FiveTuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
      return new FiveTuple(a, b, c, d, e);
   }
   
   public static <A, B, C, D, E, F> SixTuple<A, B, C, D, E, F> tuple(A a, B b, C c, D d, E e, F f) {
      return new SixTuple(a, b, c, d, e, f);
   }
}

public class Ex16_TupleTest2 {
   static SixTuple<CountedObject, Vehicle, Amphibian, String, Integer, Double> m() {
      return Ex16_Tuple.tuple(new CountedObject(), new Vehicle(), new Amphibian(),
         "hi", 47, 11.1);
   }
   
   public static void main(String[] args) {
      System.out.println(m());
   }
}
