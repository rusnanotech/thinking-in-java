/********************** Exercise 20 *********************
 * Create a class that contains int, long, float and double
 * and String fields. Create a constructor for this class
 * that takes a single String argument, and scans that
 * string into the various fields. Add a toString() method
 * and demonstrate that your class works correctly.
 ********************************************************/
package biz.markov.thinking.strings;

import java.util.Scanner;

public class Ex20_Scanner {
   private int i;
   private long l;
   private float f;
   private double d;
   private String s;
   
   public Ex20_Scanner(String input) {
      Scanner sc = new Scanner(input);
      
      i = sc.nextInt();
      l = sc.nextLong();
      f = sc.nextFloat();
      d = sc.nextDouble();
      s = sc.next();
   }
   
   public String toString() {
      return "" + i + " " + " " + l + " " + f + " " + d + " " + s;
   }
   
   public static void main(String[] args) {
      Ex20_Scanner scanner = new Ex20_Scanner(
         "232 -397292749722 0,1 283,97329 abcdefgh"
      );
   
      System.out.println(scanner);
   }
}