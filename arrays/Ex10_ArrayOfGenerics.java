/****************** Exercise 10 *****************
 * Modify ArrayOfGenerics.java to use containers
 * instead of arrays. Show that you can eliminate
 * the compile-time warnings.
 ************************************************/
package biz.markov.thinking.arrays;

import java.util.*;

public class Ex10_ArrayOfGenerics {
   public static void main(String[] args) {
      List<List<String>> ls = new ArrayList<List<String>>();
      ls.add(new ArrayList<String>());
      
      // Compile-time checking produces an error:
      //! ls.add(new ArrayList<Integer>());
      //! List<Object> objects = ls;
   }
}
