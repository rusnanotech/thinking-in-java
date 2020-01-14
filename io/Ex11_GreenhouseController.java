/****************** Exercise 11 ***************************
 * (Intermediate) In the
 * innerclasses/GreenhouseController.java example,
 * GreenhouseController contains a hard-coded set of events.
 * Change the program so that it reads the events and their
 * relative times from a text file. (Challenging: Use a
 * Factory Method design pattern to build the events—see
 * Thinking in Patterns (with Java) at www.MindView.net.)
 *********************************************************/
package biz.markov.thinking.io;

import biz.markov.thinking.innerclasses.controller.Event;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.Bell;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.FanOff;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.FanOn;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.LightOff;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.LightOn;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.Restart;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.Terminate;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.ThermostatDay;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.ThermostatNight;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.WaterOff;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.WaterOn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex11_GreenhouseController {
    public interface EventFactory {
        Event getEvent(long delayTime);
    }

    static Map<String, EventFactory> getEventFactories(final Ex24_GreenhouseControls gc) {
        final Map<String, EventFactory> eventFactories = new HashMap<String, EventFactory>();
        eventFactories.put(
                Bell.class.getSimpleName(),
                new EventFactory() {
                    public Event getEvent(long delayTime) {
                        return gc.new Bell(delayTime);
                    }
                }
        );
        eventFactories.put(
                ThermostatNight.class.getSimpleName(),
                new EventFactory() {
                    public Event getEvent(long delayTime) {
                        return gc.new ThermostatNight(delayTime);
                    }
                }
        );
        eventFactories.put(
                LightOn.class.getSimpleName(),
                new EventFactory() {
                    public Event getEvent(long delayTime) {
                        return gc.new LightOn(delayTime);
                    }
                }
        );
        eventFactories.put(
                LightOff.class.getSimpleName(),
                new EventFactory() {
                    public Event getEvent(long delayTime) {
                        return gc.new LightOff(delayTime);
                    }
                }
        );
        eventFactories.put(
                WaterOn.class.getSimpleName(),
                new EventFactory() {
                    public Event getEvent(long delayTime) {
                        return gc.new WaterOn(delayTime);
                    }
                }
        );
        eventFactories.put(
                WaterOff.class.getSimpleName(),
                new EventFactory() {
                    public Event getEvent(long delayTime) {
                        return gc.new WaterOff(delayTime);
                    }
                }
        );
        eventFactories.put(
                FanOn.class.getSimpleName(),
                new EventFactory() {
                    public Event getEvent(long delayTime) {
                        return gc.new FanOn(delayTime);
                    }
                }
        );
        eventFactories.put(
                FanOff.class.getSimpleName(),
                new EventFactory() {
                    public Event getEvent(long delayTime) {
                        return gc.new FanOff(delayTime);
                    }
                }
        );
        eventFactories.put(
                ThermostatDay.class.getSimpleName(),
                new EventFactory() {
                    public Event getEvent(long delayTime) {
                        return gc.new ThermostatDay(delayTime);
                    }
                }
        );

        return eventFactories;
    }

    static Ex24_GreenhouseControls getGreenhouse(File config) throws IOException, NumberFormatException {
        Ex24_GreenhouseControls gc = new Ex24_GreenhouseControls();
        Map<String, EventFactory> eventFactories = getEventFactories(gc);
        List<Event> events = new ArrayList<Event>();

        boolean restartOn = false;
        long restartTime = 0L;

        BufferedReader reader = new BufferedReader(new FileReader(config));

        while (reader.ready()) {
            String[] parameter = reader.readLine().split("\\W");
            String eventName = parameter[0];
            long delayTime = Long.parseLong(parameter[1]);

            if (eventName.equalsIgnoreCase(Terminate.class.getSimpleName())) {
                gc.addEvent(new Terminate(delayTime));
                continue;
            }

            if (eventName.equalsIgnoreCase(Restart.class.getSimpleName())) {
                restartOn = true;
                restartTime = delayTime;
                continue;
            }

            EventFactory factory = eventFactories.get(eventName);
            Event event = factory.getEvent(delayTime);

            events.add(event);
        }

        reader.close();

        if (restartOn) {
            gc.addEvent(gc.new Restart(restartTime, events.toArray(new Event[0])));
        } else {
            for (Event event : events) {
                gc.addEvent(event);
            }
        }

        return gc;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:\njava " + Ex11_GreenhouseController.class.getSimpleName()
                    + " <config file>");
            return;
        }

        try {
            getGreenhouse(new File(args[0])).run();
        } catch (FileNotFoundException e) {
            System.out.println("Error opening config file " + args[0]);
        } catch (Exception e) {
            System.out.println("Error reading config file " + args[0]);
        }
    }
}