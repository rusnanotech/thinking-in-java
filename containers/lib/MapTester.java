//: containers/Maps.java
// Things you can do with Maps.
package biz.markov.thinking.containers.lib;

import biz.markov.thinking.containers.*;
import net.mindview.util.CountingMapData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapTester {
    {
        System.out.println(new CountingMapData(25));
    }

    public void test(Map<Integer, String> map) {
        Map<Integer, String> testMap = new TreeMap<Integer, String>(new CountingMapData(25));
        Map<Integer, String> testMap2 = new HashMap<Integer, String>(new CountingMapData(25));

        // putAll
        map.putAll(testMap);
        map.putAll(testMap2);
        assert(isEqualByContent(map, testMap));
        assert(map.size() == testMap.size());

        // put
        assert("A0".equals(map.put(0, "AX")));
        assert("R0".equals(map.put(17, "RX")));
        assert("Y0".equals(map.put(24, "YX")));
        assert(null == map.put(37, "AA"));
        assert("A0".equals(testMap.put(0, "AX")));
        assert("R0".equals(testMap.put(17, "RX")));
        assert("Y0".equals(testMap.put(24, "YX")));
        assert(null == testMap.put(37, "AA"));
        assert(isEqualByContent(map, testMap));
        assert(map.size() == testMap.size());

        // contains key
        assert(map.containsKey(0));
        assert(map.containsKey(17));
        assert(map.containsKey(37));
        assert(!map.containsKey(99));

        // contains value
        assert(map.containsValue("AX"));
        assert(map.containsValue("W0"));
        assert(map.containsValue("AA"));
        assert(!map.containsValue("UU"));

        // get
        assert("AX".equals(map.get(0)));
        assert("RX".equals(map.get(17)));
        assert("YX".equals(map.get(24)));
        assert("AA".equals(map.get(37)));
        assert(null == map.get(99));
        assert("AX".equals(testMap.get(0)));
        assert("RX".equals(testMap.get(17)));
        assert("YX".equals(testMap.get(24)));
        assert("AA".equals(testMap.get(37)));
        assert(null == testMap.get(99));

        // remove
        assert("AX".equals(map.remove(0)));
        assert("L0".equals(map.remove(11)));
        assert("AA".equals(map.remove(37)));
        assert(null == map.remove(99));
        assert("AX".equals(testMap.remove(0)));
        assert("L0".equals(testMap.remove(11)));
        assert("AA".equals(testMap.remove(37)));
        assert(null == testMap.remove(99));
        assert(isEqualByContent(map, testMap));
        assert(map.size() == testMap.size());

        // entry set
        assert(CollectionUtils.isEqualsByContent(map.entrySet(), testMap.entrySet()));

        Set set1 = map.keySet();
        Set set2 = testMap.keySet();

        // key set
        assert(CollectionUtils.isEqualsByContent(map.keySet(), testMap.keySet()));

        // values
        assert(CollectionUtils.isEqualsByContent(map.values(), testMap.values()));

        // clear and is empty
        assert(!map.isEmpty());
        map.clear();
        assert(map.isEmpty());
    }

    public <T extends Map<Integer, String>> void test(Class<T> type) {
        try {
            test(type.getConstructor().newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks two maps implementations for equality.
     * Returns true if the two maps have equal content and storage order.
     * */
    public static <K, V> boolean isEqualByContentAndOrder(Map<K, V> first, Map<K, V> second) {
        boolean result = true;
        Iterator<Map.Entry<K, V>> fstItr = first.entrySet().iterator();
        Iterator<Map.Entry<K, V>> sndItr = second.entrySet().iterator();

        while (fstItr.hasNext() && sndItr.hasNext()) {
            V fstVal = fstItr.next().getValue();
            V sndVal = sndItr.next().getValue();

            if (!fstVal.equals(sndVal)) {
                result = false;
                break;
            }
        }

        if (fstItr.hasNext() != sndItr.hasNext()) {
            result = false;
        }

        return result;
    }

    /**
     * Checks two maps implementations for equality.
     * Returns true if the two maps have equal content.
     * */
    public static <K, V> boolean isEqualByContent(Map<K, V> first, Map<K, V> second) {
        Set<Map.Entry<K, V>> fstSet = first.entrySet();
        Set<Map.Entry<K, V>> sndSet = second.entrySet();

        return fstSet.containsAll(sndSet) && sndSet.containsAll(fstSet);
    }

    public static void main(String[] args) {
        MapTester tester = new MapTester();
        tester.test(new HashMap<Integer,String>());
        tester.test(new TreeMap<Integer,String>());
        tester.test(new LinkedHashMap<Integer,String>());
        tester.test(new ConcurrentHashMap<Integer,String>());
        tester.test(new WeakHashMap<Integer,String>());
        tester.test(new Ex16_SlowMap<Integer, String>());
        tester.test(new Ex17_SlowMap<Integer, String>());
        tester.test(new Ex22_SimpleHashMap<Integer, String>());
        tester.test(new Ex23_SimpleHashMap<Integer, String>());
        tester.test(new Ex25_SimpleHashMap<Integer, String>());
    }
}