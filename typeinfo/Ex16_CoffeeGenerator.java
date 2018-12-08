/****************** Exercise 16 *****************
 * Modify the Coffee hierarchy in the Generics
 * chapter to use Registered Factories.
 ***********************************************/
package biz.markov.thinking.typeinfo;

import java.util.*;
import net.mindview.thinking.generics.coffee.*;
import net.mindview.util.Generator;
import net.mindview.thinking.typeinfo.factory.Factory;

class LatteFactory implements Factory<Latte> {
  public Latte create() { return new Latte(); }
}

class CoffeeFactory implements Factory<Coffee> {
   public Coffee create() { return new Coffee(); }
}

class MochaFactory implements Factory<Mocha> {
   public Mocha create() { return new Mocha(); }
}

class CappuccinoFactory implements Factory<Cappuccino> {
   public Cappuccino create() { return new Cappuccino(); }
}

class BreveFactory implements Factory<Breve> {
   public Breve create() { return new Breve(); }
}

class AmericanoFactory implements Factory<Americano>  {
   public Americano create() { return new Americano(); }
}


public class Ex16_CoffeeGenerator
implements Generator<Coffee>, Iterable<Coffee> {
  private Factory[] factories = { new LatteFactory(), new MochaFactory(),
    new CappuccinoFactory(), new AmericanoFactory(), new BreveFactory(), };
  private static Random rand = new Random(47);
  public Ex16_CoffeeGenerator() {}
  // For iteration:
  private int size = 0;
  public Ex16_CoffeeGenerator(int sz) { size = sz; }
  public Coffee next() {
    try {
      return (Coffee)
        factories[rand.nextInt(factories.length)].create();
      // Report programmer errors at run time:
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
  class CoffeeIterator implements Iterator<Coffee> {
    int count = size;
    public boolean hasNext() { return count > 0; }
    public Coffee next() {
      count--;
      return Ex16_CoffeeGenerator.this.next();
    }
    public void remove() { // Not implemented
      throw new UnsupportedOperationException();
    }
  };	
  public Iterator<Coffee> iterator() {
    return new CoffeeIterator();
  }
  public static void main(String[] args) {
    Ex16_CoffeeGenerator gen = new Ex16_CoffeeGenerator();
    for(int i = 0; i < 5; i++)
      System.out.println(gen.next());
    for(Coffee c : new Ex16_CoffeeGenerator(5))
      System.out.println(c);
  }
} /* Output:
Americano 0
Latte 1
Americano 2
Mocha 3
Mocha 4
Breve 5
Americano 6
Latte 7
Cappuccino 8
Cappuccino 9
*///:~
