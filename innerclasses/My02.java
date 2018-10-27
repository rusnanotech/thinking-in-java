package biz.markov.thinking.innerclasses;

interface My02_Base {
    void f();
}

public class My02 {
    private int i = 235;

    My02_Base o = new My02_Base() {
        public void f() {
            System.out.println(i);
        }
    };

    My02_Base f() {
        return new My02_Base() {
            public void f() {
                System.out.println(i);
            }
        };
    }

    public static void main(String[] args) {
        My02 m = new My02();

        m.o.f();
        m.f().f();
    }
}
