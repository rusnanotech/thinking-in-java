package biz.markov.thinking.generics;

class My03_Exception extends RuntimeException {}

class My03_A<E extends Exception> {
   void m() throws E {
      throw (E) new Exception();
   }
}

public class My03_Exceptions {
   public static void main(String[] args) {
      My03_A<My03_Exception> a = new My03_A<My03_Exception>();
      
      try {
         a.m();
      } catch (My03_Exception e) {
         System.out.println("1: " + e);
      } catch (Exception e) {
         System.out.println("2: " + e);
      }
   }
}
/*
2: java.lang.Exception
 */
