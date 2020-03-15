package biz.markov.thinking.enumerated;

public class My01_ConstantMethods {
    public enum E {
        A {
            public void m() {
            }
        },
        B {
            public void m() {
            }
        },
        C
    }

    public static void main(String[] args) {
        System.out.println(E.A.getClass());
        System.out.println(E.B.getClass());
        System.out.println(E.C.getClass());
        // E.A.m();
    }
}
