//: polymorphism/music3/EEx07_Music3.java
// An extensible program.
package biz.markov.thinking.polymorphism;

import biz.markov.thinking.polymorphism.music.Note;

import static net.mindview.util.Print.print;

class Ex07_Instrument {
  void play(Note n) { print("Instrument.play() " + n); }
  public String toString() { return "Instrument"; }
  void adjust() { print("Adjusting Instrument"); }
}

class Ex07_Wind extends Ex07_Instrument {
  void play(Note n) { print("Wind.play() " + n); }
  public String toString() { return "Wind"; }
  void adjust() { print("Adjusting Wind"); }
}

class Ex07_Percussion extends Ex07_Instrument {
  void play(Note n) { print("Percussion.play() " + n); }
  public String toString() { return "Percussion"; }
  void adjust() { print("Adjusting Percussion"); }
}

class Ex07_Bell extends  Ex07_Percussion {
  void play(Note n) { print("Bell.play() " + n); }
  public String toString() { return "Bell"; }
  void adjust() { print("Adjusting Bell"); }
}

class Ex07_Stringed extends Ex07_Instrument {
  void play(Note n) { print("Stringed.play() " + n); }
  public String toString() { return "Stringed"; }
  void adjust() { print("Adjusting Stringed"); }
}

class Ex07_Brass extends Ex07_Wind {
  void play(Note n) { print("Brass.play() " + n); }
  void adjust() { print("Adjusting Brass"); }
}

class Ex07_Woodwind extends Ex07_Wind {
  void play(Note n) { print("Woodwind.play() " + n); }
  public String toString() { return "Woodwind"; }
}

public class Ex07_MusicBell {
  // Doesn't care about type, so new types
  // added to the system still work right:
  public static void tune(Ex07_Instrument i) {
    // ...
    i.play(Note.MIDDLE_C);
  }
  public static void tuneAll(Ex07_Instrument[] e) {
    for(Ex07_Instrument i : e) {
      System.out.println(i);
      tune(i);
    }
  }	
  public static void main(String[] args) {
    // Upcasting during addition to the array:
    Ex07_Instrument[] orchestra = {
      new Ex07_Wind(),
      new Ex07_Percussion(),
      new Ex07_Stringed(),
      new Ex07_Brass(),
      new Ex07_Woodwind(),
      new Ex07_Bell()
    };
    tuneAll(orchestra);
  }
}
