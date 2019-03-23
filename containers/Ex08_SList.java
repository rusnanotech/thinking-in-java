/****************** Exercise 8 *****************
 * Create a generic, singly-linked list class
 * called SList, which, to keep things simple,
 * does not implement the List interface. Each Link
 * object in the list should contain a reference to
 * the next element in the list, but not the previous
 * one (LinkedList, in contrast, is a doubly-linked
 * list, which means it maintains links in both
 * directions). Create your own SListIterator which,
 * again for simplicity, does not implement ListIterator.
 * The only method in SList other than toString()
 * should be iterator(), which produces an
 * SListIterator. The only way to insert and remove
 * elements from an SList is through SListIterator.
 * Write code to demonstrate SList.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.NoSuchElementException;

public class Ex08_SList<E> {
    private final Link first = new Link(null, null);

    public Ex08_SList() {
        first.next = first;
    }

    /* Node of the linked list */
    private class Link {
        E elem;
        Link next;

        public Link(E elem, Link next) {
            this.elem = elem;
            this.next = next;
        }
    }

    public class SListIterator {
        private Link previous = first;
        private Link current = first;

        public boolean hasNext() {
            return current.next != first;
        }

        public E next() {
            if (current.next == first) {
                throw new NoSuchElementException();
            }
            previous = current;
            current = current.next;
            return current.elem;
        }

        public void add(E elem) {
            current.next = new Link(elem, current.next);
            current = current.next;
            previous = first;
        }

        public void remove() {
            if (previous == first) {
                throw new IllegalStateException();
            }
            previous.next = current.next;
            current = previous;
            previous = first;
        }
    }

    public SListIterator iterator() {
        return new SListIterator();
    }

    public SListIterator listIterator() {
        return iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        SListIterator itr = new SListIterator();
        while (itr.hasNext()) {
            sb.append(itr.next());
            sb.append(", ");
        }
        int length = sb.length();
        if (length > 2) {
            sb.delete(length - 2, length);
        }
        sb.append("]");
        return sb.toString();
    }
}

