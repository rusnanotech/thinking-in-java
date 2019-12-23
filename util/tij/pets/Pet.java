//: typeinfo/pets/Pet.java
package biz.markov.thinking.util.tij.pets;

public class Pet extends Individual {
  public Pet(String name) { super(name); }
  public Pet() { super(); }
  public void speak() {
    System.out.println(toString() + " speaking");
  }
} ///:~
