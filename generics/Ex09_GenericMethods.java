/****************** Exercise 9 *****************
 * Modify GenericMethods.java so that f() accepts
 * three arguments, all of which are of a different
 * parameterized type.
 ************************************************/
package biz.markov.thinking.generics;

import java.math.BigInteger;

public class Ex09_GenericMethods {
   public <T, S, O> void f(T x, S y, O z) {
      System.out.print(x.getClass().getSimpleName() + " ");
      System.out.print(y.getClass().getSimpleName() + " ");
      System.out.print(z.getClass().getSimpleName() + " ");
      System.out.println();
   }
   
   public static void main(String[] args) {
      Ex09_GenericMethods gm = new Ex09_GenericMethods();
      gm.f("", new Object(), 0xFFFF);
      gm.f(1, true, (byte) 0xA);
      gm.f(1.0, new int[0], gm.getClass());
      gm.f(1.0F, new BigInteger("1951975192795431"), 0.0);
      gm.f('c', (short) 289, 0);
      gm.f(gm, gm.hashCode(), new Object[0]);
   }
}
