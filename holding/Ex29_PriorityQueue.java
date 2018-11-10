/****************** Exercise 29 *****************
 * Create a simple class that inherits from Object
 * and contains no members, and show that you cannot
 * successfully add multiple elements of that class
 * to a PriorityQueue. This issue will be fully
 * explained in the Containers in Depth chapter.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

class Ex29_Empty extends Object { }

class Ex29_Empty2 { }

public class Ex29_PriorityQueue {
   public static void main(String[] args) {
      Queue<Ex29_Empty> q = new PriorityQueue<Ex29_Empty>();
   
      q.offer(new Ex29_Empty());
      //!q.offer(new Ex29_Empty());
   
      Queue<Ex29_Empty2> q2 = new PriorityQueue<Ex29_Empty2>();
      
      q2.offer(new Ex29_Empty2());
      //!q2.offer(new Ex29_Empty2());
   }
}
