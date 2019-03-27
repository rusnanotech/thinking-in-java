/****************** Exercise 15 *****************
 * Repeat Exercise 13 using a SlowMap.
 ***********************************************/
package biz.markov.thinking.containers;

import biz.markov.thinking.containers.lib.mindview.SlowMap;
import net.mindview.util.TextFile;

import java.util.List;
import java.util.Map;

public class Ex15_WordCounter {
    public static Map<String, Integer> count(List<String> words) {
        Map<String, Integer> map = new SlowMap<String, Integer>();

        for (String key : words) {
            Integer counter = map.get(key);
            map.put(key, map.containsKey(key) ? counter + 1 : 1);
        }

        return map;
    }

    public static void main(String[] args) {
        List<String> words = new TextFile(args[0], "\\W+");
        System.out.println(Ex13_WordCounter.count(words));
        System.out.println(count(words));
    }
}
