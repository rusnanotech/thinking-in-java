/****************** Exercise 10 *****************
 * Modify the previous exercise so that one of
 * f()'s arguments is non-parameterized.
 ************************************************/
package biz.markov.thinking.generics;

import java.math.BigInteger;

public class Ex10_GenericMethods {
   public <T, S> void f(T x, S y, Integer z) {
      System.out.print(x.getClass().getSimpleName() + " ");
      System.out.print(y.getClass().getSimpleName() + " ");
      System.out.print(z.getClass().getSimpleName() + " ");
      System.out.println();
   }
   
   public static void main(String[] args) {
      Ex10_GenericMethods gm = new Ex10_GenericMethods();
      gm.f("", new Object(), 0xFFFF);
      gm.f(1, true, 0xA);
      gm.f(1.0, new int[0], 21);
      gm.f(1.0F, new BigInteger("1951975192795431"), 8);
      gm.f('c', (short) 289, 0);
      gm.f(gm, gm.hashCode(), new Object[0].length);
   }
}
