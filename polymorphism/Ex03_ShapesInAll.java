package biz.markov.thinking.polymorphism;//: polymorphism/Ex02_Shapes.java
// Polymorphism in Java.

import biz.markov.thinking.polymorphism.ex03shape.in_all.RandomShapeGenerator;
import biz.markov.thinking.polymorphism.ex03shape.in_all.Shape;

public class Ex03_ShapesInAll {
  private static RandomShapeGenerator gen =
    new RandomShapeGenerator();
  public static void main(String[] args) {
    Shape[] s = new Shape[9];
    // Fill up the array with shapes:
    for(int i = 0; i < s.length; i++)
      s[i] = gen.next();
    // Make polymorphic method calls:
    for(Shape shp : s)
      shp.scale();
  }
} /* Output:
Triangle.scale()
Triangle.scale()
Square.scale()
Triangle.scale()
Square.scale()
Triangle.scale()
Square.scale()
Triangle.scale()
Circle.scale()
*///:~
