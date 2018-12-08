/****************** Exercise 6 ******************
 * Modify Shapes.java so that it can "highlight"
 * (set a flag) in all shapes of a particular
 * type. The toString() method for each derived
 * Shape should indicate whether that Shape is
 * "highlighted."
 ***********************************************/
package biz.markov.thinking.typeinfo;

import java.util.*;

class Ex06_Shape {
   private static Set<Class<?>> highlighted = new HashSet<Class<?>>();
   
   public static boolean highlightCheck(Class<?> c) {
      return highlighted.contains(c);
   }
   
   public static void highlightOn(Class<?> c) { highlighted.add(c); }
   
   public static void highlightOff(Class<?> c) { highlighted.remove(c); }
   
   public void draw() { System.out.println(this + ".draw()"); }
   
   public String toString() {
      return (highlightCheck(getClass()) ? "on:  " : "off: ") +
         getClass().getSimpleName();
   }
}

class Ex06_Circle extends Ex06_Shape { }

class Ex06_Square extends Ex06_Shape { }

class Ex06_Triangle extends Ex06_Shape { }

class Ex06_Rhomboid extends Ex06_Shape { }

public class Ex06_Shapes {
   public static void drawShapes(Ex06_Shape[] shapes) {
      for(Ex06_Shape shape : shapes)
         shape.draw();
      System.out.println();
   }
   
   public static void main(String[] args) {
      Ex06_Shape[] shapes = {
         new Ex06_Circle(),   new Ex06_Circle(),   new Ex06_Circle(),
         new Ex06_Square(),   new Ex06_Square(),   new Ex06_Square(),
         new Ex06_Triangle(), new Ex06_Triangle(), new Ex06_Triangle(),
         new Ex06_Rhomboid(), new Ex06_Rhomboid(), new Ex06_Rhomboid()
      };
      
      drawShapes(shapes);
   
      for (int i = 0; i < shapes.length; i += 3) {
         Ex06_Shape.highlightOn(shapes[i].getClass());
         System.out.println("Highlight on: " + shapes[i].getClass().getSimpleName());
      }
      System.out.println();
   
      drawShapes(shapes);
      
      for (int i = 3; i < shapes.length; i += 3) {
         Ex06_Shape.highlightOff(shapes[i].getClass());
         System.out.println("Highlight off: " + shapes[i].getClass().getSimpleName());
      }
      System.out.println();
   
      drawShapes(shapes);
   }
}
