/****************** Exercise 6 *****************
 * If you don’t call the base-class constructor
 * in BoardGame(), the compiler will respond
 * that it can’t find a constructor of the form
 * Game(). The call to the base-class
 * constructor must be the first thing you do
 * in the derived-class constructor. (The compiler
 * will remind you if you get it wrong.)
 * Use Chess.java to prove those assertions.
 ***********************************************/
package biz.markov.thinking.reusing;
//: reusing/Ex06_ArgConstruct.java
// Inheritance, constructors and arguments.
import static net.mindview.util.Print.*;

class Game {
  Game(int i) {
    print("Game constructor");
  }
}

class BoardGame extends Game {
  BoardGame(int i) {
    super(i);
    print("BoardGame constructor");
  }
}	

class Chess extends BoardGame {
  Chess() {
    super(11);
    print("Chess constructor");
  }
  public static void main(String[] args) {
    Chess x = new Chess();
  }
}

public class Ex06_ArgConstruct {
  public static void main(String args[]) {
    Chess x = new Chess();
  }
}
/* Output:
Game constructor
BoardGame constructor
Chess constructor
*///:~
