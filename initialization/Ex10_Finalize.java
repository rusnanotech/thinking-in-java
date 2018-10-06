package biz.markov.thinking.initialization;

public class Ex10_Finalize {
    protected void finalize() {
        System.out.println("Finalized"); // Not printed in output
    }
    public static void main(String args[]) {
        new Ex10_Finalize();
    }
}
