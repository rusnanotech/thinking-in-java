/****************** Exercise 9 ******************
 * Refactor Music5.java by moving the common
 * methods in Wind, Percussion and Stringed into
 * an abstract class.
 ***********************************************/
package biz.markov.thinking.interfaces;

import biz.markov.thinking.polymorphism.music.Note;
import static net.mindview.util.Print.*;

interface Instrument {
    // Compile-time constant:
    int VALUE = 5; // static & final
    // Cannot have method definitions:
    void play(Note n); // Automatically public
    void adjust();
}

abstract class AbstractInstrument implements Instrument {
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public void adjust() { print(this + ".adjust()"); }
}

class Wind extends AbstractInstrument {
    int i = 12;
    public String toString() { return "Wind"; }
}

class Percussion extends AbstractInstrument {
    public String toString() { return "Percussion"; }
}

class Stringed extends AbstractInstrument {
    public String toString() { return "Stringed"; }
}

class Brass extends Wind {
    public String toString() { return "Brass"; }
}

class Woodwind extends Wind {
    public String toString() { return "Woodwind"; }
}


public class Ex09_IterfToAbstr {
    // Doesn't care about type, so new types
    // added to the system still work right:
    static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrument[] e) {
        for(Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
        print(orchestra[0].VALUE);
        //! print(orchestra[0].i);
        //! print(orchestra[4].i);
    }
} /* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
5
*///:~
