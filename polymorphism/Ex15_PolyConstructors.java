/****************** Exercise 15 *****************
 * Add a RectangularGlyph to PolyConstructors.java
 * and demonstrate the problem described in this
 * section.
 ***********************************************/
//: polymorphism/Ex15_PolyConstructors.java
// Constructors and polymorphism
// don't produce what you might expect.
package biz.markov.thinking.polymorphism;
import static net.mindview.util.Print.*;

class Glyph {
  void draw() { print("Glyph.draw()"); }
  Glyph() {
    print("Glyph() before draw()");
    draw();
    print("Glyph() after draw()");
  }

  void move() {
    print("Glyph.move");
    draw();
  }
}	

class RoundGlyph extends Glyph {
  private int radius = 1;
  RoundGlyph(int r) {
    radius = r;
    print("RoundGlyph.RoundGlyph(), radius = " + radius);
  }
  void draw() {
    print("RoundGlyph.draw(), radius = " + radius);
  }
}

class RectangularGlyph extends Glyph {
  private int h = 1;
  private int l = 1;
  RectangularGlyph(int h, int l) {
      this.h = h;
      this.l = l;
    print("RectangularGlyph.RectangularGlyph(), height = " + h + ", length " + l);
  }
  void draw() {
    print("RectangularGlyph.draw(), height = " + h + ", length " + l);
  }
}

public class Ex15_PolyConstructors {
  public static void main(String[] args) {
    Glyph roundGlyph = new RoundGlyph(5);
    roundGlyph.move();
    print();
    Glyph glyth = new Glyph();
    glyth.move();
    print();
    Glyph rectangularGlyth = new RectangularGlyph(4, 8);
    rectangularGlyth.move();
  }
}
