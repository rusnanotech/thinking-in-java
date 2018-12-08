/********************** Exercise 1 *********************
 * In ToyTest.java, comment out Toy's default constructor
 * and explain what happens.
 *******************************************************/
package biz.markov.thinking.typeinfo;

import static net.mindview.util.Print.print;

interface Ex01_HasBatteries {}

interface Ex01_Waterproof {}

interface Ex01_Shoots {}

class Ex01_Toy {
  // Comment out the following default constructor
  // to see NoSuchMethodError from (*1*)
  // Ex01_Toy() {}
  public Ex01_Toy(int i) {} // added 'public' keyword for exercise 19
}

class Ex01_FancyToy extends Ex01_Toy
   implements Ex01_HasBatteries, Ex01_Waterproof, Ex01_Shoots {
  Ex01_FancyToy() { super(1); }
}

public class Ex01_ToyTest {
  static void printInfo(Class cc) {
    print("Class name: " + cc.getName() +
       " is interface? [" + cc.isInterface() + "]");
    print("Simple name: " + cc.getSimpleName());
    print("Canonical name : " + cc.getCanonicalName());
  }
  public static void main(String[] args) {
    Class c = null;
    try {
      c = Class.forName("biz.markov.thinking.typeinfo.Ex01_FancyToy");
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
Class name: biz.markov.thinking.typeinfo.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name : biz.markov.thinking.typeinfo.FancyToy
Class name: biz.markov.thinking.typeinfo.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name : biz.markov.thinking.typeinfo.HasBatteries
Class name: biz.markov.thinking.typeinfo.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name : biz.markov.thinking.typeinfo.Waterproof
Class name: biz.markov.thinking.typeinfo.Shoots is interface? [true]
Simple name: Shoots
Canonical name : biz.markov.thinking.typeinfo.Shoots
Cannot instantiate
*///:~