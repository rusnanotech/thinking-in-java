package biz.markov.thinking.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/****************** Exercise 3 *****************
 * Repeat Exercise 1 using the different types of
 * executors shown in this section.
 ***********************************************/
public class Ex03_ExecutorUtil {

    public interface ExecutorServiceFactory {
        ExecutorService createExecutor();
    }

    public static void process(ExecutorServiceFactory executorFactory,
                               Class<? extends Runnable> clazz) throws Exception {
        ExecutorService exec = executorFactory.createExecutor();
        String execName = exec.getClass().getSimpleName();

        System.out.println(execName + " - start");
        for (int i = 0; i < 10; i++) {
            Runnable runnable;
            try {
                runnable = clazz.newInstance();
            } catch (Exception exception) {
                System.err.println("Cannot instantiate " + clazz.getName());
                break;
            }
            exec.execute(runnable);
        }
        exec.awaitTermination(1, TimeUnit.SECONDS);
        exec.shutdown();
        System.out.println(execName + " - end\n");
    }

    public static ExecutorServiceFactory[] factories = {
        new ExecutorServiceFactory() {
            public ExecutorService createExecutor() {
                return Executors.newSingleThreadExecutor();
            }
        },
        new ExecutorServiceFactory() {
            public ExecutorService createExecutor() {
                return Executors.newFixedThreadPool(10);
            }
        },
        new ExecutorServiceFactory() {
            public ExecutorService createExecutor() {
                return Executors.newCachedThreadPool();
            }
        },
        new ExecutorServiceFactory() {
            public ExecutorService createExecutor() {
                return Executors.newScheduledThreadPool(10);
            }
        }
    };

    public static void main(String[] args) throws Exception {
        for (ExecutorServiceFactory factory : factories) {
            process(factory, Ex01_Run.Task.class);
        }
    }
}
