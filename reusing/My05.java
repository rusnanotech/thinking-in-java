package biz.markov.thinking.reusing;

class My05_A {
   String s = "My05_A";
   
   void f() {
      System.out.println(s);
   }
   
   void g() {
      System.out.println(s);
   }
}

class My05_B extends My05_A {
   String s = "My05_B";
   
   void f() {
      System.out.println(s);
   }
}

public class My05 {
   public static void main(String[] args) {
      My05_A a = new My05_B();
      
      a.f();
      a.g();
   }
}
