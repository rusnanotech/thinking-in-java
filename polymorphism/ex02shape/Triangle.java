//: polymorphism/ex02shape/Triangle.java
package biz.markov.thinking.polymorphism.ex02shape;
import biz.markov.thinking.polymorphism.shape.Shape;
import static net.mindview.util.Print.*;

public class Triangle extends Shape {
  @Override public void draw() { print("Ex02 Triangle.draw()"); }
  @Override public void erase() { print("Ex02 Triangle.erase()"); }
} ///:~
