/****************** Exercise 25 ******************
 * Inherit from GreenhouseControls in
 * GreenhouseControls.java to add Event inner
 * classes that turn water mist generators on
 * and off. Write a new version of
 * GreenhouseController.java to use these new
 * Event objects.
 ***********************************************/
package biz.markov.thinking.innerclasses.controller;

public class Ex25_GreenhouseControls extends Ex24_GreenhouseControls {
    private boolean mist = false;
    public class MistOn extends Event {
        public MistOn(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here to
            // physically turn on the water mist generator.
            mist = true;
        }
        public String toString() { return "Mist is on"; }
    }
    public class MistOff extends Event {
        public MistOff(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here to
            // physically turn off the water mist generator.
            mist = false;
        }
        public String toString() { return "Mist is off"; }
    }
}
