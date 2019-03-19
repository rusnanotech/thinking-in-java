/****************** Exercise 2 ******************
 * Produce a Map and a Set containing all the
 * countries that begin with 'A'.
 ************************************************/
package biz.markov.thinking.containers;

import net.mindview.util.Countries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Map.*;

public class Ex02_Filtering {
    public static void main(String[] args) {
        Set<String> nameSet = new HashSet<String>(Countries.names());
        Set<String> nameSetA = new HashSet<String>();
        for (String name : nameSet) {
            // Checking for null reference String for preventing NullPointerException
            if ( name != null
                 && name.startsWith("A") ) {
                nameSetA.add(name);
            }
        }

        Map<String, String> countryMap = new HashMap<String, String>(Countries.capitals());
        Map<String, String> countryMapA = new HashMap<String, String>();
        for (Entry<String, String> country : countryMap.entrySet()) {
            String countryName = country.getKey();
            // Checking for null reference String for preventing NullPointerException
            if ( //countryName != null
                         //&& countryName.length() > 0
                         countryName.startsWith("A") ) {
                countryMapA.put(country.getKey(), country.getValue());
            }
        }

        System.out.println(nameSetA);
        System.out.println(countryMapA);
    }
}
