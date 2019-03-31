/****************** Exercise 17 *****************
 * Implement the rest of the Map interface
 * for SlowMap
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.*;

public class Ex17_SlowMap<K, V> implements Map<K, V> {
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
    public V remove(Object key) {
        int index = keys.indexOf(key);
        if (index < 0) {
            return null;
        }
        keys.remove(index);
        return values.remove(index);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Iterator<? extends Map.Entry<? extends K, ? extends V>> itr
                = m.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<? extends K, ? extends V> e = itr.next();
            put(e.getKey(), e.getValue());
        }
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Set<K> keySet() {
        return new KeySet();
    }

    private class KeySet extends AbstractSet<K> {
        @Override
        public Iterator<K> iterator() {
            return new Itr();
        }

        @Override
        public int size() {
            return keys.size();
        }

        private class Itr implements Iterator<K> {
            int index = -1;
            private boolean readOnly = true;

            @Override
            public boolean hasNext() {
                return index < keys.size() - 1;
            }

            @Override
            public K next() {
                readOnly = false;
                return keys.get(++index);
            }

            @Override
            public void remove() {
                if (readOnly) {
                    throw new IllegalStateException();
                }

                keys.remove(index);
                values.remove(index);
                index--;
            }
        }
    }

    @Override
    public Collection<V> values() {
        return new Values();
    }

    private class Values extends AbstractCollection<V> {
        @Override
        public Iterator<V> iterator() {
            return new Itr();
        }

        @Override
        public int size() {
            return values.size();
        }

        @Override
        public boolean addAll(Collection<? extends V> c) {
            throw new UnsupportedOperationException();
        }

        private class Itr implements Iterator<V> {
            int index = -1;
            private boolean readOnly = true;

            @Override
            public boolean hasNext() {
                return index < values.size() - 1;
            }

            @Override
            public V next() {
                readOnly = false;
                return values.get(++index);
            }

            @Override
            public void remove() {
                if (readOnly) {
                    throw new IllegalStateException();
                }

                keys.remove(index);
                values.remove(index);
                index--;
            }
        }
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public V get(Object key) { // key is type Object, not K
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    private class EntrySet extends AbstractSet<Entry<K, V>> {
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Itr();
        }

        @Override
        public int size() {
            return keys.size();
        }

        private class Itr implements Iterator<Entry<K, V>> {
            private MapEntry entry = new MapEntry();
            private boolean readOnly = true;

            @Override
            public boolean hasNext() {
                return entry.index < keys.size() - 1;
            }

            @Override
            public Entry<K, V> next() {
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
    }

    private class MapEntry implements Entry<K, V> {
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
                    && (getKey().equals(((Entry) o).getKey()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Iterator<Map.Entry<K, V>> itr = entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<K, V> e = itr.next();
            sb.append(e.getKey());
            sb.append("=");
            sb.append(e.getValue());
            sb.append(", ");
        }
        int length = sb.length();
        if (length > 2) {
            sb.delete(length - 2, length);
        }
        sb.append("}");
        return sb.toString();
    }
}