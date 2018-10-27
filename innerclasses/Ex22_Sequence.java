package biz.markov.thinking.innerclasses;

import biz.markov.thinking.innerclasses.pkg.Selector;


public class Ex22_Sequence {
    private Object[] items;
    private int next = 0;
    public Ex22_Sequence(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
    }
    // Added new inner class:
    private class ReverseSelector implements Selector {
        private int i = items.length - 1;
        public boolean end() { return i == -1; }
        public Object current() { return items[i]; }
        public void next() { if(i >= 0) i--; }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
    public Selector reverseSelector() {
        return new ReverseSelector();
    }
    public static void main(String[] args) {
        Ex22_Sequence sequence = new Ex22_Sequence(10);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        System.out.println();

        Selector rselector = sequence.reverseSelector();

        while (!rselector.end()) {
            System.out.print(rselector.current() + " ");
            rselector.next();
        }
    }
}
