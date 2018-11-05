/****************************************************
 * Modified version of the original example
 * from TIJ4 by replacing System.nanoTime()
 * to System.currentTimeMillis() increasing delay time.
 ****************************************************/
//: innerclasses/controller/Event.java
// The common methods for any control event.
package biz.markov.thinking.holding.controller;

public abstract class Event {
  private long eventTime;
  protected final long delayTime;
  public Event(long delayTime) {
    this.delayTime = delayTime;
    start();
  }
  public void start() { // Allows restarting
    eventTime = System.currentTimeMillis() + delayTime;
  }
  public boolean ready() {
    return System.currentTimeMillis() >= eventTime;
  }
  public abstract void action();
} ///:~
