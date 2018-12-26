/****************** Exercise 33 *****************
 * Repair GenericCast.java using an ArrayList.
 ************************************************/
package biz.markov.thinking.generics;

import java.util.List;
import java.util.ArrayList;

class StackUnderflowException extends Exception {}

class StackOverflowException extends Exception {}

class Ex33_FixedSizeStack<T> {
   private int index = 0;
   private int size;
   private List<T> storage;
   
   public Ex33_FixedSizeStack(int size) {
      this.size = size;
      storage = new ArrayList<T>(size);
   }
   
   public void push(T item) throws StackOverflowException {
      if (index < size) {
         storage.add(item);
         index++;
      } else {
         throw new StackOverflowException();
      }
   }
   
   public T pop() throws StackUnderflowException {
      if (index > 0)
         return storage.remove(--index);
      else
         throw new StackUnderflowException();
   }
}

public class Ex33_GenericCast {
   public static final int SIZE = 10;
   
   public static void main(String[] args) {
      Ex33_FixedSizeStack<String> strings =
         new Ex33_FixedSizeStack<String>(SIZE);
      
      try {
         for (String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
         strings.push("K");
      } catch (StackOverflowException e) {
         System.out.println("\n" + "Stack overflow");
      }
      
      try {
         for (int i = 0; i < SIZE + 1; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
         }
      } catch (StackUnderflowException e) {
         System.out.println("\n" + "Stack underflow");
      }
   }
}
