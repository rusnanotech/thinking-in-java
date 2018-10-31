/****************** Exercise 11 *****************
 * Write a method that uses an Iterator to step
 * through a Collection and print the toString()
 * of each object in the container. Fill all the
 * different types of Collections with objects and
 * apply your method to each container.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

class Ex11_Object {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() { return "obj-" + id; }
}

public class Ex11 {
    static void printAll(Iterator<?> iterator) {
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    public static void main(String[] args) {
        List<Ex11_Object> a = Arrays.asList(new Ex11_Object(), new Ex11_Object(),
                new Ex11_Object(), new Ex11_Object(), new Ex11_Object());

        System.out.println("\nArrayList:");
        printAll(new ArrayList<Ex11_Object>(a).iterator());
        System.out.println("\nLinkedList:");
        printAll(new LinkedList<Ex11_Object>(a).iterator());
        System.out.println("\nHashSet:");
        printAll(new HashSet<Ex11_Object>(a).iterator());
        System.out.println("\nLinkedHashSet:");
        printAll(new LinkedHashSet<Ex11_Object>(a).iterator());
    }
}
