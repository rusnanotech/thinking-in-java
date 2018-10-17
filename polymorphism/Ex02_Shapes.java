package biz.markov.thinking.polymorphism;//: polymorphism/Ex02_Shapes.java
// Polymorphism in Java.
import biz.markov.thinking.polymorphism.shape.Shape;
import biz.markov.thinking.polymorphism.ex02shape.RandomShapeGenerator;

public class Ex02_Shapes {
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
Ex02 Triangle.draw()
Ex02 Triangle.draw()
Ex02 Square.draw()
Ex02 Triangle.draw()
Ex02 Square.draw()
Ex02 Triangle.draw()
Ex02 Square.draw()
Ex02 Triangle.draw()
Ex02 Circle.draw()
*///:~
