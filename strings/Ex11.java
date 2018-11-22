/************************** Exercise 11 ******************
 *Apply the regular expression
 * (?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b
 * to
 * "Arline ate eight apples and one orange while Anita
 * hadn't any"
 *********************************************************/
package biz.markov.thinking.strings;

public class Ex11 {
   public static void main(String[] args) {
      String p = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
      String s = "Arline ate eight apples and one orange while Anita hadn’t any";
      
      new Ex10_Test(p, s).printTest();
   }
}