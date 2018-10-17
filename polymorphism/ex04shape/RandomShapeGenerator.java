//: polymorphism/shape/RandomShapeGenerator.java
// A "factory" that randomly creates shapes.
package biz.markov.thinking.polymorphism.ex04shape;

import biz.markov.thinking.polymorphism.shape.*;

import java.util.Random;

public class RandomShapeGenerator {
  private Random rand = new Random(221);
  public Shape next() {
    switch(rand.nextInt(4)) {
      default:
      case 0: return new Circle();
      case 1: return new Square();
      case 2: return new Triangle();
      case 3: return new Hexagon();
    }
  }
} ///:~
