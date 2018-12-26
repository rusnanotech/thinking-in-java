package biz.markov.thinking.generics;

import biz.markov.thinking.generics.libs.Holder;

public class My01 {
   static void m(Holder<?> h) {
      Object o = h.get();
      System.out.println(o);
   }
   
   public static void main(String[] args) {
      m(new Holder<String>("Abc"));
      m(new Holder<Boolean>(true));
   }
}
