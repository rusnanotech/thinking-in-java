/****************** Exercise 12 *****************
 * Substitute a HashMap, a TreeMap, and a LinkedHashMap
 * in AssociativeArray.java's main().
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static net.mindview.util.Print.print;

public class Ex12 {
    public static void test(Map<String, String> map) {
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object"); // Past the end
        } catch(ArrayIndexOutOfBoundsException e) {
            print("Too many objects!");
        }
        print(map);
        print(map.get("ocean"));
    }

    public static void main(String[] args) {
        test(new HashMap<String, String>());
        test(new LinkedHashMap<String, String>());
        test(new TreeMap<String, String>());
    }
}
