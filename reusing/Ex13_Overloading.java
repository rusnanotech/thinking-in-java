package biz.markov.thinking.reusing;

class Ex13_Base {
    void f(char c) {
        System.out.println("f(" + c + ")");
    }

    void f(int i) {
        System.out.println("f(" + i + ")");
    }

    void f(double x) {
        System.out.println("f(" + x + ")");
    }
}

class Ex13_Derived extends Ex13_Base {
    void f(String s) {
        System.out.println("f(" + s + ")");
    }
}

public class Ex13_Overloading {
    public static void main(String args[]) {
        Ex13_Derived d = new Ex13_Derived();

        d.f('u');
        d.f(50);
        d.f(3.14);
        d.f("a b c");
    }
}
