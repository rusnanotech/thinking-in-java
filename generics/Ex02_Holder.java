/****************** Exercise 2 *****************
 * Create a holder class that holds three objects
 * of the same type, along with the methods to
 * store and fetch those objects and a constructor
 * to initialize all three.
 ************************************************/
package biz.markov.thinking.generics;

import net.mindview.thinking.typeinfo.pets.*;

public class Ex02_Holder<T> {
   private T a, b, c;
   
   public Ex02_Holder() {
   }
   
   public Ex02_Holder(T a, T b, T c) {
      this.a = a;
      this.b = b;
      this.c = c;
   }
   
   public void set(char field, T value) {
      switch (field) {
         case 'a': a = value; break;
         case 'b': b = value; break;
         case 'c': c = value; break;
      }
   }
   
   public T get(char field) {
      switch (field) {
         case 'a': return a;
         case 'b': return b;
         case 'c': return c;
         default: return null;
      }
   }
   
   public String toString() {
      return "a = " + a + ", b = " + b + ", c = " + c;
   }
   
   public static void main(String[] args) {
      Ex02_Holder<String> holder =
         new Ex02_Holder<String>("abc", "bcd", "efg");
      System.out.println(holder);
      holder.set('a', "123");
      System.out.println(holder);
      System.out.println(holder.get('a'));
      
      Ex02_Holder<Pet> holder1 = new Ex02_Holder<Pet>();
      holder1.set('a', Pets.randomPet());
      holder1.set('b', Pets.randomPet());
      holder1.set('c', Pets.randomPet());
      System.out.println(holder1);
   }
}
