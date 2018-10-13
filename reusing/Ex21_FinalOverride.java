package biz.markov.thinking.reusing;

class Ex21_Base {
    final void m() {
        System.out.println("Ex21_Base.m()");
    }
}

class Ex21_Derived extends Ex21_Base {
    //  Not allowed:
    //! void m() {
    //!     System.out.println("Ex21_Derived.m()");
    //! }
}

public class Ex21_FinalOverride {
    public static void main(String args[]) {
        new Ex21_Derived().m();
    }
}
