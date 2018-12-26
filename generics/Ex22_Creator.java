/****************** Exercise 22 *****************
 * Use a type tag along with reflection to create
 * a method that uses the argument version of
 * newInstance() to create an object of a class
 * with a constructor that has arguments.
 ************************************************/
package biz.markov.thinking.generics;

import java.util.Arrays;

class Ex22_Obj {
   private String s;
   private Integer i;
   private int[] a;
   
   public Ex22_Obj(String s, Integer i, int[] a) {
      this.s = s;
      this.i = i;
      this.a = a;
   }
   
   public String toString() {
      return s + " " + i + " " + Arrays.toString(a);
   }
}

public class Ex22_Creator {
   public static <T> T create(Class<T> type, Object... args) throws Exception {
      Class<?>[] argTypes = new Class<?>[args.length];
      
      for (int i = 0; i < argTypes.length; i++)
         argTypes[i] = args[i].getClass();
         
      return type.getConstructor(argTypes).newInstance(args);
   }
   
   public static void main(String[] args) throws Exception {
      System.out.println(Ex22_Creator.create(
         Ex22_Obj.class,"abc", 5, new int[2]));
   }
}
