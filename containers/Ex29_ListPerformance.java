/****************** Exercise 29 *****************
 * Modify ListPerformance.java so that the Lists hold
 * String objects instead of Integers. Use a Generator
 * from the Arrays chapter to create test values.
 ***********************************************/
//: containers/ListPerformance.java
// Demonstrates performance differences in Lists.
// {Args: 100 500} Small to keep build testing short
package biz.markov.thinking.containers;

import net.mindview.thinking.containers.Test;
import net.mindview.thinking.containers.TestParam;
import net.mindview.thinking.containers.Tester;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

public class Ex29_ListPerformance {
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<String>>> tests =
            new ArrayList<Test<List<String>>>();
    static List<Test<LinkedList<String>>> qTests =
            new ArrayList<Test<LinkedList<String>>>();

    static {
        tests.add(new Test<List<String>>("add") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++)
                        list.add(Integer.toString(j));
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<String>>("get") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });
        tests.add(new Test<List<String>>("set") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.set(rand.nextInt(listSize), "47");
                return loops;
            }
        });
        tests.add(new Test<List<String>>("iteradd") {
            public int test(List<String> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<String> it = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++)
                    it.add("47");
                return LOOPS;
            }
        });
        tests.add(new Test<List<String>>("insert") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++)
                    list.add(5, "47"); // Minimize random-access cost
                return loops;
            }
        });
        tests.add(new Test<List<String>>("remove") {
            public int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                List<String> strings = new ArrayList<String>();
                for (int i = 0; i < size; i++) {
                    strings.add(Integer.toString(i));
                }
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(strings);
                    while (list.size() > 5)
                        list.remove(5); // Minimize random-access cost
                }
                return loops * size;
            }
        });
        // Tests for queue behavior:
        qTests.add(new Test<LinkedList<String>>("addFirst") {
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addFirst("47");
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<String>>("addLast") {
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addLast("47");
                }
                return loops * size;
            }
        });
        qTests.add(
                new Test<LinkedList<String>>("rmFirst") {
                    public int test(LinkedList<String> list, TestParam tp) {
                        int loops = tp.loops;
                        int size = tp.size;
                        List<String> strings = new ArrayList<String>();
                        for (int i = 0; i < size; i++) {
                            strings.add(Integer.toString(i));
                        }
                        for (int i = 0; i < loops; i++) {
                            list.clear();
                            list.addAll(strings);
                            while (list.size() > 0)
                                list.removeFirst();
                        }
                        return loops * size;
                    }
                });
        qTests.add(new Test<LinkedList<String>>("rmLast") {
            public int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                List<String> strings = new ArrayList<String>();
                for (int i = 0; i < size; i++) {
                    strings.add(Integer.toString(i));
                }
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(strings);
                    while (list.size() > 0)
                        list.removeLast();
                }
                return loops * size;
            }
        });
    }

    static class ListTester extends Tester<List<String>> {
        public ListTester(List<String> container,
                          List<Test<List<String>>> tests) {
            super(container, tests);
        }

        // Fill to the appropriate size before each test:
        @Override
        protected List<String> initialize(int size) {
            List<String> strings = new ArrayList<String>();
            for (int i = 0; i < size; i++) {
                strings.add(Integer.toString(i));
            }
            container.clear();
            container.addAll(strings);
            return container;
        }

        // Convenience method:
        public static void run(List<String> list,
                               List<Test<List<String>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        // Can only do these two tests on an array:
        Tester<List<String>> arrayTest =
                new Tester<List<String>>(null, tests.subList(1, 3)) {
                    // This will be called before each test. It
                    // produces a non-resizeable array-backed list:
                    @Override
                    protected List<String> initialize(int size) {
                        String[] ia = Generated.array(String.class,
                                new CountingGenerator.String(), size);
                        return Arrays.asList(ia);
                    }
                };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        Tester.defaultParams = TestParam.array(
                10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        ListTester.run(new ArrayList<String>(), tests);
        ListTester.run(new LinkedList<String>(), tests);
        ListTester.run(new Vector<String>(), tests);
        Tester.fieldWidth = 12;
        Tester<LinkedList<String>> qTest =
                new Tester<LinkedList<String>>(
                        new LinkedList<String>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }
}
