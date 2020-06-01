package biz.markov.thinking.concurrency;

import net.mindview.util.TwoTuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/****************** Exercise 10 *****************
 * Modify Exercise 5 following the example of the
 * ThreadMethod class, so that runTask() takes an
 * argument of the number of Fibonacci numbers to sum,
 * and each time you call runTask() it returns
 * the Future produced by the call to submit().
 ***********************************************/
public class Ex10_ThreadMethod {
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public Future<TwoTuple<String, Integer>> runTask(int count) {
        return executorService.submit(
            new Ex05_Callable.Task(count)
        );
    }

    public void shutdown() {
        executorService.shutdown();
    }

    public static void main(String[] args) throws Exception {
        Ex10_ThreadMethod threadMethod = new Ex10_ThreadMethod();
        List<Future<TwoTuple<String, Integer>>> results = new ArrayList<Future<TwoTuple<String, Integer>>>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            results.add(threadMethod.runTask(rand.nextInt(20)));
        }
        for (Future<TwoTuple<String, Integer>> result : results) {
            TwoTuple<String, Integer> tuple = result.get();
            System.out.println(tuple.first + " " + tuple.second + ": end");
        }

        threadMethod.shutdown();
    }
}
