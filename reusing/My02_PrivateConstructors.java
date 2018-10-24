package biz.markov.thinking.reusing;

class My02_A {
    private My02_A(int i) {
        System.out.println("My02_A(" + i +")");
    }

    //  If non-private constructor doesn't exist the compiler will complain.
    My02_A() {
        System.out.println("My02_A()");
    }
}

public class My02_PrivateConstructors extends My02_A {
    My02_PrivateConstructors() {
        //! super(1);   // attempt to call private base-class constructor
        super();
    }

    public static void main(String[] args) {
        new My02_PrivateConstructors();
    }
}
