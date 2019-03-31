/****************** Exercise 16 *****************
 * Apply the tests in Maps.java to SlowMap to
 * verify that it works. Fix anything in SlowMap
 * that doesn't work correctly.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.*;

public class Ex16_SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }

    @Override
    public V get(Object key) { // key is type Object, not K
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Itr();
        }

        @Override
        public int size() {
            return keys.size();
        }
    }

    private class Itr implements Iterator<Map.Entry<K, V>> {
        private MapEntry entry = new MapEntry();
        private boolean readOnly = true;

        @Override
        public boolean hasNext() {
            return entry.index < keys.size() - 1;
        }

        @Override
        public Map.Entry<K, V> next() {
            entry.index++;
            readOnly = false;
            return entry;
        }

        @Override
        public void remove() {
            if (readOnly) {
                throw new IllegalStateException();
            }

            keys.remove(entry.index);
            values.remove(entry.index);
            entry.index--;
        }
    }

    private class MapEntry implements Map.Entry<K, V> {
        private int index = -1;

        @Override
        public K getKey() {
            return keys.get(index);
        }

        @Override
        public V getValue() {
            return values.get(index);
        }

        @Override
        public V setValue(V value) {
            return values.set(index, value);
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Map.Entry)
                    && (getKey().equals(((Map.Entry) o).getKey()));
        }
    }
}