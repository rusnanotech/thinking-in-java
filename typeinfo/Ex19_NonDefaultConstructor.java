/****************** Exercise 19 *****************
 * In ToyTest.java, use reflection to create a
 * Toy object using the nondefault constructor.
 ***********************************************/
package biz.markov.thinking.typeinfo;

import java.lang.reflect.*;

public class Ex19_NonDefaultConstructor {
   public static void main(String[] args) {
      Constructor[] constructors = Ex01_Toy.class.getConstructors();
      Ex01_Toy toy = null;
      
      for (Constructor constructor : constructors)
         try {
            toy = (Ex01_Toy)constructor.newInstance(1);
            System.out.println("Created new " + toy.getClass().getSimpleName());
            break;
         } catch (Exception e) { }
      
      if (toy == null)
         System.out.println("Can't create new object");
   }
}
