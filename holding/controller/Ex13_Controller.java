/****************** Exercise 13 *****************
 * In the innerclasses/GreenhouseController.java
 * example, the class Controller uses an ArrayList.
 * Change the code to use a LinkedList instead, and
 * use an Iterator to cycle through the set of events.
 ***********************************************/
//: innerclasses/controller/Ex13_Controller.java
// The reusable framework for control systems.
package biz.markov.thinking.holding.controller;

import java.util.*;

public class Ex13_Controller {
  // A class from java.util to hold Event objects:
  private List<Event> eventList = new LinkedList<Event>();
  public void addEvent(Event c) { eventList.add(c); }
  public void run() {
    while(eventList.size() > 0) {
      Iterator<Event> itr = new LinkedList<Event>(eventList).iterator();
      while (itr.hasNext()) {
        Event e = itr.next();
        if (e.ready()) {
          System.out.println(e);
          e.action();
          //itr.remove();
          eventList.remove(e);
        }
      }
    }
  }
} ///:~
