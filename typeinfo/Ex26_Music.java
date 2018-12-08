/****************** Exercise 26 *****************
 * Implement clearSpitValve() as described in the
 * summary.
 ************************************************/
package biz.markov.thinking.typeinfo;

import static net.mindview.util.Print.*;

enum Note {
   MIDDLE_C, C_SHARP, B_FLAT; // Etc.
}

class Instrument {
   void play(Note n) { print("Instrument.play() " + n); }
   String what() { return "Instrument"; }
   void adjust() { print("Adjusting Instrument"); }
}

class Wind extends Instrument {
   void play(Note n) { print("Wind.play() " + n); }
   String what() { return "Wind"; }
   void adjust() { print("Adjusting Wind"); }
   void clearSpitValve() {
      System.out.println("Clearing spit valve of wind");
   }
}

class Percussion extends Instrument {
   void play(Note n) { print("Percussion.play() " + n); }
   String what() { return "Percussion"; }
   void adjust() { print("Adjusting Percussion"); }
}

class Stringed extends Instrument {
   void play(Note n) { print("Stringed.play() " + n); }
   String what() { return "Stringed"; }
   void adjust() { print("Adjusting Stringed"); }
}

class Brass extends Wind {
   void play(Note n) { print("Brass.play() " + n); }
   void adjust() { print("Adjusting Brass"); }
   void clearSpitValve() {
      System.out.println("Clearing spit valve of brass");
   }
}

class Woodwind extends Wind {
   void play(Note n) { print("Woodwind.play() " + n); }
   String what() { return "Woodwind"; }
   void clearSpitValve() {
      System.out.println("Clearing spit valve of Woodwind");
   }
}

public class Ex26_Music {
   // Doesn't care about type, so new types
   // added to the system still work right:
   public static void tune(Instrument i) {
      // ...
      if (i instanceof Wind) {
         ((Wind) i).clearSpitValve();
      }
      
      i.play(Note.MIDDLE_C);
   }
   public static void tuneAll(Instrument[] e) {
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
   }
} /* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
*///:~
