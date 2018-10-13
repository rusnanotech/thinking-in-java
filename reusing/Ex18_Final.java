package biz.markov.thinking.reusing;
import java.util.*;

public class Ex18_Final {
    private static Random rand = new Random(2398);
    static final int C = rand.nextInt(1000);
    final int D = rand.nextInt(1000);

    public String toString() {
        return "C = " + C + "; D = " + D;
    }

    public static void main(String args[]) {
        for (int i = 0; i < 10; i++)
            System.out.println(new Ex18_Final());
    }
}
