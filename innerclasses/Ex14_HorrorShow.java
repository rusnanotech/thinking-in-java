/****************** Exercise 14 ******************
 * Modify interfaces/HorrorShow.java to implement
 * DangerousMonster and Vampire using anonymous
 * classes.
 ************************************************/
package biz.markov.thinking.innerclasses;

interface Monster {
  void menace();
}

interface DangerousMonster extends Monster {
  void destroy();
}

interface Lethal {
  void kill();
}

interface Vampire extends DangerousMonster, Lethal {
  void drinkBlood();
}

public class Ex14_HorrorShow {
  static void u(Monster b) { b.menace(); }
  static void v(DangerousMonster d) {
    d.menace();
    d.destroy();
  }
  static void w(Lethal l) { l.kill(); }
  public static void main(String[] args) {
    DangerousMonster dm = new DangerousMonster() {
      public void destroy() {
        System.out.println("Dangerous monster is destroying");
      }

      public void menace() {
        System.out.println("Dangerous monster is Menacing");
      }
    };

    Vampire vamp = new Vampire() {
      public void drinkBlood() {
        System.out.println("Vampire is drinking blood");
      }

      public void destroy() {
        System.out.println("Vampire is destroying");
      }

      public void kill() {
        System.out.println("Vampire is killing");
      }

      public void menace() {
        System.out.println("Vampire is menacing");
      }
    };

    v(dm);
    v(vamp);
    w(vamp);
  }
}
