package biz.markov.thinking.containers;

import biz.markov.thinking.containers.lib.mindview.MapEntry;
import net.mindview.util.Countries;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

public class Ex22_SimpleHashMap<K,V> extends AbstractMap<K,V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;
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

    private int getBucketIndex(Object key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public static void main(String[] args) {
        Ex22_SimpleHashMap<String,String> m =
                new Ex22_SimpleHashMap<String,String>();

        m.putAll(Countries.capitals());
        System.out.println(m);
        m.remove("UZBEKISTAN");
        System.out.println(m);
        m.clear();
        System.out.println(m);
    }
}
