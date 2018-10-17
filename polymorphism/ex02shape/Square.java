//: polymorphism/ex02shape/Square.java
package biz.markov.thinking.polymorphism.ex02shape;
import biz.markov.thinking.polymorphism.shape.Shape;
import static net.mindview.util.Print.*;

public class Square extends Shape {
  @Override public void draw() { print("Ex02 Square.draw()"); }
  @Override public void erase() { print("Ex02 Square.erase()"); }
} ///:~
