/**
 * Modified framework for performing timed tests of containers
 * from Thinking in Java.
 */
package biz.markov.thinking.util.tij.test;//: containers/Test.java

public abstract class Test<C> {
  String name;

  public Test(String name) {
    this.name = name;
  }

  /**
   * Override this method for different tests.
   * Returns actual number of repetitions of test.
   */
  public abstract int test(C container, TestParam tp);

  /**
   * Override this method for different tests.
   * Returns container.
   */
  public C getContainer(int size) {
    return null;
  }

} ///:~
