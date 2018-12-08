/****************** Exercise 9 ******************
 * Modify the previous exercise so that it uses
 * Class.getDeclaredFields() to also display
 * information about the fields in a class.
 ***********************************************/
package biz.markov.thinking.typeinfo;

import java.lang.reflect.Field;

public class Ex09_Hierarchy {
   public static void up(Class<?> c) {
      if (c != null) {
         System.out.println(c);
         for (Field f : c.getDeclaredFields())
            System.out.println("\t" + f.getName());
         up(c.getSuperclass());
      }
   }
   
   public static void main(String[] args) {
      if (args.length == 0) {
         System.out.println("Usage: java Ex09_Hierarchy classname");
         System.exit(0);
      }
   
      try {
         up(Class.forName(args[0]));
      } catch (ClassNotFoundException e) {
         System.out.println("Class '" + args[0] + "' not found");
      }
   }
}
