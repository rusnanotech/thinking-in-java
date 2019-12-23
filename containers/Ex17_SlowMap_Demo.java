/****************** Exercise 17 *****************
 * Implement the rest of the Map interface
 * for SlowMap
 ***********************************************/
package biz.markov.thinking.containers;

import biz.markov.thinking.util.tij.Maps;
import biz.markov.thinking.util.tij.SlowMap;
import net.mindview.util.CountingMapData;

import java.util.Map;

public class Ex17_SlowMap_Demo {
    public static void main(String[] args) {
        Map<Integer, String> map
                = new Ex17_SlowMap<Integer, String>();
        map.putAll(new CountingMapData(5));
        System.out.println(map);

        map.keySet().remove(1);
        System.out.println(map);

        map.values().remove("A0");
        System.out.println(map);

        Maps.test(new SlowMap<Integer, String>());
    }
}
