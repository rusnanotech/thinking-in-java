/****************** Exercise 31 *****************
 * Modify polymorphism/shape/RandomShapeGenerator.java
 * to make it Iterable. You’ll need to add a
 * constructor that takes the number of elements
 * that you want the iterator to produce before
 * stopping. Verify that it works.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;
import biz.markov.thinking.polymorphism.shape.*;

class Ex31_RandomShapeGenerator implements Iterable<Shape> {
   Ex31_RandomShapeGenerator(int len) { this.len = len; }
   
   private final int len;
   private Random rand = new Random(47);
   
   public Iterator<Shape> iterator() {
      return new Iterator<Shape>() {
         private int count = 0;
         
         public boolean hasNext() {
            return count < len;
         }
   
         public Shape next() {
            if (hasNext()) {
               count++;
               switch (rand.nextInt(3)) {
                  default:
                  case 0:
                     return new Circle();
                  case 1:
                     return new Square();
                  case 2:
                     return new Triangle();
               }
            } else
               throw new NoSuchElementException();
         }
   
         public void remove() {
            throw new UnsupportedOperationException();
         }
      };
   }
}

public class Ex31_Iterable {
   public static void main(String[] args) {
      Ex31_RandomShapeGenerator gen = new Ex31_RandomShapeGenerator(10);
      
      for (Shape shape : gen)
         shape.draw();
   }
}
