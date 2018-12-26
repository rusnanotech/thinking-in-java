/****************** Exercise 20 *****************
 * Create an interface with two methods, and a class
 * that implements that interface and adds another
 * method. In another class, create a generic method
 * with an argument type that is bounded by the
 * interface, and show that the methods in the
 * interface are callable inside this generic method.
 * In main(), pass an instance of the implementing
 * class to the generic method.
 ************************************************/
package biz.markov.thinking.generics;

interface Ex20_I {
   void f();
   void g();
}

class Ex20_Obj implements Ex20_I {
   public void f() {
      System.out.println("f()");
   }
   
   public void g() {
      System.out.println("g()");
   }
   
   public void h() {
      System.out.println("h()");
   }
}

public class Ex20_Erasure {
   public static <T extends Ex20_I> void m(T o) {
      o.f();
      o.g();
      //! o.h();
   }
   
   public static void main(String[] args) {
      m(new Ex20_Obj());
   }
}
