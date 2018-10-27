package biz.markov.thinking.reusing;

class My03_A {
    public int i = 1;
    int j = 2;
    protected int k = 3;
    private int l = 4;

    void f() {}
}

class My03_B extends My03_A {
    int j = 0;
}

class My03_C extends My03_B {
    void f() {
        System.out.println(i + " " + j + " " + k);
        //! System.out.println(l);
    }
}

public class My03_FieldsInheritance {
    public static void main(String[] args) {
        My03_C c = new My03_C();

        System.out.println(c.j);
        System.out.println(((My03_A)c).j);
        c.f();
        ((My03_A)c).f();
    }
}
