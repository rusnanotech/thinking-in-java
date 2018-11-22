/*********************** Exercise 15 *********************
 * Modify JGrep.java to accept flags as arguments (e.g.,
 * Pattern.CASE_INSENSITIVE, Pattern.MULTILINE).
 *********************************************************/
package biz.markov.thinking.strings;

import java.util.regex.*;
import net.mindview.util.*;

public class Ex15_JGrep {
   public static void main(String[] args) throws Exception {
      if(args.length < 2) {
         System.out.println("Usage: java JGrep file regex pattern");
         System.exit(0);
      }
      
      int flag = 0;
      if (args[2].equals("UNIX_LINES"))
         flag = Pattern.UNIX_LINES;
      else if (args[2].equals("CASE_INSENSITIVE"))
         flag = Pattern.CASE_INSENSITIVE;
      else if (args[2].equals("COMMENTS"))
         flag = Pattern.COMMENTS;
      else if (args[2].equals("MULTILINE"))
         flag = Pattern.MULTILINE;
      else if (args[2].equals("LITERAL"))
         flag = Pattern.LITERAL;
      else if (args[2].equals("DOTALL"))
         flag = Pattern.DOTALL;
      else if (args[2].equals("UNICODE_CASE"))
         flag = Pattern.UNICODE_CASE;
      else if (args[2].equals("CANON_EQ"))
         flag = Pattern.CANON_EQ;
      
      Pattern p;
      if (flag > 0)
         p = Pattern.compile(args[1], flag);
      else
         p = Pattern.compile(args[1]);
         
      // Iterate through the lines of the input file:
      int index = 0;
      Matcher m = p.matcher("");
      for(String line : new TextFile(args[0])) {
         m.reset(line);
         while(m.find())
            System.out.println(index++ + ": " +
               m.group() + ": " + m.start());
      }
   }
}
