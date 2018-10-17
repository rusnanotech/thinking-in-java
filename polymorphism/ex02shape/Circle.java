//: polymorphism/ex02shape/Circle.java
package biz.markov.thinking.polymorphism.ex02shape;
import biz.markov.thinking.polymorphism.shape.Shape;
import static net.mindview.util.Print.*;

public class Circle extends Shape {
  @Override public void draw() { print("Ex02 Circle.draw()"); }
  @Override public void erase() { print("Ex02 Circle.erase()"); }
} ///:~
