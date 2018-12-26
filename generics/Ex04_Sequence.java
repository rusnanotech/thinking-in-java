/****************** Exercise 4 *****************
 * "Generify" innerclasses/Sequence.java.
 ************************************************/
package biz.markov.thinking.generics;

interface Ex04_Selector<T> {
   boolean end();
   T current();
   void next();
}

class Ex04_Sequence<T> {
   private T[] items;
   private int next = 0;
   public Ex04_Sequence(int size) { items = (T[]) new Object[size]; }
   public void add(T x) {
      if(next < items.length)
         items[next++] = x;
   }
   private class SequenceSelector implements Ex04_Selector<T> {
      private int i = 0;
      public boolean end() { return i == items.length; }
      public T current() { return items[i]; }
      public void next() { if(i < items.length) i++; }
   }
   public Ex04_Selector<T> selector() {
      return new SequenceSelector();
   }
   public static void main(String[] args) {
      Ex04_Sequence<String> sequence = new Ex04_Sequence<String>(11);
      for(int i = 0; i < 10; i++)
         sequence.add(Integer.toString(i));
      Ex04_Selector selector = sequence.selector();
      while(!selector.end()) {
         System.out.print(selector.current() + " ");
         selector.next();
      }
      
      //! sequence.add(11);
   }
}
