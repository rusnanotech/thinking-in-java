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

import biz.markov.thinking.util.DemoPrinter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Test class for comparing Ex08_SList class
 * with List implementations using reflection
 */
public class Ex08_SListDemo {
    private Object obj;
    private Object itr;
    private Method hasNext;
    private Method next;
    private Method add;
    private Method remove;

    public Ex08_SListDemo(Object obj) throws Exception {
        this.obj = obj;
        itr = obj.getClass()
                 .getMethod("listIterator")
                 .invoke(obj);
        Class<?> cl = itr.getClass();
        hasNext = cl.getMethod("hasNext");
        hasNext.setAccessible(true);
        next = cl.getMethod("next");
        next.setAccessible(true);
        add = cl.getMethod("add", Object.class);
        add.setAccessible(true);
        remove = cl.getMethod("remove");
        remove.setAccessible(true);
    }

    public boolean hasNext() throws Exception {
        return (Boolean) hasNext.invoke(itr);
    }

    public Object next() throws Exception {
        return next.invoke(itr);
    }

    public void add(Object obj) throws Exception {
        add.invoke(itr, obj);
    }

    public void remove() throws Exception {
        remove.invoke(itr);
    }

    public void reset() throws Exception {
        itr = obj.getClass()
                 .getMethod("listIterator")
                 .invoke(obj);
    }

    public String toString() {
        return obj.toString();
    }

    public static void test(Object obj) throws Exception {
        Ex08_SListDemo itr = new Ex08_SListDemo(obj);

        // Adding elements from 9 to 0
        for (int i = 0; i < 10; i++) {
            itr.add(i);
        }

        // Removing element 4
        itr.reset();
        while (itr.hasNext()) {
            if (Integer.valueOf(4).equals(itr.next())) {
                itr.remove();
                break;
            }
        }

        // Adding operations
        itr.add(0);
        itr.add(0);
        itr.next();
        itr.add(0);

        for (int i = 0; i < 4; i++) {
            itr.next();
        }

        DemoPrinter.print(obj, obj.getClass().getSimpleName());
    }

    public static void main(String[] args) throws Exception {
        test(new Ex08_SList<Integer>());
        test(new ArrayList<Integer>());
        test(new LinkedList<Integer>());
    }
}
