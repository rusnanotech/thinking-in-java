/****************** Exercise 21 *****************
 * Modify ClassTypeCapture.java by adding a
 * Map<String,Class<?>>, a method
 * addType(String typename, Class<?> kind), and a
 * method createNew(String typename).createNew()
 * will either produce a new instance of the class
 * associated with its argument string, or produce
 * an error message.
 ************************************************/
package biz.markov.thinking.generics;
//: generics/ClassTypeCapture.java

import java.util.*;

class Building {
}

class House extends Building {
}

public class Ex21_ClassTypeCapture<T> {
   Class<T> kind;
   Map<String,Class<? extends T>> types =
      new HashMap<String, Class<? extends T>>();
   
   public Ex21_ClassTypeCapture(Class<T> kind) {
      this.kind = kind;
   }
   
   public void addType(String typename, Class<? extends T> kind) {
      types.put(typename, kind);
   }
   
   public T createNew(String typename) {
      try {
         return types.get(typename).newInstance();
      } catch (Exception e) {
         System.out.println("Cannot create " + typename);
         return null;
      }
   }
   
   public boolean f(Object arg) {
      return kind.isInstance(arg);
   }
   
   public static void main(String[] args) {
      Ex21_ClassTypeCapture<Building> ctt1 =
         new Ex21_ClassTypeCapture<Building>(Building.class);
      
      ctt1.addType("Building", Building.class);
      ctt1.addType("House", House.class);
      //! ctt1.addType("Double", Double.class);
   
      Building d = ctt1.createNew("Double");
      Building b = ctt1.createNew("House");
      System.out.println(ctt1.f(b));
   }
}
