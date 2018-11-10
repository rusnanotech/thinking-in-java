/****************** Exercise 28 *****************
 * Fill a PriorityQueue (using offer()) with
 * Double values created using java.util.Random,
 * then remove the elements using poll() and
 * display them.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

public class Ex28_PriorityQueue {
   public static void main(String[] args) {
      Random rand = new Random(System.nanoTime());
      Queue<Double> q = new PriorityQueue<Double>();
   
      for (int i = 0; i < 10; i++) {
         double x = rand.nextDouble();
         System.out.println("Adding " + x);
         q.offer(x);
      }
   
      System.out.println();
      for (double x : q)
         System.out.println(x);
   
      System.out.println();
      while (q.peek() != null) {
         double x = q.poll();
         System.out.println("Removed " + x);
      }
   }
}
