/****************** Exercise 13 *****************
 * Overload the fill() method so the arguments
 * and return types are the specific subtypes of
 * Collection: List, Queue and Set. This way, you
 * don't lose the type of container. Can you overload
 * to distinguish between List and LinkedList?
 ************************************************/
package biz.markov.thinking.generics;
//: generics/Generators.java
// A utility to use with Generators.

import net.mindview.thinking.generics.Fibonacci;
import net.mindview.thinking.generics.coffee.Coffee;
import net.mindview.thinking.generics.coffee.CoffeeGenerator;
import net.mindview.util.Generator;

import java.util.*;

public class Ex13_Overloading {
   public static <T> Set<T>
   fill(Set<T> coll, Generator<T> gen, int n) {
      for (int i = 0; i < n; i++)
         coll.add(gen.next());
      return coll;
   }
   
   public static <T> Queue<T>
   fill(Queue<T> coll, Generator<T> gen, int n) {
      for (int i = 0; i < n; i++)
         coll.offer(gen.next());
      return coll;
   }
   
   public static <T> List<T>
   fill(List<T> coll, Generator<T> gen, int n) {
      for (int i = 0; i < n; i++)
         coll.add(gen.next());
      return coll;
   }
   
   public static void main(String[] args) {
      Collection<Coffee> coffee = fill(
         (List<Coffee>) new LinkedList<Coffee>(), new CoffeeGenerator(), 4);
      for (Coffee c : coffee)
         System.out.println(c);
      Collection<Integer> fnumbers = fill(
         new ArrayList<Integer>(), new Fibonacci(), 12);
      for (int i : fnumbers)
         System.out.print(i + ", ");
   }
}
