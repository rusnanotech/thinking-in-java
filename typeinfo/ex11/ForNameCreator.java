/****************** Exercise 11 *****************
 * Add Gerbil to the typeinfo.pets library and
 * modify all the examples in this chapter to adapt
 * to this new class.
 ***********************************************/
//: typeinfo/pets/ForNameCreator.java
package biz.markov.thinking.typeinfo.ex11;

import net.mindview.thinking.typeinfo.pets.Pet;
import net.mindview.thinking.typeinfo.pets.PetCreator;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
     new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
     "net.mindview.thinking.typeinfo.pets.Mutt",
     "net.mindview.thinking.typeinfo.pets.Pug",
     "net.mindview.thinking.typeinfo.pets.EgyptianMau",
     "net.mindview.thinking.typeinfo.pets.Manx",
     "net.mindview.thinking.typeinfo.pets.Cymric",
     "net.mindview.thinking.typeinfo.pets.Rat",
     "net.mindview.thinking.typeinfo.pets.Mouse",
     "net.mindview.thinking.typeinfo.pets.Hamster",
     "biz.markov.thinking.typeinfo.ex11.Gerbil",
  };
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
           (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
