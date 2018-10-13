package biz.markov.thinking.reusing;

class Ex07_A {
    Ex07_A(int i) {
        System.out.println("Ex07_A(" + i + ")");
    }
}

class Ex07_B {
    Ex07_B(int i) {
        System.out.println("Ex07_B(" + i + ")");
    }
}

class Ex07_C extends Ex07_A {
    Ex07_C() {
        super(16);
        System.out.println("Ex07_C()");
    }
    Ex07_B b = new Ex07_B(32);
}

public class Ex07 {
    public static void main(String args[]) {
        new Ex07_C();
    }
}
