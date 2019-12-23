/**
 * Modified framework for performing timed tests of containers
 * from Thinking in Java.
 */
package biz.markov.thinking.util.tij.test;
//: containers/Tester.java
// Applies Test objects to lists of different containers.

import java.util.List;

public class Tester<C> {
    public static int fieldWidth = 10;
    public static TestParam[] defaultParams = TestParam.array(
            10, 5000, 100, 5000, 1000, 5000, 10000, 5000);

    private String headline = "";
    private List<Test<C>> tests;

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 10;
    private static String sizeField = "%" + sizeWidth + "s";
    private TestParam[] paramList = defaultParams;

    public Tester(List<Test<C>> tests) {
        this.tests = tests;
    }

    public Tester(List<Test<C>> tests,
                  TestParam[] paramList) {
        this(tests);
        this.paramList = paramList;
    }

    public void setHeadline(String newHeadline) {
        headline = newHeadline;
    }

    // Generic methods for convenience :
    public static <C> void run(String name, List<Test<C>> tests) {
        Tester<C> tester = new Tester<C>(tests);
        tester.headline = name;
        tester.timedTest();
    }

    public static <C> void run(String name, List<Test<C>> tests, TestParam[] paramList) {
        Tester<C> tester = new Tester<C>(tests, paramList);
        tester.headline = name;
        tester.timedTest();
    }

    private void displayHeader() {
        // Calculate width and pad with '-':
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder head = new StringBuilder(width);

        for (int i = 0; i < dashLength / 2; i++)
            head.append('-');
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++)
            head.append('-');
        System.out.println(head);

        // Print column headers:
        System.out.format(sizeField, "size");
        for (Test test : tests)
            System.out.format(stringField(), test.name);
        System.out.println();
    }

    // Run the tests for this container:
    public void timedTest() {
        // warmUp();
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for (Test<C> test : tests) {
                long duration = 0;
                int reps = 0;

                for (int i = 0; i < param.loops; i++) {
                    C kontainer = test.getContainer(param.size);
                    long start = System.nanoTime();
                    int result = test.test(kontainer, param);
                    long end = System.nanoTime();
                    duration += end - start;
                    reps += result;
                }
                System.out.format(numberField(), duration / reps);
            }
            System.out.println();
        }
    }

    private void warmUp() {
        // System.out.println("Warming up");
        for (TestParam param : paramList) {
            for (Test<C> test : tests) {
                for (int i = 0; i < param.loops; i++) {
                    C kontainer = test.getContainer(param.size);
                    test.test(kontainer, param);
                }
            }
        }
        System.gc();
        // System.out.println("Starting test");
    }
} ///:~
