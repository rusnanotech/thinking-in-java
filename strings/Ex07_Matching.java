/****************** Exercise 7 ******************
 * Using the documentation for java.util.regex.Pattern
 * as a resource, write and test a regular expression
 * that checks a sentence to see that it begins with a
 * capital letter and ends with a period.
 ************************************************/
package biz.markov.thinking.strings;

import java.util.regex.*;

public class Ex07_Matching {
   public static void main(String[] args) {
      String s = "A regular expression, specified as a"
         + "string, must first be compiled into an instance of this class.";
      
      Pattern p = Pattern.compile("^[A-Z].+[.]$");
      Matcher m = p.matcher(s);
      System.out.println(m.matches());
   }
}
