/****************** Exercise 6 ******************
 * Create a class that contains int, long, float
 * and double fields. Create a toString() method
 * for this class that uses String.format(), and
 * demonstrate that your class works correctly.
 ************************************************/
package biz.markov.thinking.strings;

public class Ex06 {
   private int a = 2525;
   private long b = 2952953l;
   private float c = 252.8838f;
   private double d = 9233.1085439;
   
   @Override public String toString() {
      return String.format("%d\n%d\n%f\n%f", a, b, c, d);
   }
   
   public static void main(String[] args) {
      System.out.println(new Ex06());
   }
}
