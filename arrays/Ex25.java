/****************** Exercise 25 *****************
 * Rewrite PythonLists.py in Java.
 ************************************************/
package biz.markov.thinking.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class MyList<T> extends LinkedList<T> {
   public MyList() {
      super();
   }
   
   public MyList(List<T> list) {
      super(list);
   }
   
   MyList<T> getReversed() {
      MyList<T> list = new MyList<T>(this);
      Collections.reverse(list);
      
      return list;
   }
}

public class Ex25 {
   public static void main(String[] args) {
      List<Integer> aList = new LinkedList<Integer>(
         Arrays.asList(1, 2, 3, 4, 5)
      );
      System.out.println(aList.getClass().getSimpleName());
      System.out.println(aList);
      System.out.println(aList.get(4));
      aList.add(6);
      aList.addAll(Arrays.asList(7, 8));
      System.out.println(aList);
      List<Integer> aSlice = aList.subList(2, 4);
      System.out.println(aSlice);
      
      MyList<Integer> list2 = new MyList<Integer>(aList);
      System.out.println(list2.getClass().getSimpleName());
      System.out.println(list2.getReversed());
   }
}
