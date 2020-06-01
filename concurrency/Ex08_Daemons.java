package biz.markov.thinking.concurrency;

/****************** Exercise 8 *****************
 * Modify MoreBasicThreads.java so that all the
 * threads are daemon threads, and verify that the
 * program ends as soon as main() is able to exit.
 ***********************************************/
public class Ex08_Daemons {
    public static void main(String[] args) {
        System.out.println("main - start");

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Ex06_Sleep.Task());
            thread.setDaemon(true);
            thread.start();
        }

        System.out.println("main - end");
    }
}
