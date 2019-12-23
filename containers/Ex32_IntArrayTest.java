/****************** Exercise 32 ******************
 * Repeat the previous exercise for a container of
 * int, and compare the performance to an
 * ArrayList<Integer>. In your performance comparison,
 * include the process of incrementing each object
 * in the container.
 ***********************************************/
package biz.markov.thinking.containers;

import biz.markov.thinking.util.tij.test.Test;
import biz.markov.thinking.util.tij.test.TestParam;
import biz.markov.thinking.util.tij.test.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex32_IntArrayTest {
    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(
                10000000, 100,
                1000000, 1000,
                100000, 1000,
                10000, 1000,
                1000, 1000
        );

        List<Test<Ex32_IntArray>> intArrayTests = new ArrayList<Test<Ex32_IntArray>>();
        intArrayTests.add(
                new Test<Ex32_IntArray>("add()") {
                    @Override
                    public Ex32_IntArray getContainer(int size) {
                        return new Ex32_IntArray();
                    }

                    @Override
                    public int test(Ex32_IntArray container, TestParam tp) {
                        for (int i = 0; i < tp.size; i++) {
                            container.add(i);
                        }
                        return tp.size;
                    }
                }
        );
        intArrayTests.add(
                new Test<Ex32_IntArray>("get()") {
                    private Random random = new Random(9571);

                    @Override
                    public Ex32_IntArray getContainer(int size) {
                        Ex32_IntArray list = new Ex32_IntArray(size);
                        for (int i = 0; i < size; i++) {
                            list.add(i);
                        }
                        return list;
                    }

                    @Override
                    public int test(Ex32_IntArray container, TestParam tp) {
                        for (int i = 0; i < tp.size; i++) {
                            container.get(random.nextInt(tp.size));
                        }
                        return tp.size;
                    }
                }
        );

        List<Test<List<Integer>>> arrayListTests = new ArrayList<Test<List<Integer>>>();
        arrayListTests.add(
                new Test<List<Integer>>("add()") {
                    @Override
                    public List<Integer> getContainer(int size) {
                        return new ArrayList<Integer>();
                    }

                    @Override
                    public int test(List<Integer> container, TestParam tp) {
                        for (int i = 0; i < tp.size; i++) {
                            container.add(i);
                        }
                        return tp.size;
                    }
                }
        );
        arrayListTests.add(
                new Test<List<Integer>>("get()") {
                    private Random random = new Random(9571);

                    @Override
                    public List<Integer> getContainer(int size) {
                        List<Integer> list = new ArrayList<Integer>(size);
                        for (int i = 0; i < size; i++) {
                            list.add(i);
                        }
                        return list;
                    }

                    @Override
                    public int test(List<Integer> container, TestParam tp) {
                        for (int i = 0; i < tp.size; i++) {
                            container.get(random.nextInt(tp.size));
                        }
                        return tp.size;
                    }
                }
        );

        Tester.run("IntArray", intArrayTests);
        Tester.run("ArrayList", arrayListTests);
    }
}
