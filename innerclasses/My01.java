package biz.markov.thinking.innerclasses;

class My01_Outer {
    static class My01_InnerS {
    }

    class My01_Inner {
    }

    // You can only return object of static inner class from static method:
    static My01_InnerS getInnerS() {
        return new My01_InnerS();
    }

    My01_Inner getInner() {
        return new My01_Inner();
    }

    //  In non-static method you can reference to objects
    //  of both static or non-static inner classes:
    void f() {
        My01_InnerS inner1 = new My01_InnerS();
        My01_InnerS inner2 = getInnerS();
        My01_Inner inner3 = new My01_Inner();
        My01_Inner inner4 = getInner();
    }

    //  In static method you can only reference to objects
    //  of static inner classes:
    static void fS() {
        My01_InnerS inner1 = new My01_InnerS();
        My01_InnerS inner2 = getInnerS();
        //! My01_Inner inner3 = new My01_Inner();
        //! My01_Inner inner4 = getInner();
    }
}

public class My01 {
    public static void main(String[] args) {
        //  Initialising non-static inner class:
        My01_Outer.My01_Inner inner1 = new My01_Outer().getInner();
        My01_Outer.My01_Inner inner2 = new My01_Outer().new My01_Inner();

        //  Initialising static inner class:
        My01_Outer.My01_InnerS inner3 = new My01_Outer.My01_InnerS();
        //! My01_Outer.My01_InnerS inner4 = new My01_Outer().new My01_InnerS();

        //  Can't define references to objects of inner classes:
        //! My01_Inner inner;
        //! My01_InnerS innerS;
    }
}
