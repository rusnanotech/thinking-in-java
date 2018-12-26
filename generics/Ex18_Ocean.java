/****************** Exercise 18 *****************
 * Following the form of BankTeller.java, create an
 * example where BigFish eat LittleFish in the Ocean.
 ************************************************/
package biz.markov.thinking.generics;

import net.mindview.thinking.generics.Generators;
import net.mindview.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Fish {
   private static long count;
   private final long id = count++;
   
   public String toString() {
      return getClass().getSimpleName() + " " + id;
   }
}

class BigFish extends Fish {
   public static Generator<BigFish> generator() {
      return new Generator<BigFish>() {
         public BigFish next() {
            return new BigFish();
         }
      };
   }
}

class LittleFish extends Fish {
   public static Generator<LittleFish> generator() {
      return new Generator<LittleFish>() {
         public LittleFish next() {
            return new LittleFish();
         }
      };
   }
}

public class Ex18_Ocean {
   public static void eat(Fish fish1, Fish fish2) {
      System.out.println(fish1 + " eats " + fish2);
   }
   
   public static void main(String[] args) {
      Random rand = new Random(System.nanoTime());
      List<BigFish> bigFishes = new ArrayList<BigFish>();
      List<LittleFish> littleFishes = new ArrayList<LittleFish>();
      
      Generators.fill(bigFishes , BigFish.generator(), 4);
      Generators.fill(littleFishes, LittleFish.generator(), 16);
      
      for (LittleFish lf : littleFishes)
         eat(bigFishes.get(rand.nextInt(bigFishes.size())), lf);
   }
}
