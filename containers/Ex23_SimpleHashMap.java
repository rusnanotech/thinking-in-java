/****************** Exercise 23 *****************
 * Implement the rest of the Map interface for
 * SimpleHashMap.
 ***********************************************/
package biz.markov.thinking.containers;

import biz.markov.thinking.containers.lib.mindview.MapEntry;
import biz.markov.thinking.containers.lib.mindview.Maps;
import biz.markov.thinking.containers.lib.mindview.SlowMap;
import net.mindview.util.Countries;

import java.util.*;

public class Ex23_SimpleHashMap<K,V> implements Map<K,V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 7;
    // You can't have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets =
            new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = getBucketIndex(key);
        if(buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while(it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if(!found)
            buckets[index].add(pair);
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = getBucketIndex(key);
        if(buckets[index] == null) return null;
        for(MapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    @Override
    public Set<Entry<K,V>> entrySet() {
        Set<Entry<K,V>> set= new HashSet<Entry<K,V>>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }

    @Override
    public V remove(Object key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            return null;
        }
        V value = null;
        ListIterator<MapEntry<K,V>> it = buckets[index].listIterator();
        while(it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
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
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            return false;
        }
        ListIterator<MapEntry<K,V>> it = buckets[index].listIterator();
        while(it.hasNext()) {
            if(it.next().getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList<MapEntry<K,V>> list : buckets) {
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
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> set= new HashSet<K>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair : bucket)
                set.add(mpair.getKey());
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Set<V> set= new HashSet<V>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair : bucket)
                set.add(mpair.getValue());
        }
        return set;
    }

    private int getBucketIndex(Object key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public static void main(String[] args) {
        Maps.test(Ex23_SimpleHashMap.class);
    }
}
