/******************* Exercise 18 ************************
 * Fill a HashMap with key-value pairs. Print the results
 * to show ordering by hash code. Extract the pairs, sort
 * by key, and place the result into a LinkedHashMap.
 * Show that insertion order is maintained.
 *******************************************************/
package biz.markov.thinking.holding;

import java.util.*;
import java.util.Map.Entry;

public class Ex18_LinkedHashMap {
    static void showGerbils(Map<String, Ex01_Gerbil> gerbils) {
        Iterator<Entry<String, Ex01_Gerbil>> itr = gerbils.entrySet().iterator();
        while (itr.hasNext()) {
            Entry<String, Ex01_Gerbil> entry = itr.next();
            System.out.print(entry.getKey() + ": ");
            entry.getValue().hop();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] names = {
                "Pushok", "Zubastik", "Hvostatik", "Malysh", "Ushastik"
        };
        Map<String, Ex01_Gerbil> gerbils = new HashMap<String, Ex01_Gerbil>();
        for (String name : names)
            gerbils.put(name, new Ex01_Gerbil());

        showGerbils(gerbils);

        gerbils = new TreeMap<String, Ex01_Gerbil>(gerbils);
        gerbils = new LinkedHashMap<String, Ex01_Gerbil>(gerbils);

        showGerbils(gerbils);
    }
}
