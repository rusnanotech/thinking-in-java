/****************** Exercise 5 *****************
 * Remove the type parameter on the Node class and
 * modify the rest of the code in LinkedStack.java
 * to show that an inner class has access to the
 * generic type parameters of its outer class.
 ************************************************/
package biz.markov.thinking.generics;

public class Ex05_LinkedStack<T> {
   private class Node {
      T item;
      Node next;
      Node() { item = null; next = null; }
      Node(T item, Node next) {
         this.item = item;
         this.next = next;
      }
      boolean end() { return item == null && next == null; }
   }
   private Node top = new Node(); // End sentinel
   public void push(T item) {
      top = new Node(item, top);
   }
   public T pop() {
      T result = top.item;
      if(!top.end())
         top = top.next;
      return result;
   }
   public static void main(String[] args) {
      Ex05_LinkedStack<String> lss = new Ex05_LinkedStack<String>();
      for(String s : "Phasers on stun!".split(" "))
         lss.push(s);
      String s;
      while((s = lss.pop()) != null)
         System.out.println(s);
   }
} /* Output:
stun!
on
Phasers
*///:~
