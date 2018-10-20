/****************** Exercise 4 *****************
 * Add a new type of Shape to Shapes.java and
 * verify in main() that polymorphism works for
 * your new type as it does in the old types.
 ***********************************************/
package biz.markov.thinking.polymorphism;//: polymorphism/Ex02_Shapes.java
// Polymorphism in Java.

import biz.markov.thinking.polymorphism.ex04shape.RandomShapeGenerator;
import biz.markov.thinking.polymorphism.shape.Shape;

public class Ex04_ShapesNew {
  private static RandomShapeGenerator gen =
    new RandomShapeGenerator();
  public static void main(String[] args) {
    Shape[] s = new Shape[9];
    // Fill up the array with shapes:
    for(int i = 0; i < s.length; i++)
      s[i] = gen.next();
    // Make polymorphic method calls:
    for(Shape shp : s)
      shp.draw();
  }
} /* Output:
Triangle.draw()
Hexagon.draw()
Hexagon.draw()
Hexagon.draw()
Square.draw()
Triangle.draw()
Circle.draw()
Hexagon.draw()
Hexagon.draw()
*///:~
