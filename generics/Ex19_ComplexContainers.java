/****************** Exercise 19 *****************
 * Following the form of Store.java, build a model
 * of a containerized cargo ship.
 ************************************************/
package biz.markov.thinking.generics;

import java.util.ArrayList;

class Cargo {
   private static long count = 1;
   private final long id = count++;
   
   public String toString() {
      return getClass().getSimpleName() + " " + id;
   }
}

class Box extends ArrayList<Cargo> {
   private static long count = 1;
   private final long id = count++;
   
   public Box(int numCargos) {
      for (int i = 0; i < numCargos; i++) {
         add(new Cargo());
      }
   }
   
   public String toString() {
      return getClass().getSimpleName() + " " + id;
   }
}

class Container extends ArrayList<Box> {
   private static long count = 1;
   private final long id = count++;
   
   public Container(int numBoxes, int numCargos) {
      for (int i = 0; i < numBoxes; i++) {
         add(new Box(numCargos));
      }
   }
   
   public String toString() {
      return getClass().getSimpleName() + " " + id;
   }
}

class Ship extends ArrayList<Container> {
   public Ship(int numContainers, int numBoxes, int numCargos) {
      for (int i = 0; i < numContainers; i++) {
         add(new Container(numContainers, numCargos));
      }
   }
}

public class Ex19_ComplexContainers {
   public static void main(String[] args) {
      Ship ship = new Ship(4, 10, 5);
      
      for (Container cont : ship) {
         System.out.println("\n" + cont + ":");
         for (Box box : cont) {
            System.out.println("-- " + box + ":");
            for (Cargo cargo : box) {
               System.out.println("     " + cargo);
            }
         }
      }
   }
}
