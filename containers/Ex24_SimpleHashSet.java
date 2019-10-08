/****************** Exercise 24 *****************
 * Following the example in SimpleHashMap.java,
 * create and test a SimpleHashSet.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Ex24_SimpleHashSet<E> extends AbstractSet<E> {
    private static final int SIZE = 4;

    private LinkedList<E>[] buckets;

    public Ex24_SimpleHashSet() {
        @SuppressWarnings("unchecked")
        LinkedList<E>[] array = new LinkedList[SIZE];

        this.buckets = array;
    }

    public Ex24_SimpleHashSet(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public int size() {
        int size = 0;

        for (LinkedList<E> bucket : buckets) {
            if (bucket != null) {
                size += bucket.size();
            }
        }

        return size;
    }

    @Override
    public boolean contains(Object e) {
        int index = calculateIndex(e);
        boolean result = false;

        if (buckets[index] != null) {
            result = buckets[index].contains(e);
        }

        return result;
    }

    @Override
    public boolean add(E e) {
        boolean result = false;
        int index = calculateIndex(e);

        if (buckets[index] != null) {
            ListIterator<E> listIterator = buckets[index].listIterator();
            boolean found = false;

            while (listIterator.hasNext()) {
                if (e.equals(listIterator.next())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                listIterator.add(e);
                result = true;
            }
        } else {
            buckets[index] = new LinkedList<E>();
            buckets[index].add(e);
            result = true;
        }

        return result;
    }

    @Override
    public boolean remove(Object e) {
        boolean result = false;
        int index = calculateIndex(e);

        if (buckets[index] != null) {
            ListIterator<E> listIterator = buckets[index].listIterator();

            while (listIterator.hasNext()) {
                if (e.equals(listIterator.next())) {
                    listIterator.remove();
                    if (buckets[index].isEmpty()) {
                        buckets[index] = null;
                    }
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;

        for (Object e : c) {
            result = remove(e);
        }

        return result;
    }

    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        LinkedList<E>[] array = new LinkedList[SIZE];

        this.buckets = array;
    }

    private int calculateIndex(Object e) {
        return Math.abs(e.hashCode() % SIZE);
    }

    private class Itr implements Iterator<E> {
        private int index;
        private Iterator<E> iterator;

        Itr() {
            index = 0;
            prepareIterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public E next() {
            E next = iterator.next();
            if (!iterator.hasNext()) {
                index++;
                prepareIterator();
            }

            return next;
        }

        @Override
        public void remove() {
            iterator.remove();
            if (!iterator.hasNext()) {
                if (buckets[index].isEmpty()) {
                    buckets[index] = null;
                }
                index++;
                prepareIterator();
            }
        }

        private void prepareIterator() {
            for (; index < buckets.length; index++) {
                if (buckets[index] != null) {
                    iterator = buckets[index].iterator();

                    return;
                }
            }
            iterator = Collections.<E>emptyList().iterator();
        }
    }
}
