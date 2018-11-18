/****************** Exercise 9 ******************
 * Using the documentation for java.util.regex.Pattern
 * as a resource, replace all the vowels in
 * Splitting.knights with underscores.
 ************************************************/
package biz.markov.thinking.strings;

public class Ex09_Replacing {
   public static void main(String[] args) {
      String s = Ex08_Splitting.knights;
      System.out.println(s.replaceAll("(?i)[aeiou]", "_"));
   }
}