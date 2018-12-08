/****************** Exercise 12 *****************
 * Use TypeCounter with the Ex16_CoffeeGenerator.java
 * class in the Generics chapter.
 ***********************************************/
package biz.markov.thinking.typeinfo;

import net.mindview.util.TypeCounter;
import net.mindview.thinking.generics.coffee.*;
import static net.mindview.util.Print.*;

public class Ex12_CoffeeCount {
   public static void main(String[] args) {
      TypeCounter counter = new TypeCounter(Coffee.class);
      Ex16_CoffeeGenerator gen = new Ex16_CoffeeGenerator(20);
      
      for(Coffee coffee : gen) {
         printnb(coffee.getClass().getSimpleName() + " ");
         counter.count(coffee);
      }
      print();
      print(counter);
   }
}
