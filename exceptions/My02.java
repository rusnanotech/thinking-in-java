package biz.markov.thinking.exceptions;

public class My02 {
   public static void main(String[] args) {
      new ArrayIndexOutOfBoundsException();
      int[] a = new int[4];
      
      a[5] = 0;
   }
}
