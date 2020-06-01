package biz.markov.thinking.concurrency;

import net.mindview.util.Tuple;
import net.mindview.util.TwoTuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/****************** Exercise 5 *****************
 * Modify Exercise 2 so that the task is a Callable
 * that sums the values of all the Fibonacci numbers.
 * Create several tasks and display the results.
 ***********************************************/
public class Ex05_Callable {
    public static class Task implements Callable<TwoTuple<String, Integer>> {
        private static int count = 0;

        private final int id = count++;
        private final int max;

        public Task() {
            this(10);
        }

        public Task(int max) {
            System.out.println("#" + id + " start: " + max);
            this.max = max;
        }

        @Override
        public TwoTuple<String, Integer> call() {
            int sum = 0;
            for (int i = 0; i < max; i++) {
                int number = fib(i);
                System.out.println("#" + id + " " + number);
                sum += number;
            }
            return Tuple.tuple("#" + id, sum);
        }

        private int fib(int n) {
            Thread.yield();
            if (n < 2) {
                return 1;
            }
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) throws Exception {
        List<Future<TwoTuple<String, Integer>>> results = new ArrayList<Future<TwoTuple<String, Integer>>>();
        Random rand = new Random();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new Task(rand.nextInt(10))));
        }
        for (Future<TwoTuple<String, Integer>> result : results) {
            TwoTuple tuple = result.get();
            System.out.println(tuple.first + " " + tuple.second + ": end");
        }
        exec.shutdown();
    }
}
