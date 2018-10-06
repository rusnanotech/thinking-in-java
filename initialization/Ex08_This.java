package biz.markov.thinking.initialization;

public class Ex08_This {
    void f(String s) {
        System.out.println("f called " + s);
    }
    void g() {
        f("without using 'this'");
        this.f("with using 'this'");
    }
    public static void main(String args[]) {
        new Ex08_This().g();
    }
}
