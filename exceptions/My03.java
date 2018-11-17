package biz.markov.thinking.exceptions;

class My03_RuntimeExceptionL1 extends RuntimeException {}
class My03_RuntimeExceptionL2 extends My03_RuntimeExceptionL1 {}
class My03_RuntimeExceptionL3 extends My03_RuntimeExceptionL2 {}

class My03_ExceptionL1 extends Exception {}
class My03_ExceptionL2 extends My03_ExceptionL1 {}
class My03_ExceptionL3 extends My03_ExceptionL2 {}

class My03_L1 {
   public void f() throws My03_RuntimeExceptionL1 {
      throw new My03_RuntimeExceptionL1();
   }
   
   public void g() throws My03_ExceptionL1 {
      throw new My03_ExceptionL1();
   }
}

class My03_L2 extends My03_L1 {
   public void f() throws My03_RuntimeExceptionL2 {
      throw new My03_RuntimeExceptionL2();
   }
   
   public void g() throws My03_ExceptionL2 {
      throw new My03_ExceptionL2();
   }
}

public class My03 {
   public static void main(String[] args) {
      My03_L1 a = new My03_L2();
      
      try {
         a.f();
      } catch (My03_RuntimeExceptionL2 e) {
         System.out.println(e);
      }
   
      try {
         a.g();
      } catch (My03_ExceptionL1 e) {
         System.out.println(e);
      }
   }
}
