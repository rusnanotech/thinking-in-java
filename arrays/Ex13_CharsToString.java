/****************** Exercise 13 *****************
 * Fill a String using CountingGenerator.Character.
 ************************************************/
package biz.markov.thinking.arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

public class Ex13_CharsToString {
   public static void main(String[] args) {
      char[] chars = ConvertTo.primitive(
         Generated.array(
            Character.class, new CountingGenerator.Character(), 9));
      
      String str = new String(chars);
   
      System.out.println(str);
   }
}
