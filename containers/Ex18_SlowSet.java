/****************** Exercise 18 *****************
 * Using SlowMap.java for inspiration, create a
 * SlowSet.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.*;

public class Ex18_SlowSet<E> extends AbstractSet<E> {
    private List<E> elements = new ArrayList<E>();

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean add(E e) {
        if (elements.contains(e)) {
            return false;
        }

        return elements.add(e);
    }
}
