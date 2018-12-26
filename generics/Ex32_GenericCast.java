/****************** Exercise 32 *****************
 * Verify that FixedSizeStack in GenericCast.java
 * generates exceptions if you try to go out of
 * its bounds. Does this mean that bounds-checking
 * code is not required?
 ************************************************/
package biz.markov.thinking.generics;//: generics/GenericCast.java

class FixedSizeStack<T> {
   private int index = 0;
   private Object[] storage;
   
   public FixedSizeStack(int size) {
      storage = new Object[size];
   }
   
   public void push(T item) {
      storage[index++] = item;
   }
   
   @SuppressWarnings("unchecked")
   public T pop() {
      return (T) storage[--index];
   }
}

public class Ex32_GenericCast {
   public static final int SIZE = 10;
   
   public static void main(String[] args) {
      FixedSizeStack<String> strings =
         new FixedSizeStack<String>(SIZE);
      
      try {
         for (String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
         strings.push("K");
      } catch (Exception e) {
         System.out.println(e);
      }
      
      try {
         for (int i = 0; i < SIZE + 1; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
         }
      } catch (Exception e) {
         System.out.println(e);
      }
   }
}
