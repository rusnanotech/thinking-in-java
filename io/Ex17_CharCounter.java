/****************** Exercise 17 *****************
 * Using TextFile and a Map<Character,Integer>,
 * create a program that counts the occurrence of
 * all the different characters in a file. (So if
 * there are 12 occurrences of the letter 'a' in
 * the file, the Integer associated with the Character
 * containing 'a' in the Map contains '12').
 ***********************************************/
package biz.markov.thinking.io;

import net.mindview.util.PPrint;
import net.mindview.util.TextFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex17_CharCounter {
    public static void main(String[] args) {
        String text = TextFile.read(args[0]);
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();

        for (int i = 0; i < text.length(); i++) {
            Character ch = text.charAt(i);
            Integer count = charMap.get(ch);

            charMap.put(
                    ch,
                    count == null
                            ? 1
                            : count + 1
            );
        }

        List<Map.Entry<Character, Integer>> chars
                = new ArrayList<Map.Entry<Character, Integer>>(charMap.entrySet());

        Collections.sort(
                chars,
                new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> e1,
                                       Map.Entry<Character, Integer> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        PPrint.pprint(chars);
    }
}
