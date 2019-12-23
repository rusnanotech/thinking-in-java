/****************** Exercise 30 *****************
 * Compare the performance of Collections.sort()
 * between an ArrayList and a LinkedList.
 ***********************************************/
package biz.markov.thinking.containers;

import biz.markov.thinking.util.tij.test.Test;
import biz.markov.thinking.util.tij.test.TestParam;
import biz.markov.thinking.util.tij.test.Tester;
import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ex30_Sorting {
    private static abstract class BaseTest extends Test<List<String>> {
        List<String> testData = Arrays.asList(
                Generated.array(new String[Tester.defaultParams[0].size],
                        new RandomGenerator.String()));

        public BaseTest(String name) {
            super(name);
        }

        @Override
        public int test(List<String> container, TestParam tp) {
            Collections.sort(container);
            return 1;
        }
    }

    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(
                100000, 1000,
                10000, 1000,
                1000, 1000,
                100, 1000,
                10, 1000
        );
        List<Test<List<String>>> tests = new ArrayList<Test<List<String>>>();
        tests.add(
                new BaseTest("ArrayList") {
                    @Override
                    public List<String> getContainer(int size) {
                        return new ArrayList<String>(testData.subList(0, size));
                    }
                }
        );
        tests.add(
                new BaseTest("LinkedList") {
                    public List<String> getContainer(int size) {
                        return new LinkedList<String>(testData.subList(0, size));
                    }
                }
        );

        Tester.run("Collections.sort()", tests);
    }
}
