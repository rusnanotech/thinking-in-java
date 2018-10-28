/****************** Exercise 24 *****************
 * Add Event inner classes that turn fans on and
 * off in GreenhouseControls.java. Configure
 * GreenhouseController.java to use these new
 * Event objects.
 *
 * Uses modified version of the original class Event
 * from TIJ4 by increasing delay time for greater clarity.
 ****************************************************/
//: innerclasses/GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
package biz.markov.thinking.innerclasses;

import biz.markov.thinking.innerclasses.controller.Event;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls;

public class Ex24_GreenhouseController {
  public static void main(String[] args) {
    Ex24_GreenhouseControls gc = new Ex24_GreenhouseControls();
    // Instead of hard-wiring, you could parse
    // configuration information from a text file here:
    gc.addEvent(gc.new Bell(900));
    Event[] eventList = {
      gc.new ThermostatNight(0),
      gc.new LightOn(200),
      gc.new LightOff(400),
      gc.new WaterOn(600),
      gc.new WaterOff(800),
      gc.new FanOn(1000),
      gc.new FanOff(1200),
      gc.new ThermostatDay(1400)
    };
    gc.addEvent(gc.new Restart(2000, eventList));
    if(args.length == 1)
      gc.addEvent(
        new Ex24_GreenhouseControls.Terminate(
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
Fan is on
Fan is off
Thermostat on day setting
Bing!
Restarting system
Thermostat on night setting
Light is on
Light is off
Greenhouse water is on
Bing!
Greenhouse water is off
Fan is on
Fan is off
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
