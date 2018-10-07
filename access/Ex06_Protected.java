package biz.markov.thinking.access;

class Ex06_Data {
    protected int i = 4;
}

public class Ex06_Protected {
    public static void main(String args[]) {
        System.out.println(++(new Ex06_Data().i));
    }
}
