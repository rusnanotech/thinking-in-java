/****************** Exercise 25 *****************
 * Instead of using a ListIterator for each bucket,
 * modify MapEntry so it is a self-contained
 * singly-linked list (each MapEntry should have a
 * forward link to the next MapEntry). Modify the
 * rest of the code in SimpleHashMap.java so
 446 Thinking in Java, 4th Edition Annotated Solution Guide
 * this new approach works correctly.
 ***********************************************/
package biz.markov.thinking.containers;

import biz.markov.thinking.containers.lib.mindview.MapEntry;
import net.mindview.util.Countries;

import java.util.*;

public class Ex25_SimpleHashMap<K, V> implements Map<K, V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;
    // You can't have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    MapEntry2<K, V>[] buckets =
            new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        MapEntry2<K, V> pair = new MapEntry2<K, V>(key, value, null);
        int index = calculateIndex(key);

        if (buckets[index] != null) {
            boolean found = false;

            for (MapEntry2<K, V> next = buckets[index];
                 !next.getKey().equals(key);
                 next = next.getNext());

            if (!found) {
                buckets[index].add(pair);
            }
        } else {
            buckets[index] = pair;
        }

        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = calculateIndex(key);
        if (buckets[index] == null) return null;
        for (MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }

    @Override
    public V remove(Object key) {
        int index = calculateIndex(key);
        if (buckets[index] == null) {
            return null;
        }
        V value = null;
        ListIterator<MapEntry<K, V>> it = buckets[index].listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                value = iPair.getValue();
                it.remove();
                break;
            }
        }
        if (buckets[index].isEmpty()) {
            buckets[index] = null;
        }
        return value;
    }

    @Override
    public void clear() {
        Arrays.fill(buckets, null);
    }

    @Override
    public int size() {
        int size = 0;
        for (LinkedList<MapEntry<K, V>> list : buckets) {
            if (list != null) {
                size += list.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = calculateIndex(key);
        if (buckets[index] == null) {
            return false;
        }
        ListIterator<MapEntry<K, V>> it = buckets[index].listIterator();
        while (it.hasNext()) {
            if (it.next().getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList<MapEntry<K, V>> list : buckets) {
            if (list == null) {
                continue;
            }
            for (MapEntry<K, V> e : list) {
                if (value.equals(e.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            set.add(bucket.getFirst().getKey());
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Set<V> set = new HashSet<V>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> mpair : bucket)
                set.add(mpair.getValue());
        }
        return set;
    }

    private int calculateIndex(Object key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    private static class MapEntry2<K, V> extends MapEntry<K, V> {
        private MapEntry2<K, V> next;

        public MapEntry2(K key, V value, MapEntry2<K, V> next) {
            super(key, value);
            this.next = next;
        }

        MapEntry2<K, V> getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
        Ex24_SimpleHashMap<String, String> m =
                new Ex24_SimpleHashMap<String, String>();

        m.putAll(Countries.capitals());
        System.out.println(m);
        m.remove("UZBEKISTAN");
        m.remove("GEORGIA");
        m.remove("LIBERIA");
        System.out.println(m);
        m.clear();
        System.out.println(m);
    }
}
