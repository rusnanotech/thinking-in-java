package biz.markov.thinking.innerclasses;

interface My04_Interface {
    void f();
}

class My04_Base {
    private class Inner1 {
        void f() {}
    }

    private class Inner2 implements My04_Interface {
        public void f() {}
    }

    Inner1 getInner1() {
        return new Inner1();
    }

    My04_Interface getInner2() {
        return new Inner2();
    }
}

class My04_Derived extends My04_Base {
}

public class My04_PrivateInnerInheritance {
    public static void main(String[] args) {
        My04_Derived d = new My04_Derived();
        //! d.new Inner1(); // Inner1 has private access

        //! d.getInner1().f();
        d.getInner2().f();
    }
}
