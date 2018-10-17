//: polymorphism/music3/EEx06_Music3.java
// An extensible program.
package biz.markov.thinking.polymorphism;
import biz.markov.thinking.polymorphism.music.Note;
import static net.mindview.util.Print.*;

class Ex06_Instrument {
  void play(Note n) { print("Instrument.play() " + n); }
  public String toString() { return "Instrument"; }
  void adjust() { print("Adjusting Instrument"); }
}

class Ex06_Wind extends Ex06_Instrument {
  void play(Note n) { print("Wind.play() " + n); }
  public String toString() { return "Wind"; }
  void adjust() { print("Adjusting Wind"); }
}	

class Ex06_Percussion extends Ex06_Instrument {
  void play(Note n) { print("Percussion.play() " + n); }
  public String toString() { return "Percussion"; }
  void adjust() { print("Adjusting Percussion"); }
}

class Ex06_Stringed extends Ex06_Instrument {
  void play(Note n) { print("Stringed.play() " + n); }
  public String toString() { return "Stringed"; }
  void adjust() { print("Adjusting Stringed"); }
}

class Ex06_Brass extends Ex06_Wind {
  void play(Note n) { print("Brass.play() " + n); }
  void adjust() { print("Adjusting Brass"); }
}

class Ex06_Woodwind extends Ex06_Wind {
  void play(Note n) { print("Woodwind.play() " + n); }
  public String toString() { return "Woodwind"; }
}	

public class Ex06_Music3 {
  // Doesn't care about type, so new types
  // added to the system still work right:
  public static void tune(Ex06_Instrument i) {
    // ...
    i.play(Note.MIDDLE_C);
  }
  public static void tuneAll(Ex06_Instrument[] e) {
    for(Ex06_Instrument i : e) {
      System.out.println(i);
      tune(i);
    }
  }	
  public static void main(String[] args) {
    // Upcasting during addition to the array:
    Ex06_Instrument[] orchestra = {
      new Ex06_Wind(),
      new Ex06_Percussion(),
      new Ex06_Stringed(),
      new Ex06_Brass(),
      new Ex06_Woodwind()
    };
    tuneAll(orchestra);
  }
}
