/************************ Exercise 12 ********************
 * Modify innerclasses/Sequence.java so that it throws an
 * appropriate exception if you try to put in too many
 * elements.
 *********************************************************/
package biz.markov.thinking.exceptions;

import biz.markov.thinking.innerclasses.pkg.Selector;

public class Ex12_Sequence {
   private Object[] items;
   private int next = 0;
   public Ex12_Sequence(int size) { items = new Object[size]; }
   public void add(Object x) {
      // Original version:
      // items[next++] = x;
      
      // New version:
      try {
         items[next] = x;
         next++;
      } catch (IndexOutOfBoundsException e) {
         e.printStackTrace(System.out);
      }
   }
   private class SequenceSelector implements Selector {
      private int i = 0;
      public boolean end() { return i == items.length; }
      public Object current() { return items[i]; }
      public void next() { if(i < items.length) i++; }
   }
   public Selector selector() {
      return new SequenceSelector();
   }
   public static void main(String[] args) {
      Ex12_Sequence sequence = new Ex12_Sequence(10);
      for(int i = 0; i < 12; i++)
         sequence.add(Integer.toString(i));
      Selector selector = sequence.selector();
      while(!selector.end()) {
         System.out.print(selector.current() + " ");
         selector.next();
      }
   }
}
