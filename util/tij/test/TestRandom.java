package biz.markov.thinking.util.tij.test;

import java.util.Collections;
import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(
                10000000, 100,
                1000000, 1000,
                100000, 1000,
                10000, 1000,
                1000, 1000
        );

        Tester.run(
                "Random",
                Collections.<Test<Object>>singletonList(
                        new Test<Object>("rand()") {
                            @Override
                            public int test(Object container, TestParam tp) {
                                Random random = new Random(112525);
                                for (int i = 1; i <= tp.size; i++) {
                                    random.nextDouble();
                                }
                                return tp.size;
                            }
                        }
                )
        );
    }
}
