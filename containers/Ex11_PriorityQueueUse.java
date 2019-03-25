/****************** Exercise 11 *****************
 * Create a class that contains an Integer that is
 * initialized to a value between 0 and 100 using
 * java.util.Random. Implement Comparable using this
 * Integer field. Fill a PriorityQueue with objects of
 * your class, and extract the values using poll() to
 * show that it produces the expected order.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.PriorityQueue;
import java.util.Queue;

public class Ex11_PriorityQueueUse {
    public static class IntHold implements Comparable<IntHold> {
        private Integer value;

        public IntHold(Integer value) {
            this.value = value;
        }

        @Override
        public int compareTo(IntHold intHold) {
            return value.compareTo(intHold.value);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public static void main(String[] args) {
        Queue<IntHold> pq = new PriorityQueue<IntHold>();

        for (int i = 0; i < 50; i++) {
            pq.offer(new IntHold((int) (Math.random() * 101)));
        }

        while (pq.peek() != null) {
            System.out.println(pq.poll());
        }
    }
}
