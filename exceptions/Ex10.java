/****************** Exercise 10 ******************
 * Create a class with two methods, f() and g().
 * In g(), throw an exception of a new type that
 * you define. In f(), call g(), catch its
 * exception and, in the catch clause, throw a
 * different exception (of a second type that you
 * define). Test your code in main().
 ***********************************************/
package biz.markov.thinking.exceptions;

class Ex10_Exception1 extends Exception {
   Ex10_Exception1() { super("exception 1"); }
}

class Ex10_Exception2 extends Exception {
   Ex10_Exception2() { super("exception 2"); }
}

public class Ex10 {
   public static void f() throws Exception {
      throw new Ex10_Exception1();
   }
   
   public static void g() throws Exception {
      try {
         f();
      } catch (Ex10_Exception1 e) {
         e.printStackTrace(System.out);
         throw new Ex10_Exception2();
      }
   }
   
   public static void main(String[] args) {
      try {
         g();
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
   }
}
