package biz.markov.thinking.innerclasses;

interface My05_I { void f(); }

class My05_A {
   private static class My05_B implements My05_I {
      public void f() {
         System.out.println("My05_B.f()");
      }
   }
   
   static My05_B g() { return new My05_B(); }
}

public class My05 {
   public static void main(String[] args) {
      My05_I mi = My05_A.g();
      mi.f();
   }
}
