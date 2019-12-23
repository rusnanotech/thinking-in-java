/****************** Exercise 10 *****************
 * Using a LinkedList as your underlying
 * implementation, define your own SortedSet.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

public class Ex10_SortedSetImpl2<E> extends AbstractSet<E>
                                    implements SortedSet<E> {

    private static final SortedSet EMPTY_SET = new EmptySet();

    private LinkedList<E> list;
    private Comparator<? super E> comparator;

    public Ex10_SortedSetImpl2() {
        list = new LinkedList<E>();
        comparator = null;
    }

    public Ex10_SortedSetImpl2(Comparator<? super E> comparator) {
        this();
        this.comparator = comparator;
    }

    Ex10_SortedSetImpl2(LinkedList<E> list, Comparator<? super E> comparator) {
        this.list = list;
        this.comparator = comparator;
    }

    @Override
    public Comparator<? super E> comparator() {
        return comparator;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        if (fromElement.equals(toElement)) {
            @SuppressWarnings("unchecked")
            SortedSet<E> emptySet = (SortedSet<E>) EMPTY_SET;
            return emptySet;
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E first() {
        return list.getFirst();
    }

    @Override
    public E last() {
        return list.getLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        ListIterator<E> itr = list.listIterator();

        if (comparator() != null) {
            while (itr.hasNext()) {
                E next = itr.next();

                if (e.equals(next)) {
                    return false;
                }

                int result = comparator().compare(e, next);

                if (result < 0) {
                    itr.previous();
                    break;
                }
            }
        } else {
            @SuppressWarnings("unchecked")
            Comparable<? super E> eComparable = (Comparable<? super E>) e;

            while (itr.hasNext()) {
                E next = itr.next();

                if (e.equals(next)) {
                    return false;
                }

                int result = eComparable.compareTo(next);

                if (result < 0) {
                    itr.previous();
                    break;
                }
            }
        }
        itr.add(e);

        return true;
    }

    private static abstract class SubSetDecorator<E> extends AbstractSet<E>
                                                     implements SortedSet<E> {
        private SortedSet<E> sortedSet;

        SubSetDecorator(SortedSet<E> sortedSet) {
            this.sortedSet = sortedSet;
        }

        @Override
        public Iterator<E> iterator() {
            return sortedSet.iterator();
        }

        @Override
        public int size() {
            return sortedSet.size();
        }

        @Override
        public boolean add(E e) {
            return sortedSet.add(e);
        }

        @Override
        public Comparator<? super E> comparator() {
            return sortedSet.comparator();
        }

        @Override
        public SortedSet<E> subSet(E fromElement, E toElement) {
            return sortedSet.subSet(fromElement, toElement);
        }

        @Override
        public SortedSet<E> headSet(E toElement) {
            return sortedSet.headSet(toElement);
        }

        @Override
        public SortedSet<E> tailSet(E fromElement) {
            return sortedSet.tailSet(fromElement);
        }

        @Override
        public E first() {
            return sortedSet.first();
        }

        @Override
        public E last() {
            return sortedSet.last();
        }
    }

    private static class SubSet<E> extends SubSetDecorator<E> {
        private E first;
        private E last;

        SubSet(SortedSet<E> sortedSet, E first, E last) {
            super(sortedSet);
            this.first = first;
            this.last = last;
        }

        private class Iter implements Iterator<E> {
            private Iterator<E> itr = SubSet.this.iterator();

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }

            @Override
            public void remove() {

            }
        }

        @Override
        public Iterator<E> iterator() {
            return super.iterator();
        }

        @Override
        public int size() {
            return super.size();
        }

        @Override
        public boolean add(E e) {
            return super.add(e);
        }

        @Override
        public Comparator<? super E> comparator() {
            return super.comparator();
        }

        @Override
        public SortedSet<E> subSet(E fromElement, E toElement) {
            return super.subSet(fromElement, toElement);
        }

        @Override
        public SortedSet<E> headSet(E toElement) {
            return super.headSet(toElement);
        }

        @Override
        public SortedSet<E> tailSet(E fromElement) {
            return super.tailSet(fromElement);
        }

        @Override
        public E first() {
            return super.first();
        }

        @Override
        public E last() {
            return super.last();
        }
    }

    private static class EmptySet extends Ex10_SortedSetImpl2<Object> {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Object> iterator() {
            return new Iterator<Object>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public Object next() {
                    throw new NoSuchElementException();
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        @Override
        public boolean add(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        SortedSet<String> set = new Ex10_SortedSetImpl2<String>(String.CASE_INSENSITIVE_ORDER);
        set.add("D");
        set.add("a");
        set.add("c");
        set.add("E");
        set.add("c");
        set.add("e");
        set.add("B");
        System.out.println(set);

        SortedSet<Object> set1 = new Ex10_SortedSetImpl2<Object>();
        try {
            set1.add(new Object());
        } catch (ClassCastException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

