package biz.markov.thinking.typeinfo;
//: typeinfo/RegisteredFactories.java
// Registering Class Factories in the base class.

import net.mindview.thinking.typeinfo.factory.Factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Ex24_AbstractPart {
}

interface Ex24_Null {
}

class Ex24_Part implements Ex24_AbstractPart {
   public String toString() {
      return getClass().getSimpleName();
   }
   
   static List<Factory<? extends Ex24_Part>> partFactories =
      new ArrayList<Factory<? extends Ex24_Part>>();
   
   static {
      // Collections.addAll() gives an "unchecked generic
      // array creation ... for varargs parameter" warning.
      partFactories.add(new Ex24_FuelFilter.Factory());
      partFactories.add(new Ex24_AirFilter.Factory());
      partFactories.add(new Ex24_CabinAirFilter.Factory());
      partFactories.add(new Ex24_OilFilter.Factory());
      partFactories.add(new Ex24_FanBelt.Factory());
      partFactories.add(new Ex24_PowerSteeringBelt.Factory());
      partFactories.add(new Ex24_GeneratorBelt.Factory());
   }
   
   private static Random rand = new Random(47);
   
   public static Ex24_Part createRandom() {
      int n = rand.nextInt(partFactories.size());
      return partFactories.get(n).create();
   }
   
   public static Ex24_AbstractPart createNull(Class<? extends Ex24_AbstractPart> type) {
      return (Ex24_AbstractPart) Proxy.newProxyInstance(
         Ex24_Part.class.getClassLoader(),
         new Class<?>[]{Ex24_AbstractPart.class, Ex24_Null.class},
         new Ex24_NullPartProxyHandler(type)
      );
   }
}

class Ex24_NullPartProxyHandler implements InvocationHandler {
   private String name;
   private Ex24_AbstractPart proxied = new Ex24_NPart();
   
   Ex24_NullPartProxyHandler(Class<? extends Ex24_AbstractPart> type) {
      name = "Null " + type.getSimpleName();
   }
   
   private class Ex24_NPart implements Ex24_AbstractPart, Ex24_Null {
      public String toString() {
         return name;
      }
   }
   
   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      return method.invoke(proxied, args);
   }
}

class Ex24_Filter extends Ex24_Part {
}

class Ex24_FuelFilter extends Ex24_Filter {
   // Create a Class Factory for each specific type:
   public static class Factory
      implements net.mindview.thinking.typeinfo.factory.Factory<Ex24_FuelFilter> {
      public Ex24_FuelFilter create() {
         return new Ex24_FuelFilter();
      }
   }
}

class Ex24_AirFilter extends Ex24_Filter {
   public static class Factory
      implements net.mindview.thinking.typeinfo.factory.Factory<Ex24_AirFilter> {
      public Ex24_AirFilter create() {
         return new Ex24_AirFilter();
      }
   }
}

class Ex24_CabinAirFilter extends Ex24_Filter {
   public static class Factory
      implements net.mindview.thinking.typeinfo.factory.Factory<Ex24_CabinAirFilter> {
      public Ex24_CabinAirFilter create() {
         return new Ex24_CabinAirFilter();
      }
   }
}

class Ex24_OilFilter extends Ex24_Filter {
   public static class Factory
      implements net.mindview.thinking.typeinfo.factory.Factory<Ex24_OilFilter> {
      public Ex24_OilFilter create() {
         return new Ex24_OilFilter();
      }
   }
}

class Ex24_Belt extends Ex24_Part {
}

class Ex24_FanBelt extends Ex24_Belt {
   public static class Factory
      implements net.mindview.thinking.typeinfo.factory.Factory<Ex24_FanBelt> {
      public Ex24_FanBelt create() {
         return new Ex24_FanBelt();
      }
   }
}

class Ex24_GeneratorBelt extends Ex24_Belt {
   public static class Factory
      implements net.mindview.thinking.typeinfo.factory.Factory<Ex24_GeneratorBelt> {
      public Ex24_GeneratorBelt create() {
         return new Ex24_GeneratorBelt();
      }
   }
}

class Ex24_PowerSteeringBelt extends Ex24_Belt {
   public static class Factory
      implements net.mindview.thinking.typeinfo.factory.Factory<Ex24_PowerSteeringBelt> {
      public Ex24_PowerSteeringBelt create() {
         return new Ex24_PowerSteeringBelt();
      }
   }
}

public class Ex24_RegisteredFactories {
   public static void main(String[] args) {
      List<Ex24_AbstractPart> parts = new ArrayList<Ex24_AbstractPart>();
      for (int i = 0; i < 10; i++)
         parts.add(Ex24_Part.createRandom());
      
      List<Ex24_AbstractPart> nullParts = new ArrayList<Ex24_AbstractPart>();
      for (Ex24_AbstractPart part : parts)
         nullParts.add(Ex24_Part.createNull(part.getClass()));
      
      for (Ex24_AbstractPart part : parts)
         System.out.println(part);
      
      System.out.println();
      
      for (Ex24_AbstractPart part : nullParts) {
         System.out.println(part);
         System.out.println(part instanceof Ex24_AbstractPart &&
                            part instanceof Ex24_Null);
      }
   }
}
