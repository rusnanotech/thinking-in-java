/****************** Exercise 31 ******************
 * Create a container that encapsulates an array of
 * String, and that only allows adding Strings and
 * getting Strings, so that there are no casting
 * issues during use. If the internal array isn’t big
 * enough for the next add, your container should
 * automatically resize it. In main(), compare the
 * performance of your container with an
 * ArrayList<String>.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.AbstractList;
import java.util.Arrays;

public class Ex31_StringArray extends AbstractList<String> {
    private String[] array;
    private int index;
    private int size;

    public Ex31_StringArray() {
        this(16);
    }

    public Ex31_StringArray(int size) {
        this.size = size;
        array = new String[size];
    }

    @Override
    public boolean add(String string) {
        if (index >= size) {
            size = (size * 3) / 2 + 1;
            array = Arrays.copyOf(array, size);
        }
        array[index++] = string;
        return true;
    }

    @Override
    public String get(int index) throws ArrayIndexOutOfBoundsException {
        return array[index];
    }

    @Override
    public int size() {
        return index;
    }
}
