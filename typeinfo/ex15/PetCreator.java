/****************** Exercise 15 *****************
 * Implement a new PetCreator using Registered
 * Factories, and modify the Pets Façade so that
 * it uses this one instead of the other two.
 * Ensure that the rest of the examples that use
 * Pets.java still work correctly.
 ***********************************************/
//: typeinfo/pets/PetCreator.java
// Creates random sequences of Pets.
package biz.markov.thinking.typeinfo.ex15;

import java.util.*;
import net.mindview.thinking.typeinfo.pets.*;
import biz.markov.thinking.typeinfo.ex11.Gerbil;
import net.mindview.thinking.typeinfo.factory.Factory;

class CatFactory implements Factory<Cat> {
   public Cat create() { return new Cat(); }
}

class CymricFactory implements Factory<Cymric> {
   public Cymric create() { return new Cymric(); }
}

class DogFactory implements Factory<Dog> {
   public Dog create() { return new Dog(); }
}

class EgyptianMauFactory implements Factory<EgyptianMau> {
   public EgyptianMau create() { return new EgyptianMau(); }
}

class HamsterFactory implements Factory<Hamster> {
   public Hamster create() { return new Hamster(); }
}

class ManxFactory implements Factory<Manx> {
   public Manx create() { return new Manx(); }
}

class MouseFactory implements Factory<Mouse> {
   public Mouse create() { return new Mouse(); }
}

class MuttFactory implements Factory<Mutt> {
   public Mutt create() { return new Mutt(); }
}

class PetFactory implements Factory<Pet> {
   public Pet create() { return new Pet(); }
}

class PetsFactory implements Factory<Pets> {
   public Pets create() { return new Pets(); }
}

class PugFactory implements Factory<Pug> {
   public Pug create() { return new Pug(); }
}

class RatFactory implements Factory<Rat> {
   public Rat create() { return new Rat(); }
}

class RodentFactory implements Factory<Rodent> {
   public Rodent create() { return new Rodent(); }
}

class GerbilFactory implements Factory<Gerbil> {
   public Gerbil create() { return new Gerbil(); }
}

public class PetCreator {
   private static final List<Factory<? extends Pet>> factories =
      new ArrayList<Factory<? extends Pet>>();
   private Random rand = new Random(47);
   static {
      factories.add(new CatFactory());
      factories.add(new CymricFactory());
      factories.add(new DogFactory());
      factories.add(new EgyptianMauFactory());
      factories.add(new HamsterFactory());
      factories.add(new ManxFactory());
      factories.add(new MouseFactory());
      factories.add(new MuttFactory());
      factories.add(new PetFactory());
      factories.add(new PugFactory());
      factories.add(new RatFactory());
      factories.add(new RodentFactory());
   }
   // The List of the different types of Pet to create:
   public List<Factory<? extends Pet>> types() {
      return factories;
   }
   
   public Pet randomPet() { // Create one random Pet
      int n = rand.nextInt(types().size());
      return types().get(n).create();
   }
   public Pet[] createArray(int size) {
      Pet[] result = new Pet[size];
      for(int i = 0; i < size; i++)
         result[i] = randomPet();
      return result;
   }
   public ArrayList<Pet> arrayList(int size) {
      ArrayList<Pet> result = new ArrayList<Pet>();
      Collections.addAll(result, createArray(size));
      return result;
   }
} ///:~
