package biz.markov.thinking.holding;

import java.util.*;

public class My06_ForVsForeach {
   public static void main(String[] args) {
      List<Ex07_A> l = new ArrayList<Ex07_A>();
      for (int i = 0; i < 5; i++)
         l.add(new Ex07_A());
   
      System.out.println(l);
      
      for (Ex07_A a : l)
         a = new Ex07_A();
   
      System.out.println(l);
      
      for (int i = 0; i < l.size(); i++)
         l.set(i, new Ex07_A());
   
      System.out.println(l);
      
      List<Integer> lst = new ArrayList<Integer>(Arrays.asList(1, 5));
      System.out.println(lst);
      Iterator<Integer> iter = lst.iterator();
      iter.next();
      iter.next();
      iter.next();
   }
}
