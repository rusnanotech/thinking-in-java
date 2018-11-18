/****************** Exercise 2 ******************
 * Repair InfiniteRecursion.java.
 ************************************************/
package biz.markov.thinking.strings;

import java.util.*;

public class Ex02_InfiniteRecursion {
   public String toString() {
      return " InfiniteRecursion address: " + super.toString() + "\n";
   }
   public static void main(String[] args) {
      List<Ex02_InfiniteRecursion> v =
         new ArrayList<Ex02_InfiniteRecursion>();
      for(int i = 0; i < 10; i++)
         v.add(new Ex02_InfiniteRecursion());
      System.out.println(v);
   }
}
