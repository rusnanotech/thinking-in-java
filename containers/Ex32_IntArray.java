/****************** Exercise 32 ******************
 * Repeat the previous exercise for a container of
 * int, and compare the performance to an
 * ArrayList<Integer>. In your performance comparison,
 * include the process of incrementing each object
 * in the container.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.Arrays;

public class Ex32_IntArray {
    private int[] array;
    private int index;
    private int size;

    public Ex32_IntArray() {
        this(16);
    }

    public Ex32_IntArray(int size) {
        this.size = size;
        array = new int[size];
    }

    public boolean add(int string) {
        if (index >= size) {
            size = (size * 3) / 2 + 1;
            array = Arrays.copyOf(array, size);
        }
        array[index++] = string;
        return true;
    }

    public int get(int index) throws ArrayIndexOutOfBoundsException {
        return array[index];
    }
}
