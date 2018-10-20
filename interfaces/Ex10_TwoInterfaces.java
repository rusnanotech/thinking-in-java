/****************** Exercise 10 ******************
 * Add a Playable to Modify Music5.java, and move
 * the play() declaration from Instrument to
 * Playable. Include Playable in the implements
 * list to add it to the derived classes.
 * Change tune() so it takes a Playable instead
 * of an Instrument.
 ***********************************************/
package biz.markov.thinking.interfaces;

import biz.markov.thinking.polymorphism.music.Note;
import static net.mindview.util.Print.*;

interface Ex10_Instrument {
    // Compile-time constant:
    int VALUE = 5; // static & final
    // Cannot have method definitions:
    void adjust();
}

interface Ex10_Playable {
    void play(Note n); // Automatically public
}

class Ex10_Wind implements Ex10_Instrument, Ex10_Playable {
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public String toString() { return "Ex10_Wind"; }
    public void adjust() { print(this + ".adjust()"); }
}

class Ex10_Percussion implements Ex10_Instrument, Ex10_Playable {
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public String toString() { return "Ex10_Percussion"; }
    public void adjust() { print(this + ".adjust()"); }
}

class Ex10_Stringed implements Ex10_Instrument, Ex10_Playable {
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public String toString() { return "Ex10_Stringed"; }
    public void adjust() { print(this + ".adjust()"); }
}

class Ex10_Brass extends Ex10_Wind {
    public String toString() { return "Ex10_Brass"; }
}

class Ex10_Woodwind extends Ex10_Wind {
    public String toString() { return "Ex10_Woodwind"; }
}

public class Ex10_TwoInterfaces {
    // Doesn't care about type, so new types
    // added to the system still work right:
    static void tune(Ex10_Instrument i) {
        // ...
        ((Ex10_Playable)i).play(Note.MIDDLE_C);
    }
    static void tuneAll(Ex10_Instrument[] e) {
        for(Ex10_Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Ex10_Instrument[] orchestra = {
                new Ex10_Wind(),
                new Ex10_Percussion(),
                new Ex10_Stringed(),
                new Ex10_Brass(),
                new Ex10_Woodwind()
        };
        tuneAll(orchestra);
    }
} /* Output:
Ex10_Wind.play() MIDDLE_C
Ex10_Percussion.play() MIDDLE_C
Ex10_Stringed.play() MIDDLE_C
Ex10_Brass.play() MIDDLE_C
Ex10_Woodwind.play() MIDDLE_C
*///:~
