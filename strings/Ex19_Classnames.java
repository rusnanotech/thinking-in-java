/********************** Exercise 19 *********************
 * Build on Exercises 17 and 18 to write a program
 * that examines Java source code and produces all
 * class names used in a particular program.
 ********************************************************/
package biz.markov.thinking.strings;

import java.util.regex.Pattern;

class Ex19_Class {}

abstract class Ex19_Abstract {}

public final class Ex19_Classnames {
   public static void main(String[] args) {
      Ex16_JGrep jg = new Ex16_JGrep(
         "^(\\w+\\s+)*class\\s+(\\w+)",
         Pattern.MULTILINE);
      jg.setGroup(2);
      jg.process("src/biz/markov/thinking/strings");
   }
}