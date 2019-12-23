/****************** Exercise 14 *****************
 * Show that java.util.Properties works in the above
 * program (containers/Maps.java from the book).
 ***********************************************/
package biz.markov.thinking.containers;

import biz.markov.thinking.util.tij.Maps;

import java.util.Map;
import java.util.Properties;

public class Ex14_Properties {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Maps.test((Map<Integer, String>) (Object) new Properties());
    }
}
