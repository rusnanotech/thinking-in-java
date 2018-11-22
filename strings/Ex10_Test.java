/********************** Exercise 10 **********************
 * For the phrase "Java now has regular expressions"
 * evaluate whether the following expressions will find a
 * match:
 *
 * ^Java
 * \Breg.*
 * n.w\s+h(a|i)s
 * s?
 * s*
 * s+
 * s{4}
 * s{1}.
 * s{0,3}
 ********************************************************/
package biz.markov.thinking.strings;

import java.util.regex.*;
import static net.mindview.util.Print.*;
import net.mindview.thinking.strings.TestRegularExpression;

public class Ex10_Test {
   private String[] patterns;
   private String s;
   
   public Ex10_Test(String pattern, String s) {
      this.patterns = new String[] { pattern };
      this.s = s;
   }
   
   public Ex10_Test(String[] patterns, String s) {
      this.patterns = patterns;
      this.s = s;
   }
   
   public void printTest() {
      print("Input: \"" + s + "\"");
      for (String arg : patterns) {
         print("\nRegular expression: \"" + arg + "\"");
         Pattern p = Pattern.compile(arg);
         Matcher m = p.matcher(s);
         while (m.find()) {
            print("Match \"" + m.group() + "\" at positions " +
               m.start() + "-" + (m.end() - 1));
         }
      }
   }
   
   public static void main(String[] args) {
      String s = "Java now has regular expressions";
      String[] p = {
         "^Java",
         "\\Breg.*",
         "n.w\\s+h(a|i)s",
         "s?",
         "s*",
         "s+",
         "s{4}",
         "s{1}.",
         "s{0,3}",
      };
      new Ex10_Test(p, s).printTest();
   }
}
