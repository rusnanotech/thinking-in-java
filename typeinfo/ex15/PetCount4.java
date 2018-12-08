/****************** Exercise 15 *****************
 * Implement a new PetCreator using Registered
 * Factories, and modify the Pets Façade so that
 * it uses this one instead of the other two.
 * Ensure that the rest of the examples that use
 * Pets.java still work correctly.
 ***********************************************/
package biz.markov.thinking.typeinfo.ex15;//: typeinfo/PetCount4.java

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
