//: polymorphism/music3/EEx08_Music3.java
// An extensible program.
package biz.markov.thinking.polymorphism;

import biz.markov.thinking.polymorphism.music.Note;
import java.util.*;
import static net.mindview.util.Print.print;

class Ex08_Instrument {
  void play(Note n) { print("Instrument.play() " + n); }
  public String toString() { return "Instrument"; }
  void adjust() { print("Adjusting Instrument"); }
}

class Ex08_Wind extends Ex08_Instrument {
  void play(Note n) { print("Wind.play() " + n); }
  public String toString() { return "Wind"; }
  void adjust() { print("Adjusting Wind"); }
}

class Ex08_Percussion extends Ex08_Instrument {
  void play(Note n) { print("Percussion.play() " + n); }
  public String toString() { return "Percussion"; }
  void adjust() { print("Adjusting Percussion"); }
}

class Ex08_Bell extends  Ex08_Percussion {
  void play(Note n) { print("Bell.play() " + n); }
  public String toString() { return "Bell"; }
  void adjust() { print("Adjusting Bell"); }
}

class Ex08_Stringed extends Ex08_Instrument {
  void play(Note n) { print("Stringed.play() " + n); }
  public String toString() { return "Stringed"; }
  void adjust() { print("Adjusting Stringed"); }
}

class Ex08_Brass extends Ex08_Wind {
  void play(Note n) { print("Brass.play() " + n); }
  void adjust() { print("Adjusting Brass"); }
}

class Ex08_Woodwind extends Ex08_Wind {
  void play(Note n) { print("Woodwind.play() " + n); }
  public String toString() { return "Woodwind"; }
}

class Ex08_InstrumentGenerator {
  private Random rand = new Random(987);
  Ex08_Instrument next() {
    switch(rand.nextInt(6)) {
      default:
      case 0:
        return new Ex08_Wind();
      case 1:
        return new Ex08_Percussion();
      case 2:
        return new Ex08_Bell();
      case 3:
        return new Ex08_Brass();
      case 4:
        return new Ex08_Stringed();
      case 5:
        return new Ex08_Woodwind();
    }
  }
}

public class Ex08_MusicRandom {
  // Doesn't care about type, so new types
  // added to the system still work right:
  public static void tune(Ex08_Instrument i) {
    // ...
    i.play(Note.MIDDLE_C);
  }
  public static void tuneAll(Ex08_Instrument[] e) {
    for(Ex08_Instrument i : e) {
      tune(i);
    }
  }	
  public static void main(String[] args) {
    // Upcasting during addition to the array:
    Ex08_InstrumentGenerator gen = new Ex08_InstrumentGenerator();
    Ex08_Instrument[] orchestra = new Ex08_Instrument[10];

    for (int i = 0; i < orchestra.length; i++)
      orchestra[i] = gen.next();
    tuneAll(orchestra);
  }
}
