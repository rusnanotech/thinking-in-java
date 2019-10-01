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

import java.util.*;

public class Ex25_SimpleHashMap<K, V> implements Map<K, V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;
    // You can't have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    Node<K, V>[] buckets = new Node[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        boolean found = false;
        int index = calculateIndex(key);
        Node<K, V> node = buckets[index];

        while (node != null) {
            if (node.getKey().equals(key)) {
                oldValue = node.getValue();
                node.setValue(value);
                found = true;
                break;
            }
            node = node.getNext();
        }
        if (!found) {
            Node<K, V> newNode = new Node<K, V>(key, value, buckets[index]);
            buckets[index] = newNode;
        }

        return oldValue;
    }

    @Override
    public V get(Object key) {
        V value = null;
        int index = calculateIndex(key);
        Node<K, V> node = buckets[index];

        while (node != null) {
            if (node.getKey().equals(key)) {
                value = node.getValue();
                break;
            }
            node = node.getNext();
        }

        return value;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        for (Node<K, V> node : buckets) {
            while (node != null) {
                set.add(node);
                node = node.getNext();
            }
        }
        return set;
    }

    @Override
    public V remove(Object key) {
        V value = null;
        int index = calculateIndex(key);
        Node<K, V> node = buckets[index];
        Node<K, V> previousNode = null;

        while (node != null) {
            if (!node.getKey().equals(key)) {
                previousNode = node;
                node = node.getNext();
                continue;
            }

            if (previousNode == null) {
                buckets[index] = null;
            } else {
                previousNode.setNext(node.getNext());
            }
            value = node.getValue();
            break;
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

        for (Node node : buckets) {
            while (node != null) {
                node = node.getNext();
                size++;
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
        Node<K, V> node = buckets[index];

        while (node != null) {
            if (node.getKey().equals(key)) {
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node<K, V> node : buckets) {
            while (node != null) {
                if (node.getValue().equals(value)) {
                    return true;
                }
                node = node.getNext();
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

        for (Node<K, V> node : buckets) {
            if (node == null) {
                continue;
            }
            set.add(node.getKey());
        }

        return set;
    }

    @Override
    public Collection<V> values() {
        Set<V> set = new HashSet<V>();

        for (Node<K, V> node : buckets) {
            while (node != null) {
                set.add(node.getValue());
                node = node.getNext();
            }
        }

        return set;
    }

    private int calculateIndex(Object key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    private static class Node<K, V> extends MapEntry<K, V> {
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            super(key, value);
            this.next = next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        Node<K, V> getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
    }
}
