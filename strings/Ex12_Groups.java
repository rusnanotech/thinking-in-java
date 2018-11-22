/************************** Exercise 12 ******************
 * Modify Groups.java to count all unique words
 * with no initial capital letter.
 *********************************************************/
package biz.markov.thinking.strings;

import java.util.*;
import java.util.regex.*;

public class Ex12_Groups {
   static public final String POEM =
         "Twas brillig, and the slithy toves\n" +
         "Did gyre and gimble in the wabe.\n" +
         "All mimsy were the borogoves,\n" +
         "And the mome raths outgrabe.\n\n" +
         "Beware the Jabberwock, my son,\n" +
         "The jaws that bite, the claws that catch.\n" +
         "Beware the Jubjub bird, and shun\n" +
         "The frumious Bandersnatch.";
   public static void main(String[] args) {
      Matcher m =
         Pattern.compile("\\b\\p{Lower}+\\b")
            .matcher(POEM);
      Set<String> set = new HashSet<String>();
      while(m.find()) {
         set.add(m.group());
      }
      System.out.println(set.size());
      System.out.println(set);
   }
}
