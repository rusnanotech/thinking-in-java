/****************** Exercise 10 *****************
 * Using a LinkedList as your underlying
 * implementation, define your own SortedSet.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.*;

public class Ex10_SortedSetImp<E> extends AbstractSet<E>
implements SortedSet<E> {
    private List<E> list;
    private Comparator<? super E> cmpr = null;

    public Ex10_SortedSetImp() {
        list = new LinkedList<E>();
    }

    public Ex10_SortedSetImp(Comparator<? super E> cmpr) {
        this();
        this.cmpr = cmpr;
    }

    public Ex10_SortedSetImp(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    public Ex10_SortedSetImp(SortedSet<E> set) {
        this(set.comparator());
        addAll(set);
    }

    /* For creating subsets */
    private Ex10_SortedSetImp(List<E> list, Comparator<? super E> cmpr) {
        this.list = list;
        this.cmpr = cmpr;
    }

    @Override
    public boolean add(E e) {
        ListIterator<E> itr = list.listIterator();

        while (itr.hasNext()) {
            E current = itr.next();

            if (compare(current, e) > 0) {
                itr.previous();
                break;
            } else if (compare(current, e) == 0) {
                return false;
            }
        }

        itr.add(e);
        return true;
    }

    private int compare(E current, E e) {
        if (cmpr == null) {
            @SuppressWarnings("unchecked")
            Comparable<E> curCmp = (Comparable<E>) current;
            return curCmp.compareTo(e);
        } else {
            return cmpr.compare(current, e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Comparator<? super E> comparator() {
        return cmpr;
    }

    @Override
    public E first() {
        return list.get(0);
    }

    @Override
    public E last() {
        return list.get(list.size() - 1);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public SortedSet<E> subSet(E fromElem, E toElem) {
        List<E> subList = list.subList(getIndex(fromElem), getIndex(toElem));
        return new SubSet<E>(subList, cmpr, fromElem, toElem);
    }

    @Override
    public SortedSet<E> headSet(E toElem) {
        List<E> subList = list.subList(0, getIndex(toElem));
        return new HeadSet<E>(subList, cmpr, toElem);
    }

    @Override
    public SortedSet<E> tailSet(E fromElem) {
        List<E> subList = list.subList(getIndex(fromElem), list.size());
        return new TailSet<E>(subList, cmpr, fromElem);
    }

    private int getIndex(E e) {
        ListIterator<E> itr = list.listIterator();
        int index = 0;

        for (; itr.hasNext(); index++) {
            E current = itr.next();

            if (compare(current, e) >= 0) {
                break;
            }
        }

        return index;
    }

    private static class SubSet<E> extends Ex10_SortedSetImp<E> {
        private E fromElem;
        private E toElem;

        private SubSet(List<E> list, Comparator<? super E> cmpr, E fromElem, E toElem) {
            super(list, cmpr);
            this.fromElem = fromElem;
            this.toElem = toElem;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            boolean added = false;

            for (E e : c) {
                if (super.compare(fromElem, e) > 0 || super.compare(e, toElem) >= 0) {
                    throw new IllegalArgumentException("key '" + e + "' out of range");
                }
                added = super.add(e);
            }

            return added;
        }

        @Override
        public boolean add(E e) {
            if (super.compare(fromElem, e) > 0 || super.compare(e, toElem) >= 0) {
                throw new IllegalArgumentException("key '" + e + "' out of range");
            }
            return super.add(e);
        }
    }

    private static class HeadSet<E> extends Ex10_SortedSetImp<E> {
        private E toElem;

        private HeadSet(List<E> list, Comparator<? super E> cmpr, E toElem) {
            super(list, cmpr);
            this.toElem = toElem;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            boolean added = false;

            for (E e : c) {
                if (super.compare(e, toElem) >= 0) {
                    throw new IllegalArgumentException("key '" + e + "' out of range");
                }
                added = super.add(e);
            }

            return added;
        }

        @Override
        public boolean add(E e) {
            if (super.compare(e, toElem) >= 0) {
                throw new IllegalArgumentException("key '" + e + "' out of range");
            }
            return super.add(e);
        }
    }

    private static class TailSet<E> extends Ex10_SortedSetImp<E> {
        private E fromElem;

        private TailSet(List<E> list, Comparator<? super E> cmpr, E fromElem) {
            super(list, cmpr);
            this.fromElem = fromElem;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            boolean added = false;

            for (E e : c) {
                if (super.compare(fromElem, e) > 0) {
                    throw new IllegalArgumentException("key '" + e + "' out of range");
                }
                added = super.add(e);
            }

            return added;
        }

        @Override
        public boolean add(E e) {
            if (super.compare(fromElem, e) > 0) {
                throw new IllegalArgumentException("key '" + e + "' out of range");
            }
            return super.add(e);
        }
    }
}
