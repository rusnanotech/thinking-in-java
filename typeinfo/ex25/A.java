/****************** Exercise 25 *****************
 * Create a class containing private, protected and
 * package access methods. Write code to access these
 * methods from outside of the class’s package.
 ************************************************/
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
