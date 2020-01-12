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
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.Restart;
import biz.markov.thinking.innerclasses.controller.Ex24_GreenhouseControls.Terminate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ex11_GreenhouseController2 {
    static Event getEvent(Ex24_GreenhouseControls gc, String eventName, long delayTime) throws Exception {
        return (Event) Class
                .forName(Ex24_GreenhouseControls.class.getName() + "$" + eventName)
                .getConstructor(gc.getClass(), long.class)
                .newInstance(gc, delayTime);
    }

    static Ex24_GreenhouseControls getGreenhouse(File config) throws Exception {
        Ex24_GreenhouseControls gc = new Ex24_GreenhouseControls();
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

            Event event = getEvent(gc, eventName, delayTime);

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
            System.out.println("Usage: java Ex11_GreenhouseController <config file>");
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