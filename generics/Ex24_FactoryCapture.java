/****************** Exercise 23 *****************
 * Modify Exercise 21 so that factory objects are
 * held in the Map instead of Class<?>.
 ************************************************/
package biz.markov.thinking.generics;
//: generics/ClassTypeCapture.java

import java.util.HashMap;
import java.util.Map;

interface Ex24_Factory<T> {
   T create();
}

class Ex24_IntegerFactory implements Ex24_Factory<Integer> {
   public Integer create() {
      return 15;
   }
}

class Ex24_DoubleFactory implements Ex24_Factory<Double> {
   public Double create() {
      return 3.14;
   }
}

public class Ex24_FactoryCapture<T> {
   Class<T> kind;
   Map<String,Ex24_Factory<? extends T>> factories =
      new HashMap<String,Ex24_Factory<? extends T>>();
   
   public Ex24_FactoryCapture(Class<T> kind) {
      this.kind = kind;
   }
   
   public void addType(String typename, Ex24_Factory<? extends T> factory) {
      factories.put(typename, factory);
   }
   
   public T createNew(String typename) {
      return factories.get(typename).create();
   }
   
   public boolean f(Object arg) {
      return kind.isInstance(arg);
   }
   
   public static void main(String[] args) {
      Ex24_FactoryCapture<Number> ctt1 =
         new Ex24_FactoryCapture<Number>(Number.class);
      
      ctt1.addType("Integer", new Ex24_IntegerFactory());
      ctt1.addType("Double", new Ex24_DoubleFactory());
   
      Number a = ctt1.createNew("Integer");
      Number b = ctt1.createNew("Double");
      System.out.println(ctt1.f(b));
   }
}
