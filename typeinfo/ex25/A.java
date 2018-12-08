package biz.markov.thinking.typeinfo.ex25;

public class A {
   private void f() {
      System.out.println("private f()");
   }
   
   void g(boolean b) {
      System.out.println("package g()");
   }
   
   protected void h(int i, char c, String s) {
      System.out.println("protected h()");
   }
}
