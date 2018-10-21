/****************** Exercise 4 *****************
 * Add a method to the class Sequence.SequenceSelector
 * that produces the reference to the outer class
 * Sequence.
 ***********************************************/
package biz.markov.thinking.innerclasses.pkg;

//  Extended interface with new method declaration:
public interface Ex04_Selector extends Selector {
  Ex04_Sequence getSequence();
}
