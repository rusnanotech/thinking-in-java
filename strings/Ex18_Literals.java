/********************** Exercise 18 *********************
 * Write a program that reads a Java source-code file
 * and displays all the string literals in the code
 * (provide the file name on the command line).
 ********************************************************/
package biz.markov.thinking.strings;

import java.util.regex.Pattern;

public class Ex18_Literals {
   private String testString = "" + "\"\"" + "// This is not comment"; // This is "comment"
   private String testString2 =
"abc" + "def" + "";
   /*
      "Comment"
   */
   // This is another comment
   public static void main(String[] args) {
      Ex16_JGrep jg = new Ex16_JGrep(
         "\"(.*?[^\\\\])??\"",
         Pattern.MULTILINE);
      jg.process("src/biz/markov/thinking/strings");
   }
}