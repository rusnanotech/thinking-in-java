package biz.markov.thinking.reusing;

class My01_A {
    My01_A() {
        System.out.println("My01_A()");
    }
}

class My01_B {
    My01_B() {
        System.out.println("My01_B()");
    }
}

class My01_C extends My01_A {
    My01_C() {
        super();
    /*
        Including of call of base class constructor using 'super()'
        don't influences on the order of constructors calls. In this example call
        of My01_A constructor is expected immediately before My02_C constructor call
        but My01_A constructor is called before initialization of My01_B member and call
        of My01_C constructor as output shows.
    */
        System.out.println("My01_C()");
    }

    My01_B b = new My01_B();
}

public class My01_ConstructorsOrder {
    public static void main(String args[]) {
        new My01_C();
    }
}
/* Output:
My01_A()
My01_B()
My01_C()
 */