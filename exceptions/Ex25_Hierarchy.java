/****************** Exercise 25 ******************
 * Create a three-level hierarchy of exceptions.
 * Now create a base class A with a method that
 * throws an exception at the base of your
 * hierarchy. Inherit B from A and override the
 * method so it throws an exception at level two
 * of your hierarchy. Repeat by inheriting class
 * C from B. In main(), create a C and upcast it
 * to A, then call the method.
 ***********************************************/
package biz.markov.thinking.exceptions;

class Ex25_ExceptionA extends Exception {
   Ex25_ExceptionA(String s) { super(s); }
}

class Ex25_ExceptionB extends Ex25_ExceptionA {
   Ex25_ExceptionB(String s) { super(s); }
}

class Ex25_ExceptionC extends Ex25_ExceptionB {
   Ex25_ExceptionC(String s) { super(s); }
}

class Ex25_A {
   public void f() throws Ex25_ExceptionA {
      System.out.println("Ex25_A.f()");
      throw new Ex25_ExceptionA("Exception A");
   }
}

class Ex25_B extends Ex25_A {
   public void f() throws Ex25_ExceptionB {
      System.out.println("Ex25_B.f()");
      throw new Ex25_ExceptionB("Exception B");
   }
}

class Ex25_C extends Ex25_B {
   public void f() throws Ex25_ExceptionC {
      System.out.println("Ex25_C.f()");
      throw new Ex25_ExceptionC("Exception C");
   }
}

public class Ex25_Hierarchy {
   public static void main(String[] args) {
      Ex25_A a = new Ex25_C();
      
      try {
         a.f();
      } catch (Ex25_ExceptionA e) {
         System.out.println(e.getMessage() + " catched");
      }
   }
}
