/****************** Exercise 27 *****************
 * Show that covariance doesn’t work with Lists,
 * using Numbers and Integers, then introduce
 * wildcards.
 ************************************************/
package biz.markov.thinking.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex27_GenericsAndCovariance {
   public static void main(String[] args) {
      //! List<Number> list = new ArrayList<Integer>();
      //! List<? extends Number> list1 = new ArrayList<Character>(Arrays.asList('a', 'c', 'g'));
      
      List<? extends Number> list = new ArrayList<Integer>(Arrays.asList(1, 41, 8, 90));
      System.out.println(list);
      int b = (Integer) list.get(2);
      System.out.println(b);
      list.add(null);
      Integer c = (Integer) list.get(list.size() - 1);
      System.out.println(c);
      //! list.add(new Integer(7));
      
      list = new ArrayList<Double>(Arrays.asList(32.89, 9.01, 3.23));
      System.out.println(list);
      //! list.add(new Double(8.4));
   }
}
