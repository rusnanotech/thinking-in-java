/****************** Exercise 25 *****************
 * Create two interfaces and a class that implements
 * both. Create two generic methods, one whose argument
 * parameter is bounded by the first interface and
 * one whose argument parameter is bounded by the
 * second interface. Create an instance of the class
 * that implements both interfaces, and show that
 * it can be used with both generic methods.
 ************************************************/
package biz.markov.thinking.generics;

interface Ex25_Interface1 {
   void m1();
}

interface Ex25_Interface2 {
   void m2();
}

class Ex25_Object implements Ex25_Interface1, Ex25_Interface2 {
   public void m1() { System.out.println("m1()"); }
   public void m2() { System.out.println("m2()"); }
}

public class Ex25_Bounds {
   public static <T extends Ex25_Interface1> void b1(T o) { o.m1(); }
   public static <T extends Ex25_Interface2> void b2(T o) { o.m2(); }
   
   public static void main(String[] args) {
      Ex25_Object o = new Ex25_Object();
      
      b1(o);
      b2(o);
   }
}
