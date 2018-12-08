/****************** Exercise 11 *****************
 * Add Gerbil to the typeinfo.pets library and
 * modify all the examples in this chapter to adapt
 * to this new class.
 ***********************************************/
package biz.markov.thinking.typeinfo.ex11;

import net.mindview.thinking.typeinfo.pets.Mouse;

public class Gerbil extends Mouse {
  public Gerbil(String name) { super(name); }
  public Gerbil() { super(); }
}