/****************** Exercise 7 *****************
 * Use composition instead of inheritance to adapt
 * Fibonacci to make it Iterable.
 ************************************************/
package biz.markov.thinking.generics;

import biz.markov.thinking.util.tij.Fibonacci;

import java.util.Iterator;

class Ex07_IterableFibonacci implements Iterable<Integer> {
   private Fibonacci fib;
   private int count;
   
   Ex07_IterableFibonacci() {
      fib = new Fibonacci();
   }
   
   Ex07_IterableFibonacci(int n) {
      this();
      count = n;
   }
   
   public Integer next() {
      return fib.next();
   }
   
   public Iterator<Integer> iterator() {
      return new Iterator<Integer>() {
         public boolean hasNext() {
            return count > 0;
         }
   
         public Integer next() {
            count--;
            return fib.next();
         }
   
         public void remove() {
            throw new UnsupportedOperationException();
         }
      };
   }
}

public class Ex07_Composition {
   public static void main(String[] args) {
      Ex07_IterableFibonacci gen = new Ex07_IterableFibonacci();
      for (int i = 0; i < 18; i++)
         System.out.print(gen.next() + " ");
      System.out.println();
      
      for (Integer i : new Ex07_IterableFibonacci(18))
         System.out.print(i + " ");
   }
}
