/****************** Exercise 13 *****************
 * Add a finalize() method to ReferenceCounting.java
 * to verify the termination condition. (See
 * the Initialization & Cleanup chapter.)
 116
 Thinking in Java, 4th Edition Annotated Solution Guide
 ***********************************************/
//: polymorphism/Ex13_ReferenceCounting.java
// Cleaning up shared member objects.
package biz.markov.thinking.polymorphism;
import static net.mindview.util.Print.*;

class Shared {
  private int refcount = 0;
  private static long counter = 0;
  private final long id = counter++;
  public Shared() {
    print("Creating " + this);
  }
  public void addRef() { refcount++; }
  protected void dispose() {
    if(--refcount == 0)
      print("Disposing " + this);
  }
  public String toString() { return "Shared " + id; }
  protected void finalize() {
    System.out.print("Finalizing Shared " + id + "... ");
    if (refcount > 0)
      System.out.println("error: refcount > 0 ");
    else
      System.out.println("successful");
  }
}

class Composing {
  private Shared shared;
  private static long counter = 0;
  private final long id = counter++;
  public Composing(Shared shared) {
    print("Creating " + this);
    this.shared = shared;
    this.shared.addRef();
  }
  protected void dispose() {
    print("disposing " + this);
    shared.dispose();
  }
  public String toString() { return "Composing " + id; }
  protected void finalize() {
    System.out.println("Finalizing Composing " + id + "... ");
  }
}

public class Ex13_ReferenceCounting {
  public static void main(String[] args) {
    Shared shared = new Shared();
    Composing[] composing = { new Composing(shared),
      new Composing(shared), new Composing(shared),
      new Composing(shared), new Composing(shared) };
    for(Composing c : composing)
      c.dispose();

    new Composing(new Shared());

    System.gc();
    System.runFinalization();
  }
} /* Output:
Creating Shared 0
Creating Composing 0
Creating Composing 1
Creating Composing 2
Creating Composing 3
Creating Composing 4
disposing Composing 0
disposing Composing 1
disposing Composing 2
disposing Composing 3
disposing Composing 4
Disposing Shared 0
*///:~
