/************************** Exercise 13 ******************
 * Modify StartEnd.java so that it uses Groups.POEM as
 * input, but still produces positive outputs for find(),
 * lookingAt() and matches().
 *********************************************************/
package biz.markov.thinking.strings;

import biz.markov.thinking.util.tij.StartEnd;

public class Ex13_StartEnd {
   public static void main(String[] args) {
      for (String in : Ex12_Groups.POEM.split("\n")) {
         System.out.println("input : " + in);
         for (String regex : new String[]{"\\w*ere\\w*",
            "\\w+,", "T\\w+", "The.*\\."})
            StartEnd.examine(in, regex);
      }
   }
}
