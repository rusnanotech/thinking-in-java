package biz.markov.thinking.initialization;

public class My04_Overloading {
   public void test() {
      f();
      f(1);
   }
   
   public void f() {
      System.out.println("public void f()");
   }
   
   /* Not allowed:
   public void f() {
      System.out.println("public void f()");
   }
   */
   
   public static void f(int i) {
      System.out.println("public static void f(int i)");
   }
   
   public static void main(String[] args) {
      My04_Overloading o = new My04_Overloading();
      
      o.test();
   }
}
