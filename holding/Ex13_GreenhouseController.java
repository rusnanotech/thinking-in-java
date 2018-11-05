/****************** Exercise 13 *****************
 * In the innerclasses/GreenhouseController.java
 * example, the class Controller uses an ArrayList.
 * Change the code to use a LinkedList instead, and
 * use an Iterator to cycle through the set of events.
 *
 * Uses modified version of the original class Event
 * from TIJ4 by increasing delay time for greater clarity.
 ****************************************************/
//: innerclasses/Ex13_GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
package biz.markov.thinking.holding;

import biz.markov.thinking.holding.controller.Event;
import biz.markov.thinking.holding.controller.Ex13_GreenhouseControls;

public class Ex13_GreenhouseController {
  public static void main(String[] args) {
    Ex13_GreenhouseControls gc = new Ex13_GreenhouseControls();
    // Instead of hard-wiring, you could parse
    // configuration information from a text file here:
    gc.addEvent(gc.new Bell(900));
    Event[] eventList = {
      gc.new ThermostatNight(0),
      gc.new LightOn(200),
      gc.new LightOff(400),
      gc.new WaterOn(600),
      gc.new WaterOff(800),
      gc.new ThermostatDay(1400)
    };
    gc.addEvent(gc.new Restart(2000, eventList));
    if(args.length == 1)
      gc.addEvent(
        new Ex13_GreenhouseControls.Terminate(
          new Integer(args[0])));
    gc.run();
  }
} /* Output:
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Greenhouse water is off
Bing!
Thermostat on day setting
Bing!
Restarting system
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Bing!
Greenhouse water is off
Thermostat on day setting
Bing!
Restarting system
Thermostat on night setting
Light is on
Light is off
Bing!
Greenhouse water is on
Greenhouse water is off
Terminating
*///:~
