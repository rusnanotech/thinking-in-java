/****************** Exercise 25 *****************
 * Create a class containing private, protected and
 * package access methods. Write code to access these
 * methods from outside of the class’s package.
 ************************************************/
package biz.markov.thinking.typeinfo;

import java.lang.reflect.*;
import java.util.*;

import biz.markov.thinking.typeinfo.ex25.A;

public class Ex25_Access {
   private static final List<Class<?>> primitives = new ArrayList<Class<?>>(
      Arrays.asList(boolean.class, byte.class, char.class, short.class,
         int.class, long.class, float.class, double.class));
   
   private static final List<Class<?>> boxed = new ArrayList<Class<?>>(
      Arrays.asList(Boolean.class, Byte.class, Character.class,
         Short.class, Integer.class, Long.class, Float.class, Double.class));
   
   public static void call(Object o, String name, Object... args) throws Exception {
      Class<?>[] types = new Class<?>[args.length];
      for (int i = 0; i < types.length; i++) {
         types[i] = args[i].getClass();
         if (boxed.contains(types[i]))
            types[i] = primitives.get(boxed.indexOf(types[i]));
      }
      
      Method m = o.getClass().getDeclaredMethod(name, types);
      m.setAccessible(true);
      m.invoke(o, args);
   }
   
   public static void main(String[] args) throws Exception {
      A a = new A();
   
      call(a, "f" );
      call(a, "g", true);
      call(a, "h", 8, 'c', "abc");
   }
}
