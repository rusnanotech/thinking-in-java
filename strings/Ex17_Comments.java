package biz.markov.thinking.strings;

import java.util.regex.*;

public class Ex17_Comments {
   private String testString = "\"" + ""; // Comment 1
   // Comment 2
   public static void main(String[] args) {
      Ex16_JGrep jg = new Ex16_JGrep(
         "src/biz/markov/thinking/strings/",
         "^[^\\x22]*(\\x22([^\\x22]|(\\\\\\x22))*\\x22.*)*[^\\x22]*//(.+)",
         Pattern.MULTILINE);
   
      jg.setGroup(4);
      jg.find();
   }
}
