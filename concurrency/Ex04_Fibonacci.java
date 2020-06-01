package biz.markov.thinking.concurrency;

import static biz.markov.thinking.concurrency.Ex03_ExecutorUtil.ExecutorServiceFactory;
import static biz.markov.thinking.concurrency.Ex03_ExecutorUtil.factories;
import static biz.markov.thinking.concurrency.Ex03_ExecutorUtil.process;

/****************** Exercise 4 *****************
 * Repeat Exercise 2 using the different types of
 * executors shown in this section.
 ***********************************************/
public class Ex04_Fibonacci {

    public static void main(String[] args) throws Exception {
        for (ExecutorServiceFactory factory : factories) {
            process(factory, Ex02_Fibonacci.Task.class);
        }
    }
}
