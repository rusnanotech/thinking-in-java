/****************** Exercise 4 *****************
 * Add a method to the class Sequence.SequenceSelector
 * that produces the reference to the outer class
 * Sequence.
 ***********************************************/
//: innerclasses/Sequence.java
// Holds a sequence of Objects.
package biz.markov.thinking.innerclasses.pkg;

public class Ex04_Sequence {
  private Object[] items;
  private int next = 0;
  public Ex04_Sequence(int size) { items = new Object[size]; }
  public void add(Object x) {
    if(next < items.length)
      items[next++] = x;
  }
  private class Ex04_SequenceSelector implements Ex04_Selector {
    private int i = 0;
    //  Added new method using 'this' keyword:
    public Ex04_Sequence getSequence() {
      return Ex04_Sequence.this;
    }
    public boolean end() { return i == items.length; }
    public Object current() { return items[i]; }
    public void next() { if(i < items.length) i++; }
  }
  //  Extended return type
  public Ex04_Selector selector() {
    return new Ex04_SequenceSelector();
  }	
  public static void main(String[] args) {
    Ex04_Sequence sequence = new Ex04_Sequence(10);
    for(int i = 0; i < 10; i++)
      sequence.add(Integer.toString(i));
    Selector selector = sequence.selector();
    while(!selector.end()) {
      System.out.print(selector.current() + " ");
      selector.next();
    }
  }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~
