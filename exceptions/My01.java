package biz.markov.thinking.exceptions;

import java.util.*;

public class My01 {
   private static Random rand = new Random(System.nanoTime());
   
   public void f() throws Ex09_Exception1, Ex09_Exception2, Ex09_Exception3 {
      switch (rand.nextInt(4)) {
         case 0: throw new Ex09_Exception1();
         case 1: throw new Ex09_Exception2();
         case 2: throw new Ex09_Exception3();
         default: break;
      }
   }
   
   public static void main(String[] args) {
      My01 test = new My01();
   
      for (int i = 0; i < 10; i++) {
         try {
            System.out.println("\nTrying " + i);
            test.f();
         } catch (Ex09_Exception1 e) {
            System.out.println("Catching exception 1");
            e.printStackTrace(System.out);
         } catch (Ex09_Exception2 e) {
            System.out.println("Catching exception 2");
            e.printStackTrace(System.out);
         } catch (Ex09_Exception3 e) {
            System.out.println("Catching exception 3");
            e.printStackTrace(System.out);
         } finally {
            System.out.println("finally");
         }
      }
   }
}
