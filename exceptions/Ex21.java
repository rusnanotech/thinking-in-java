/****************** Exercise 21 *****************
 * Demonstrate that a derived-class constructor
 * cannot catch exceptions thrown by its
 * base-class constructor.
 ***********************************************/
package biz.markov.thinking.exceptions;

class Ex21_Base {
   {
      print("Before Ex21_Base constructors");
   }
   
   Ex21_Base() throws Exception {
      print("Ex21_Base constructor 1");
      throw new Exception("exception from Ex21_Base constructor 1");
   }
   
   Ex21_Base(int i) {
      print("Ex21_Base constructor 2");
   }
   
   public void print(String s) {
      System.out.println(s);
   }
}

class Ex21_Derived extends Ex21_Base {
   {
      print("Before Ex21_Derived constructors");
   }
   
   Ex21_Derived() throws Exception {
      print("Ex21_Derived constructor 1");
      /*! Compile-time error:
      try (super()) {
      } catch (Exception e) {
      }
      */
   }
   
   Ex21_Derived(int i) {
      super(i);
      print("Ex21_Derived constructor 2");
   }
}

public class Ex21 {
   public static void main(String[] args) {
      try {
         new Ex21_Derived();
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
      
      new Ex21_Derived(1);
   }
}
