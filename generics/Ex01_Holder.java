/****************** Exercise 1 *****************
 * Use Holder3 with the typeinfo.pets library to
 * show that a Holder3 that is specified to hold
 * a base type can also hold a derived type.
 ************************************************/
package biz.markov.thinking.generics;

import net.mindview.thinking.typeinfo.pets.*;
import java.util.*;

class Holder3<T> {
   private T a;
   
   Holder3(T a) {
      this.a = a;
   }
   
   public void set(T a) {
      this.a = a;
   }
   
   public T get() {
      return a;
   }
   
   public static void main(String[] args) {
      Holder3<Pet> h3 =
         new Holder3<Pet>(new Pet());
      Pet a = h3.get();
   }
}

public class Ex01_Holder {
   public static void main(String[] args) {
      List<Holder3<Pet>> cells = new ArrayList<Holder3<Pet>>();
   
      for (int i = 0; i < 10; i++) {
         Pet pet = Pets.randomPet();
         System.out.println(pet);
         cells.add(new Holder3<Pet>(pet));
      }
      System.out.println();
      
      for (Holder3<Pet> cell : cells)
         System.out.println(cell.get());
   }
}