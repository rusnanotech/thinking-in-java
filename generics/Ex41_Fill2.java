package biz.markov.thinking.generics;//: generics/Ex41_Fill2.java
// Using adapters to simulate latent typing.
// {main: Ex41_Fill2Test}

import net.mindview.thinking.generics.SimpleQueue;
import net.mindview.util.Generator;
import net.mindview.thinking.typeinfo.pets.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static net.mindview.util.Print.print;

interface Addable<T> { void add(T t); }

public class Ex41_Fill2 {
  // Classtoken version:
  public static <T> void fill(Addable<T> addable,
                              Class<? extends T> classToken, int size) {
    for(int i = 0; i < size; i++)
      try {
        addable.add(classToken.newInstance());
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
  }
  // Generator version:
  public static <T> void fill(Addable<T> addable,
                              Generator<T> generator, int size) {
    for(int i = 0; i < size; i++)
      addable.add(generator.next());
  }
}

// To adapt a base type, you must use composition.
// Make any Collection Addable using composition:
class AddableCollectionAdapter<T> implements Addable<T> {
  private Collection<T> c;
  public AddableCollectionAdapter(Collection<T> c) {
    this.c = c;
  }
  public void add(T item) { c.add(item); }
}

// A Helper to capture the type automatically:
class Adapter {
  public static <T>
  Addable<T> collectionAdapter(Collection<T> c) {
    return new AddableCollectionAdapter<T>(c);
  }
}

// To adapt a specific type, you can use inheritance.
// Make a SimpleQueue Addable using inheritance:
class AddableSimpleQueue<T>
extends SimpleQueue<T> implements Addable<T> {
  public void add(T item) { super.add(item); }
}

class Ex41_Fill2Test {
  public static void main(String[] args) {
    // Adapt a Collection:
    List<Pet> carrier = new ArrayList<Pet>();
    Ex41_Fill2.fill(
      new AddableCollectionAdapter<Pet>(carrier),
      Pet.class, 3);
    // Helper method captures the type:
    Ex41_Fill2.fill(Adapter.collectionAdapter(carrier),
      Cymric.class, 2);
    for(Pet c: carrier)
      print(c);
    print("----------------------");
    // Use an adapted class:
    AddableSimpleQueue<Pet> coffeeQueue =
      new AddableSimpleQueue<Pet>();
    Ex41_Fill2.fill(coffeeQueue, Cat.class, 4);
    Ex41_Fill2.fill(coffeeQueue, Dog.class, 1);
    for(Pet c: coffeeQueue)
      print(c);
  }
}
