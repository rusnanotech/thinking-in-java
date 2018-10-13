package biz.markov.thinking.reusing;

class Ex23_Base {
    private static int k = init("static Ex23_Base.k");
    private int n = init("new Ex23_Base().n");

    static { System.out.println("Initializing static Ex23_Base block"); }

    Ex23_Base() {
        System.out.println("Initializing new Ex23_Base() object");
    }

    private static int init(String s) {
        System.out.println("Initializing " + s);
        return 39;
    }
}

class Ex23_DerivedFirst extends Ex23_Base {
    private static int k = init("static Ex23_DerivedFirst.k");
    private int n = init("new Ex23_DerivedFirst().n");

    static { System.out.println("Initializing static Ex23_DerivedFirst block"); }

    Ex23_DerivedFirst() {
        System.out.println("Initializing new Ex23_DerivedFirst() object");
    }

    private static int init(String s) {
        System.out.println("Initializing " + s);
        return 39;
    }
}

class Ex23_DerivedSecond extends Ex23_DerivedFirst {
    private static int k = init("static Ex23_DerivedSecond.k");
    private int n = init("new Ex23_DerivedSecond().n");

    static { System.out.println("Initializing static Ex23_DerivedSecond block"); }

    Ex23_DerivedSecond() {
        System.out.println("Initializing new Ex23_DerivedSecond() object");
    }

    public static void nop() {}

    private static int init(String s) {
        System.out.println("Initializing " + s);
        return 39;
    }
}

public class Ex23_InheritanceStatic {
    public static void main(String args[]) {
        // Class loading

        //     by the access of a static member:
        // Ex23_DerivedSecond.nop();

        //     by creation of the first instance:
        new Ex23_DerivedSecond().nop();
    }
}
/* Output:
Initializing static Ex23_Base.k
Initializing static Ex23_Base block
Initializing static Ex23_DerivedFirst.k
Initializing static Ex23_DerivedFirst block
Initializing static Ex23_DerivedSecond.k
Initializing static Ex23_DerivedSecond block
Initializing new Ex23_Base().n
Initializing new Ex23_Base() object
Initializing new Ex23_DerivedFirst().n
Initializing new Ex23_DerivedFirst() object
Initializing new Ex23_DerivedSecond().n
Initializing new Ex23_DerivedSecond() object
*/