/****************** Exercise 30 *****************
 * Create a Holder for each of the primitive
 * wrapper types, and show that autoboxing and
 * autounboxing works for the set() and get()
 * methods of each instance.
 ************************************************/
package biz.markov.thinking.generics;

import biz.markov.thinking.util.tij.Holder;

public class Ex30_Autoboxing {
   public static void main(String[] args) {
      Holder<Boolean> hbool = new Holder<Boolean>(true);
      boolean bool = hbool.get();
   
      Holder<Byte> hbyte = new Holder<Byte>((byte)5);
      byte bt = hbyte.get();
   
      Holder<Character> hchar = new Holder<Character>('Ы');
      char ch = hchar.get();
   
      Holder<Short> hshort = new Holder<Short>((short)34);
      short sh = hshort.get();
   
      Holder<Integer> hint = new Holder<Integer>(34);
      int i = hint.get();
   
      Holder<Long> hlong = new Holder<Long>((long)84);
      long l = hlong.get();
   
      Holder<Float> hfloat = new Holder<Float>(8.4F);
      float f = hfloat.get();
   
      Holder<Double> hdouble = new Holder<Double>(8.4);
      double x = hdouble.get();
   }
}
