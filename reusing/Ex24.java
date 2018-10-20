/****************** Exercise 24 ****************
 * In Beetle.java, inherit a specific type of
 * beetle from class Beetle, following the same
 * format as the existing classes. Trace and
 * explain the output.
 ***********************************************/
//: reusing/Ex24.java
// The full process of initialization.
package biz.markov.thinking.reusing;
import static net.mindview.util.Print.*;

class Insect {
  private int i = 9;
  protected int j;
  Insect() {
    print("i = " + i + ", j = " + j);
    j = 39;
  }
  private static int x1 =
    printInit("static Insect.x1 initialized");
  static int printInit(String s) {
    print(s);
    return 47;
  }
}

class Beetle extends Insect {
  private int k = printInit("Beetle.k initialized");

  public Beetle() {
    print("k = " + k);
    print("j = " + j);
  }

  private static int x2 =
          printInit("static Beetle.x2 initialized");

  public static void main(String[] args) {
    print("Beetle constructor");
    Beetle b = new Beetle();
  }
}

class ColoradoBeetle extends Beetle {
  private int k = printInit("ColoradoBeetle.k initialized");

  ColoradoBeetle() {
    print("k = " + k);
    print("j = " + j);
  }

  private static int x3 =
          printInit("static ColoradoBeetle.x3 initialized");
}

public class Ex24 {
  public static void main(String args[]) {
    print("ColoradoBeetle constructor");
    ColoradoBeetle b = new ColoradoBeetle();
  }
}
/* Output
ColoradoBeetle constructor
static Insect.x1 initialized
static Beetle.x2 initialized
static ColoradoBeetle.x3 initialized
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
ColoradoBeetle.k initialized
k = 47
j = 39
 */