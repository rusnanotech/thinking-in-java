/****************** Exercise 27 *****************
 * Write a class called Command that contains a
 * String and has a method operation() that
 * displays the String. Write a second class with
 * a method that fills a Queue with Command objects
 * and returns it. Pass the filled Queue to a method
 * in a third class that consumes the objects in the
 * Queue and calls their operation() methods.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

class Ex27_Command {
   private final String s;
   
   Ex27_Command(String s) {
      this.s = s;
   }
   
   void operation() {
      System.out.println(s);
   }
}

class Ex27_Filler {
   private Ex04_Generator gen = new Ex04_Generator();
   
   Queue<Ex27_Command> fill() {
      Queue<Ex27_Command> q = new LinkedList<Ex27_Command>();
      for (int i = 0; i < 10; i++)
         q.offer(new Ex27_Command(gen.next()));
      
      return q;
   }
}

public class Ex27_Queue {
   static void consumer(Queue<Ex27_Command> q) {
      while (q.peek() != null)
         q.poll().operation();
   }
   
   public static void main(String[] args) {
      Ex27_Filler filler = new Ex27_Filler();
      
      consumer(filler.fill());
   }
}
