/****************** Exercise 20 *****************
 * Look up the interface for java.lang.Class in
 * the JDK documentation from java.sun.com.
 * Write a program that takes the name of a class
 * as a command-line argument, then uses the
 * Class methods to dump all the information
 * available for that class. Test your program
 * with a standard library class and a class you
 * create.
 ***********************************************/
package biz.markov.thinking.typeinfo;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class Ex20_ClassInfo {
   private static final Pattern p = Pattern.compile("\\w+\\.");
   private static final Object[] arg0 = {}; // Dummy argument for 'invoke' method
   private int superClassNumber = 1;
   
   private void display(Class<?> c, Method m) throws Exception {
      System.out.println();
      for (Object obj : (Object[]) m.invoke(c, arg0))
         System.out.println("\t" +
            p.matcher(obj.toString()).replaceAll("")
         );
   }
   
   public void dump(Class<?> c) {
      for (Method m : Class.class.getMethods()) {
         try {
            if (
                  m.getParameterTypes().length > 0 ||
                  m.invoke(c, arg0) == null ||
                  (
                     m.invoke(c, arg0).getClass().isArray() &&
                     ((Object[]) m.invoke(c, arg0)).length == 0
                  )
            ) continue;
   
            System.out.print(m.getName() + ": ");
   
            if (!m.getReturnType().isArray())
               System.out.println(m.invoke(c, arg0).toString());
            else
               display(c, m);
         } catch (Exception e) {
            // Skip method
         }
      }
      
      if (c.getSuperclass() != null) {
         System.out.println("\n---------------------------" +
            " Super class " + superClassNumber++ +
            " ---------------------------\n");
         dump(c.getSuperclass());
      }
   }
   
   public static void main(String[] args) {
      if (args.length == 0) {
         System.out.println("Usage: java Ex20_ClassInfo classname");
         System.exit(0);
      }
      
      try {
         new Ex20_ClassInfo().dump(Class.forName(args[0]));
      } catch (ClassNotFoundException e) {
         System.out.println("Class \"" + args[0] + "\" not found");
      }
   }
}