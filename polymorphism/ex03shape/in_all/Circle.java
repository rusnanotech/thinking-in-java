//: polymorphism/shape/Circle.java
package biz.markov.thinking.polymorphism.ex03shape.in_all;

import static net.mindview.util.Print.print;

public class Circle extends Shape {
  public void draw() { print("Circle.draw()"); }
  public void erase() { print("Circle.erase()"); }
  public void scale() { print("Circle.scale()"); }
} ///:~
