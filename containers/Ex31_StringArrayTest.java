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

import biz.markov.thinking.util.tij.test.Test;
import biz.markov.thinking.util.tij.test.TestParam;
import biz.markov.thinking.util.tij.test.Tester;
import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ex31_StringArrayTest {
    static {
        Tester.defaultParams = TestParam.array(
                1000000, 1000,
                100000, 1000,
                10000, 1000,
                1000, 1000
        );
    }

    private static String[] testData = Generated.array(new String[Tester.defaultParams[0].size],
            new RandomGenerator.String());

    private static abstract class AddTest extends Test<List<String>> {
        public AddTest() {
            super("add()");
        }

        @Override
        public int test(List<String> container, TestParam tp) {
            for (int i = 0; i < tp.size; i++) {
                container.add(testData[i]);
            }
            return tp.size;
        }
    }

    private static abstract class GetTest extends Test<List<String>> {
        public GetTest() {
            super("get()");
        }

        @Override
        public int test(List<String> container, TestParam tp) {
            Random random = new Random(9571);
            for (int i = 0; i < tp.size; i++) {
                container.get(random.nextInt(tp.size));
            }
            return tp.size;
        }
    }

    public static void main(String[] args) {
        List<Test<List<String>>> stringArrayTests = new ArrayList<Test<List<String>>>();
        stringArrayTests.add(
                new AddTest() {
                    @Override
                    public List<String> getContainer(int size) {
                        return new Ex31_StringArray();
                    }
                }
        );
        stringArrayTests.add(
                new GetTest() {
                    @Override
                    public List<String> getContainer(int size) {
                        List<String> list = new Ex31_StringArray(size);
                        for (int i = 0; i < size; i++) {
                            list.add(testData[i]);
                        }
                        return list;
                    }
                }
        );

        List<Test<List<String>>> arrayListTests = new ArrayList<Test<List<String>>>();
        arrayListTests.add(
                new AddTest() {
                    @Override
                    public List<String> getContainer(int size) {
                        return new ArrayList<String>();
                    }
                }
        );
        arrayListTests.add(
                new GetTest() {
                    @Override
                    public List<String> getContainer(int size) {
                        return new ArrayList<String>(
                                Arrays.asList(Arrays.copyOfRange(testData, 0, size)));
                    }
                }
        );

        Tester.run("StringArray", stringArrayTests);
        Tester.run("ArrayList", arrayListTests);
    }
}
