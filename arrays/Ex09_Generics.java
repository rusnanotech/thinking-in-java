/****************** Exercise 9 *****************
 * Create the classes necessary for the Peel<Banana>
 * example and show that the compiler doesn’t accept
 * it. Fix the problem using an ArrayList.
 ***********************************************/
package biz.markov.thinking.arrays;

import java.util.ArrayList;
import java.util.List;

class Banana {}

class Peel<T> {}

@SuppressWarnings("unchecked")
public class Ex09_Generics {
   public static void main(String[] args) {
      Peel<Banana>[] peels = (Peel<Banana>[]) new Peel[9]; // unchecked cast
      //! Peel<Banana>[] peels = new Peel<Banana>[9]; // Compiler doesn't accept this
      peels[0] = new Peel(); // unchecked cast
      // Incompatible types. Doesn't compile:
      //! peels[1] = new Peel<Object>();
      //! peels[1] = new Object();
      //! Peel<Integer> peel3 = peels[2];
      peels[2] = new Peel<Banana>(); // All right
      Peel<Banana> peel = peels[2]; // OK
      Peel peel2 = peels[2]; // OK
      
      List<Peel<Banana>> peelList = new ArrayList<Peel<Banana>>();
      peelList.add(new Peel<Banana>());
      peelList.add(new Peel()); // unchecked assignment
      Object o = peelList.get(0);
      Peel peel3 = peelList.get(0);
      Peel<Banana> peel4 = peelList.get(0);
   
      // Incompatible types. Doesn't compile:
      //! Peel<Double> peel5 = peelList.get(0);
      //! peelList.add(new Peel<Object>());
      //! peelList.add(new Object());
      
   }
}
