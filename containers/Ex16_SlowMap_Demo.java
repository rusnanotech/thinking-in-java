/****************** Exercise 16 *****************
 * Apply the tests in Maps.java to SlowMap to
 * verify that it works. Fix anything in SlowMap
 * that doesn't work correctly.
 ***********************************************/
package biz.markov.thinking.containers;

import biz.markov.thinking.containers.lib.mindview.Maps;
import biz.markov.thinking.containers.lib.mindview.SlowMap;

public class Ex16_SlowMap_Demo {
    public static void main(String[] args) {
        Maps.test(new SlowMap<Integer, String>());
        System.out.println();
        Maps.test(new Ex16_SlowMap<Integer, String>());
    }
}
