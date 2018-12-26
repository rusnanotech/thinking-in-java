/****************** Exercise 8 *****************
 * Following the form of the Coffee example, create
 * a hierarchy of StoryCharacters from your favorite
 * movie, dividing them into GoodGuys and BadGuys.
 * Create a generator for StoryCharacters, following
 * the form of CoffeeGenerator.
 ************************************************/
package biz.markov.thinking.generics;

import java.util.*;

import net.mindview.util.*;

class StoryCharacter {
   private static long counter;
   private final long id = counter++;
   
   public String toString() {
      return getClass().getSimpleName() + " " + id;
   }
}

class GoodGuy extends StoryCharacter {
}

class BadGuy extends StoryCharacter {
}

class GoodGuyA extends GoodGuy {
}

class GoodGuyB extends GoodGuy {
}

class GoodGuyC extends GoodGuy {
}

class GoodGuyD extends GoodGuy {
}

class BadGuyA extends BadGuy {
}

class BadGuyB extends BadGuy {
}

class BadGuyC extends BadGuy {
}

public class Ex08_CharacterGenerator
   implements Generator<StoryCharacter>, Iterable<StoryCharacter> {
   private Class[] types;
   private static final Class[] goodGuys = {GoodGuyA.class, GoodGuyB.class,
      GoodGuyC.class, GoodGuyD.class};
   private static final Class[] badGuys = {BadGuyA.class, BadGuyB.class, BadGuyC.class};
   private static final Class[] allGuys;
   static {
      allGuys = new Class[goodGuys.length + badGuys.length];
      System.arraycopy(goodGuys, 0, allGuys, 0, goodGuys.length);
      System.arraycopy(badGuys, 0, allGuys, goodGuys.length, badGuys.length);
   }
   private static Random rand = new Random(47);
   
   public Ex08_CharacterGenerator() {
      types = allGuys;
   }
   
   // For iteration:
   private int size = 0;
   
   public Ex08_CharacterGenerator(int sz) {
      this();
      size = sz;
   }
   
   public void setGood() {
      types = goodGuys;
   }
   
   public void setBad() {
      types = badGuys;
   }
   
   public void setAny() {
      types = allGuys;
   }
   
   public StoryCharacter next() {
      try {
         return (StoryCharacter)
            types[rand.nextInt(types.length)].newInstance();
         // Report programmer errors at run time:
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
   
   class GuyIterator implements Iterator<StoryCharacter> {
      int count = size;
      
      public boolean hasNext() {
         return count > 0;
      }
      
      public StoryCharacter next() {
         count--;
         return Ex08_CharacterGenerator.this.next();
      }
      
      public void remove() { // Not implemented
         throw new UnsupportedOperationException();
      }
   }
   
   public Iterator<StoryCharacter> iterator() {
      return new GuyIterator();
   }
   
   public static void demo(Ex08_CharacterGenerator gen) {
      // Using next()
      for (int i = 0; i < 5; i++)
         System.out.println(gen.next());
      // Using iterator
      for (StoryCharacter c : gen)
         System.out.println(c);
      System.out.println();
   }
   
   public static void main(String[] args) {
      Ex08_CharacterGenerator gen = new Ex08_CharacterGenerator(5);
      demo(gen);
      
      gen.setBad();
      demo(gen);
      
      gen.setGood();
      demo(gen);
   }
}
