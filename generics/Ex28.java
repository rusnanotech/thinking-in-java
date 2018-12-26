/****************** Exercise 28 *****************
 * Create a generic class Generic1<T> with a single
 * method that takes an argument of type T. Create
 * a second generic class Generic2<T> with a single
 * method that returns an argument of type T. Write
 * a generic method with a contravariant argument of
 * the first generic class that calls its method.
 * Write a second generic method with a covariant
 * argument of the second generic class that calls
 * its method. Test using the typeinfo.pets library.
 ************************************************/
package biz.markov.thinking.generics;

import net.mindview.thinking.typeinfo.pets.*;

class Generic1<T> {
   void take(T x) {
      System.out.println(x + " has been taken");
   }
}

class Generic2<T> {
   private Class<T> type;
   
   Generic2(Class<T> type) {
      this.type = type;
   }
   
   T get() {
      try {
         System.out.println("Returning " + type.getSimpleName());
         return type.newInstance();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
}

public class Ex28 {
   static <T> void m1(Generic1<? super T> g, T x) {
      g.take(x);
   }
   
   static <T> T m2(Generic2<? extends T> g) {
      return g.get();
   }
   
   public static void main(String[] args) {
      m1(new Generic1<Dog>(), m2(new Generic2<Dog>(Dog.class)));
      m1(new Generic1<Pet>(), m2(new Generic2<Dog>(Dog.class)));
   }
}
