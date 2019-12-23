/****************** Exercise 29 *****************
 * Create a generic method that takes as an
 * argument a Holder<List<?>>. Determine what
 * methods you can and can’t call for the Holder
 * and for the List. Repeat for an argument of
 * List<Holder<?>>.
 ************************************************/
package biz.markov.thinking.generics;

import biz.markov.thinking.util.tij.Holder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex29 {
   static String s = "Abc";
   static List<String> ls = new ArrayList<String>(Arrays.asList(s));
   static Holder<List<String>> hls = new Holder<List<String>>(ls);
   static Holder<String> hs = new Holder<String>(s);
   static List<Holder<String>> lhs = new ArrayList<Holder<String>>(Arrays.asList(hs));
   
   static void m1(Holder<List<?>> h) {
      h.set(ls);
      List<?> l = h.get();
      //! l.add(hs);
      Object o = l.get(0);
      Object[] oa = l.toArray();
      int idx = l.indexOf(s);
      boolean b1 = l.contains(s);
      boolean b2 = l.containsAll(Arrays.asList(oa));
   
      l.remove(hs);
      //...
   }
   
   static void m2(List<Holder<?>> l) {
      l.add(hs);
      //! Holder<?>[] ha = (Holder<?>[])l.toArray();
      Object[] ha = l.toArray();
      int idx = l.indexOf(hs);
      boolean b1 = l.contains(hs);
      boolean b2 = l.containsAll(Arrays.asList(ha));
   
      Holder<?> h = l.get(0);
      Object o = h.get();
      //! h.set(s);
      
      l.remove(hs);
      //...
   }
   
   public static void main(String[] args) {
      m1(new Holder<List<?>>(Arrays.asList(s)));
      m2(new ArrayList<Holder<?>>(Arrays.asList(new Holder<String>(s))));
   }
}
