/****************** Exercise 17 ******************
 * Move the Gerbil class from Exercise 1
 * into a Map, and associate each Gerbil (the value)
 * with it's name as a String (the key).
 * Use an Iterator for the keySet() to move
 * through the Map, look up the Gerbil for each key,
 * print out the key, and tell the Gerbil to hop().
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

public class Ex17_Map {
    public static void main(String[] args) {
        String[] names = {
                "Pushok", "Zubastik", "Hvostatik", "Malysh", "Ushastik"
        };
        Map<String, Ex01_Gerbil> gerbils = new HashMap<String, Ex01_Gerbil>();

        for (String name : names)
            gerbils.put(name, new Ex01_Gerbil());

        // Using iterator:
        Iterator<String> itr = gerbils.keySet().iterator();
        while (itr.hasNext()) {
            String name = itr.next();
            System.out.print(name + ": ");
            gerbils.get(name).hop();
        }

        System.out.println();

        // Using foreach:
        for (String name : gerbils.keySet()) {
            System.out.print(name + ": ");
            gerbils.get(name).hop();
        }
    }
}
