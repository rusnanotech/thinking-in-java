package biz.markov.thinking.initialization;

public class My02 {
    void f() {
        System.out.println("Method f started");
        this.g();
    }
    void g() {
        System.out.println("Method g started");
    }
    public static void main(String args[]) {
        new My02().f();
    }
}
