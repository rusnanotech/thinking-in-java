package biz.markov.thinking.reusing;

class Ex05_A {
    Ex05_A() {
        System.out.println("Ex05_A()");
    }
}

class Ex05_B {
    Ex05_B() {
        System.out.println("Ex05_B()");
    }
}

class Ex05_C extends Ex05_A {
    Ex05_B b = new Ex05_B();
}

public class Ex05 {
    public static void main(String args[]) {
        new Ex05_C();
    }
}
