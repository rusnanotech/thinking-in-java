/********************** Exercise 2 *********************
 * Incorporate a new kind of interface into ToyTest.java
 * and verify that it is detected and displayed properly.
 ********************************************************/
package biz.markov.thinking.typeinfo;

import static net.mindview.util.Print.print;

interface Ex02_HasBatteries {}

interface Ex02_Waterproof {}

interface Ex02_Shoots {}

// Added new interfaces:
interface Ex02_Test1 {} // This interface isn't displayed
interface Ex02_Test2 {}

class Ex02_Toy implements Ex02_Test1 {
   // Comment out the following default constructor
   // to see NoSuchMethodError from (*1*)
   Ex02_Toy() {}
   Ex02_Toy(int i) {}
}

class Ex02_FancyToy extends Ex02_Toy
   implements Ex02_HasBatteries, Ex02_Waterproof, Ex02_Shoots, Ex02_Test2 {
   Ex02_FancyToy() { super(1); }
}

public class Ex02_ToyTest {
   static void printInfo(Class cc) {
      print("Class name: " + cc.getName() +
         " is interface? [" + cc.isInterface() + "]");
      print("Simple name: " + cc.getSimpleName());
      print("Canonical name : " + cc.getCanonicalName());
   }
   public static void main(String[] args) {
      Class c = null;
      try {
         c = Class.forName("biz.markov.thinking.typeinfo.Ex02_FancyToy");
      } catch(ClassNotFoundException e) {
         print("Can't find FancyToy");
         System.exit(1);
      }
      printInfo(c);
      for(Class face : c.getInterfaces())
         printInfo(face);
      Class up = c.getSuperclass();
      Object obj = null;
      try {
         // Requires default constructor:
         obj = up.newInstance();
      } catch(InstantiationException e) {
         print("Cannot instantiate");
         System.exit(1);
      } catch(IllegalAccessException e) {
         print("Cannot access");
         System.exit(1);
      }
      printInfo(obj.getClass());
   }
} /* Output:
Class name: biz.markov.thinking.typeinfo.Ex02_FancyToy is interface? [false]
Simple name: Ex02_FancyToy
Canonical name : biz.markov.thinking.typeinfo.Ex02_FancyToy
Class name: biz.markov.thinking.typeinfo.Ex02_HasBatteries is interface? [true]
Simple name: Ex02_HasBatteries
Canonical name : biz.markov.thinking.typeinfo.Ex02_HasBatteries
Class name: biz.markov.thinking.typeinfo.Ex02_Waterproof is interface? [true]
Simple name: Ex02_Waterproof
Canonical name : biz.markov.thinking.typeinfo.Ex02_Waterproof
Class name: biz.markov.thinking.typeinfo.Ex02_Shoots is interface? [true]
Simple name: Ex02_Shoots
Canonical name : biz.markov.thinking.typeinfo.Ex02_Shoots
Class name: biz.markov.thinking.typeinfo.Ex02_Test2 is interface? [true]
Simple name: Ex02_Test2
Canonical name : biz.markov.thinking.typeinfo.Ex02_Test2
Class name: biz.markov.thinking.typeinfo.Ex02_Toy is interface? [false]
Simple name: Ex02_Toy
Canonical name : biz.markov.thinking.typeinfo.Ex02_Toy
*///:~