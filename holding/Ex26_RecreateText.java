/****************** Exercise 26 *****************
 * Take the resulting Map from the previous
 * exercise and recreate the order of the words as
 * they appeared in the original file.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;
import java.util.Map.Entry;
import net.mindview.util.TextFile;

public class Ex26_RecreateText {
   public static void main(String[] args) {
      Map<String, ArrayList<Integer>> map =
         Ex25_WordLocations.analyse(new TextFile(args[0], "\\W+"));
   
      int numWords = 0;
      for (List l : map.values())
         numWords += l.size();
      
      String[] text = new String[numWords];
      for (Entry<String, ArrayList<Integer>> e : map.entrySet())
         for (int i : e.getValue())
            text[i] = e.getKey();
   
      for (String word : text)
         System.out.print(word + " ");
   }
}
