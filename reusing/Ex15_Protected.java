package biz.markov.thinking.reusing;
import biz.markov.thinking.reusing.lib.*;

class Ex15_Derived extends Ex15_Base {
    Ex15_Derived() {
        System.out.println("Initializing Ex15_Derived object");
    }

    public void test() {
        System.out.println("Testing Ex15_Derived class:");
        mProtected();
        mPublic();
     // mPackage(); // not available
    }
}

public class Ex15_Protected {
    public static void main(String args[]) {
        Ex15_Base base = new Ex15_Base();

        base.test();
        System.out.println("Testing within main:");
        base.mPublic();
     // base.mPackage();   // not available
     // base.mProtected(); // not available

        Ex15_Derived derived = new Ex15_Derived();

        derived.test();
        System.out.println("Testing within main:");
        derived.mPublic();
     // derived.mPackage();   // not available
     // derived.mProtected(); // not available
    }
}
