package biz.markov.thinking.reusing;

class Ex08_Base {
    Ex08_Base(int i) {
        System.out.println("Ex08_Base(" + i + ")");
    }
}

class Ex08_Derived extends Ex08_Base {
    Ex08_Derived() {
        super(0);
        System.out.println("Ex08_Derived()");
    }

    Ex08_Derived(int i) {
        super(i);
        System.out.println("Ex08_Derived(" + i + ")");
    }
}

public class Ex08_DifferentConstruct {
    public static void main(String args[]) {
        new Ex08_Derived();
        new Ex08_Derived(97);
    }
}
