/****************** Exercise 11 *****************
 * Add Gerbil to the typeinfo.pets library and
 * modify all the examples in this chapter to adapt
 * to this new class.
 ***********************************************/
//: typeinfo/pets/Pets.java
// Facade to produce a default PetCreator.
package biz.markov.thinking.typeinfo.ex11;

import net.mindview.thinking.typeinfo.pets.Pet;
import net.mindview.thinking.typeinfo.pets.PetCreator;

import java.util.ArrayList;

public class Pets {
  public static final PetCreator creator =
    new LiteralPetCreator();
  public static Pet randomPet() {
    return creator.randomPet();
  }
  public static Pet[] createArray(int size) {
    return creator.createArray(size);
  }
  public static ArrayList<Pet> arrayList(int size) {
    return creator.arrayList(size);
  }
}
