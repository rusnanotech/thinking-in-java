package biz.markov.thinking.access;
import biz.markov.thinking.access.local.Ex08_ConnectionManager;

public class Ex08_Client {
    public static void main(String args[]) {
        while (Ex08_ConnectionManager.connect() != null)
            ;

        Ex08_ConnectionManager.disconnect(1);

        Ex08_ConnectionManager.test(0);
        Ex08_ConnectionManager.test(1);
        Ex08_ConnectionManager.test(2);
        Ex08_ConnectionManager.test(3);
    }
}
