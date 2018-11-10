/****************** Exercise 32 *****************
 * Following the example of MultiIterableClass,
 * add reversed() and randomized() methods to
 * NonCollectionSequence.java, as well as making
 * NonCollectionSequence implement Iterable, and
 * show that all the approaches work in foreach
 * statements.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;
import net.mindview.thinking.typeinfo.pets.*;

class PetSequence {
   protected Pet[] pets = Pets.createArray(8);
}

public class Ex32_MultiIterable extends PetSequence
implements Iterable<Pet> {
   public Iterator<Pet> iterator() {
      return new Iterator<Pet>() {
         private int index = 0;
         public boolean hasNext() {
            return index < pets.length;
         }
         public Pet next() { return pets[index++]; }
         public void remove() { // Not implemented
            throw new UnsupportedOperationException();
         }
      };
   }
   
   public Iterable<Pet> reversed() {
      return new Iterable<Pet>() {
         public Iterator<Pet> iterator() {
            return new Iterator<Pet>() {
               private int index = pets.length - 1;
         
               public boolean hasNext() {
                  return index > -1;
               }
         
               public Pet next() {
                  return pets[index--];
               }
         
               public void remove() {
                  throw new UnsupportedOperationException();
               }
            };
         }
      };
   }
   
   public Iterable<Pet> randomized() {
      return new Iterable<Pet>() {
         public Iterator<Pet> iterator() {
            List<Pet> list = new ArrayList<Pet>(Arrays.asList(pets));
            
            Collections.shuffle(list, new Random(System.nanoTime()));
            
            return list.iterator();
         }
      };
   }
   
   public static void display(Iterable<Pet> itb) {
      for (Pet p : itb) {
         System.out.print(p.id() + ":" + p + " ");
      }
      System.out.println();
   }
   
   public static void main(String[] args) {
      Ex32_MultiIterable nc = new Ex32_MultiIterable();
      display(nc);
      display(nc.reversed());
      display(nc.randomized());
   }
}
