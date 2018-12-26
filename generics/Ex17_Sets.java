/****************** Exercise 17 *****************
 * Study the JDK documentation for EnumSet. You'll
 * see there's a clone() method.
 * However, you cannot clone() from the reference
 * to the Set interface passed in Sets.java. Can you
 * modify Sets.java to handle both the general case
 * of a Set interface as shown, and the special case
 * of an EnumSet, using clone() instead of creating
 * a new HashSet?
 ************************************************/
package biz.markov.thinking.generics;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

enum E {
   C1, C2, C3, C4, C5, C6, C7, C8
}

public class Ex17_Sets {
   public Ex17_Sets() {
   }
   
   public static <T> Set<T> clone(Set<T> set) {
      try {
         Set<T> newset = (Set<T>) ((EnumSet<Enum>) set).clone();
         System.out.println("Using clone()");
         return newset;
      } catch (Exception e) {
         System.out.println("Using HashSet()");
         return new HashSet<T>(set);
      }
   }
   
   public static <T> Set<T> union(Set<T> a, Set<T> b) {
      Set<T> result = clone(a);
      result.addAll(b);
      return result;
   }
   
   public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
      Set<T> result = clone(a);
      result.retainAll(b);
      return result;
   }
   
   public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
      Set<T> result = clone(superset);
      result.removeAll(subset);
      return result;
   }
   
   public static <T> Set<T> complement(Set<T> a, Set<T> b) {
      return difference(union(a, b), intersection(a, b));
   }
   
   public static void main(String[] args) {
      System.out.println(difference(EnumSet.range(E.C2, E.C5), EnumSet.range(E.C4, E.C7)));
      
      Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4));
      Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 4, 5, 6));
      System.out.println(difference(set1, set2));
   }
}
