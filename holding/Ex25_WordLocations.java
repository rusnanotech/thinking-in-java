/****************** Exercise 25 *****************
 * Create a Map<String,ArrayList<Integer>>. Use
 * net.mindview.TextFile to open a text file and
 * read it in a word at a time (use "\\W+" as the
 * second argument to the TextFile constructor).
 * Count the words as you read them in, and for each
 * word in the file, record in the ArrayList<Integer>
 * the word count associated with that word - this is,
 * in effect, the location in the file where that
 * word was found.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;
import java.util.Map.Entry;
import net.mindview.util.TextFile;

public class Ex25_WordLocations {
   public static final Comparator<Entry<String, ArrayList<Integer>>> CASE_INSENSITIVE_ORDER =
      new Comparator<Entry<String, ArrayList<Integer>>>() {
         public int compare(Entry<String, ArrayList<Integer>> e1,
                            Entry<String, ArrayList<Integer>> e2) {
            return e1.getKey().compareToIgnoreCase(e2.getKey());
         }
      };
   
   public static Map<String, ArrayList<Integer>> analyse(List<String> words) {
      Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
   
      ListIterator<String> itr = words.listIterator();
      while (itr.hasNext()) {
         String word = itr.next();
      
         if (map.containsKey(word))
            map.get(word).add(itr.previousIndex());
         else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(itr.previousIndex());
            map.put(word, list);
         }
      }
      
      return map;
   }
   
   public static void main(String[] args) {
      Map<String, ArrayList<Integer>> map =
         analyse(new TextFile(args[0], "\\W+"));
   
      List<Entry<String, ArrayList<Integer>>> l =
         new ArrayList<Entry<String, ArrayList<Integer>>>(map.entrySet());
      Collections.sort(l, CASE_INSENSITIVE_ORDER);
   
      for (Entry<String, ArrayList<Integer>> e : l)
         System.out.println(e);
   }
}
