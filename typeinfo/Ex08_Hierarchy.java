/****************** Exercise 8 ******************
 * Write a method that takes an object and
 * recursively prints all the classes in that
 * object's hierarchy.
 ***********************************************/
package biz.markov.thinking.typeinfo;

public class Ex08_Hierarchy {
   public static void up(Class<?> c) {
      if (c != null) {
         System.out.println(c);
         up(c.getSuperclass());
      }
   }
   
   public static void main(String[] args) {
      if (args.length == 0) {
         System.out.println("Usage: java Ex08_Hierarchy classname");
         System.exit(0);
      }
   
      try {
         up(Class.forName(args[0]));
      } catch (ClassNotFoundException e) {
         System.out.println("Class '" + args[0] + "' not found");
      }
   }
}
