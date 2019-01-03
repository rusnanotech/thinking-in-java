/****************** Exercise 40 *****************
 * Add a speak() method to all the pets in
 * typeinfo.pets. Modify Apply.java to call the
 * speak() method for a heterogeneous collection
 * of Pet.
 ************************************************/
package biz.markov.thinking.generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import biz.markov.thinking.generics.libs.pets.*;

public class Ex40_Apply {
   public static <T, S extends Iterable<? extends T>>
   void apply(S seq, Method f, Object... args) {
      try {
         for (T t : seq)
            f.invoke(t, args);
      } catch (Exception e) {
         // Failures are programmer errors
         throw new RuntimeException(e);
      }
   }
}

class Ex40_ApplyTest {
   public static void main(String[] args) throws Exception {
      Ex40_Apply.apply(Pets.arrayList(10), Pet.class.getMethod("speak"));
      
      List<Dog> dogs = new ArrayList<Dog>();
      dogs.add(new Dog("Бобик"));
      dogs.add(new Dog("Шарик"));
      dogs.add(new Dog("Тузик"));
      
      Ex40_Apply.apply(dogs, Pet.class.getMethod("speak"));
   }
}
