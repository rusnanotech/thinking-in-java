/****************** Exercise 3 ******************
 * Add Rhomboid to Shapes.java. Create a
 * Rhomboid, upcast it to a Shape, then downcast
 * it back to a Rhomboid. Try downcasting to a
 * Circle and see what happens.
 ***********************************************/
package biz.markov.thinking.typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
   void draw() { System.out.println(this + ".draw()"); }
   abstract public String toString();
}

class Circle extends Shape {
   public String toString() { return "Circle"; }
}

class Square extends Shape {
   public String toString() { return "Square"; }
}

class Triangle extends Shape {
   public String toString() { return "Triangle"; }
}

// New class added:
class Rhomboid extends Shape {
   public String toString() { return "Rhomboid"; }
}

public class Ex03_Shapes {
   public static void main(String[] args) {
      List<Shape> shapeList = Arrays.asList(
         new Circle(), new Square(), new Triangle(), new Rhomboid()
      );
      for(Shape shape : shapeList)
         shape.draw();
   
      ((Rhomboid) shapeList.get(3)).draw();
      ((Circle) shapeList.get(3)).draw();
   }
} /* Output:
Circle.draw()
Square.draw()
Triangle.draw()
Rhomboid.draw()
Rhomboid.draw()
Exception in thread "main" java.lang.ClassCastException:
biz.markov.thinking.typeinfo.Rhomboid cannot be cast
to biz.markov.thinking.typeinfo.Circle
	at biz.markov.thinking.typeinfo.Ex03_Shapes.main
	(Ex03_Shapes.java:35)
*///:~
