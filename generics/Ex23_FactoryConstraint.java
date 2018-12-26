/****************** Exercise 23 *****************
 * Modify FactoryConstraint.java so that create()
 * takes an argument.
 ************************************************/
package biz.markov.thinking.generics;
//: generics/FactoryConstraint.java

interface FactoryI<T> {
   T create(int i);
}

class Foo2<T> {
   private T x;
   
   public <F extends FactoryI<T>> Foo2(F factory) {
      x = factory.create(1);
   }
   // ...
}

class IntegerFactory implements FactoryI<Integer> {
   public Integer create(int i) {
      return new Integer(i);
   }
}

class Widget {
   public static class Factory implements FactoryI<Widget> {
      public Widget create(int i) {
         return new Widget();
      }
   }
}

public class Ex23_FactoryConstraint {
   public static void main(String[] args) {
      new Foo2<Integer>(new IntegerFactory());
      new Foo2<Widget>(new Widget.Factory());
   }
} ///:~
