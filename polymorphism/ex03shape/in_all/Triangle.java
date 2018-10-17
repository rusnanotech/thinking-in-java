//: polymorphism/shape/Triangle.java
package biz.markov.thinking.polymorphism.ex03shape.in_all;

import static net.mindview.util.Print.print;

public class Triangle extends Shape {
  public void draw() { print("Triangle.draw()"); }
  public void erase() { print("Triangle.erase()"); }
  public void scale() { print("Triangle.scale()"); }
} ///:~
