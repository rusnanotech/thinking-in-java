/****************** Exercise 6 *****************
 * Use RandomList with two more types in addition
 * to the one shown in main().
 ************************************************/
package biz.markov.thinking.generics;
//: generics/RandomList.java

import net.mindview.thinking.typeinfo.pets.*;
import java.util.ArrayList;
import java.util.Random;

public class Ex06_RandomList<T> {
  private ArrayList<T> storage = new ArrayList<T>();
  private Random rand = new Random(47);
  public void add(T item) { storage.add(item); }
  public T select() {
    return storage.get(rand.nextInt(storage.size()));
  }
  public static void main(String[] args) {
    Ex06_RandomList<Integer> ri = new Ex06_RandomList<Integer>();
    for (int i = 0; i < 10; i++)
      ri.add(i);
    for(int i = 0; i < 10; i++)
      System.out.print(ri.select() + " ");
    System.out.println();
  
    Ex06_RandomList<Pet> rp = new Ex06_RandomList<Pet>();
    Pet[] pets = Pets.createArray(10);
    for (Pet pet : pets) {
      System.out.print(pet + " ");
      rp.add(pet);
    }
    System.out.println();
    for(int i = 0; i < 10; i++)
      System.out.print(rp.select() + " ");
  }
}
