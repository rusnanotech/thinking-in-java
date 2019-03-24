package biz.markov.thinking.containers.lib;

public class DemoPrinter {
    public static void print(Object o, String msg) {
        System.out.format("%-20s%s\n", msg + ":", o);
    }
}
