/****************** Exercise 11 *****************
 * Add Gerbil to the typeinfo.pets library and
 * modify all the examples in this chapter to adapt
 * to this new class.
 ***********************************************/
package biz.markov.thinking.typeinfo.ex11;//: typeinfo/PetCount4.java

import net.mindview.thinking.typeinfo.pets.Pet;
import net.mindview.util.TypeCounter;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class PetCount4 {
  public static void main(String[] args) {
    TypeCounter counter = new TypeCounter(Pet.class);
    for(Pet pet : Pets.createArray(20)) {
      printnb(pet.getClass().getSimpleName() + " ");
      counter.count(pet);
    }
    print();
    print(counter);
  }
}
