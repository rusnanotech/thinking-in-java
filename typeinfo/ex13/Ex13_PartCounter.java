/****************** Exercise 13 *****************
 * Use TypeCounter with the RegisteredFactories.java
 * example in this chapter.
 ***********************************************/
package biz.markov.thinking.typeinfo.ex13;

import net.mindview.util.TypeCounter;
import static net.mindview.util.Print.*;
import net.mindview.thinking.typeinfo.factory.Factory;

public class Ex13_PartCounter {
   public static void main(String[] args) {
      TypeCounter counter = new TypeCounter(Part.class);
      
      for(Factory factory : Part.partFactories) {
         printnb(factory.getClass().getSimpleName() + " ");
         counter.count(factory.create());
      }
      print();
      print(counter);
   }
}