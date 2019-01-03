/****************** Exercise 35 *****************
 * Modify CheckedList.java so that it uses the Coffee
 * classes defined in this chapter.
 ************************************************/
package biz.markov.thinking.generics;

import net.mindview.thinking.generics.coffee.*;
import java.util.*;

public class Ex35_CheckedList {
   @SuppressWarnings("unchecked")
   static void oldStyleMethod(List probablyLatte) {
      probablyLatte.add(new Americano());
   }
   public static void main(String[] args) {
      List<Latte> latte1 = new ArrayList<Latte>();
      oldStyleMethod(latte1); // Quietly accepts Americano
      List<Latte> latte2 = Collections.checkedList(
         new ArrayList<Latte>(), Latte.class);
      try {
         oldStyleMethod(latte2); // Throws an exception
      } catch(Exception e) {
         System.out.println(e);
      }
      // Derived types work fine:
      List<Coffee> coffees = Collections.checkedList(
         new ArrayList<Coffee>(), Coffee.class);
      coffees.add(new Latte());
      coffees.add(new Americano());
   }
}
