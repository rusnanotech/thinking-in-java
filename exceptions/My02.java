package biz.markov.thinking.exceptions;

class My02_Exception1 extends Exception {}
class My02_Exception2 extends Exception {}
class My02_Exception1_Derived extends My02_Exception1 {}

class My02_A {
   public My02_A() throws My02_Exception1 {}
   public My02_A(int i) throws My02_Exception2 {}
   public void f() throws My02_Exception1 {}
}

class My02_B extends My02_A {
   My02_B b;
   
   public My02_B() throws My02_Exception1 {
      b = new My02_B();
   }
   public My02_B(int i) throws My02_Exception2 {
      super(i);
   }
   
   public void f() throws My02_Exception1_Derived {}
   public void g() throws My02_Exception1 { throw new My02_Exception1_Derived();}
}

public class My02 {
   public static void main(String[] args) {
      try {
         {
            try {
               throw new My02_Exception1();
            } catch (My02_Exception1_Derived e) {
               System.out.println("Catching My02_Exception1_Derived");
            }
         }
      } catch (My02_Exception1 e) {
         System.out.println("Catching My02_Exception1");
      }
      // Stack overflow:
      /*
      try {
         try {
            new My02_B().f();
         } catch (My02_Exception1_Derived e) {
            System.out.println("Catching My02_Exception1_Derived");
         }
      } catch (My02_Exception1 e) {
         System.out.println("Catching My02_Exception1");
      } catch (StackOverflowError e){
         e.printStackTrace(System.out);
      }
      */
   }
}