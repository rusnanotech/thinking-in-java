//: polymorphism/shape/Square.java
package biz.markov.thinking.polymorphism.ex03shape.in_one;

import static net.mindview.util.Print.print;

public class Square extends Shape {
  public void draw() { print("Square.draw()"); }
  public void erase() { print("Square.erase()"); }
  public void scale() { print("Square.scale()"); }
} ///:~
