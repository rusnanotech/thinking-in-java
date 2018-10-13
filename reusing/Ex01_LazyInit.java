package biz.markov.thinking.reusing;

class Ex01_Simple {
    private String s;

    Ex01_Simple(String s) {
        this.s = s;
    }
}

public class Ex01_LazyInit {
    private Ex01_Simple simple;
    private String s = "!";

    public String toString() {
        simple = new Ex01_Simple("Hello");
        return simple + s;
    }

    public static void main(String args[]) {
        Ex01_LazyInit li = new Ex01_LazyInit();
        System.out.println(li);
    }
}
