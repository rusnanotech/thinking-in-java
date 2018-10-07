package biz.markov.thinking.access.local;

public class My02_Obj {
    private Integer i = new Integer(5);

    public Integer publicMethod() {
        System.out.println("publicMethod called");
        return i;
    }

    void packageMethod() {
        System.out.println("packageMethod called");
    }

    private void privateMethod() {
        System.out.println("privateMethod called");
    }
}
