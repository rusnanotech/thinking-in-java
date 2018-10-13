package biz.markov.thinking.reusing.lib;

public class Ex15_Base {
    public Ex15_Base() {
        System.out.println("Initializing Ex15_Base object");
    }

    void mPackage() {
        System.out.println("package method of Ex15_Base class is available");
    }

    protected void mProtected() {
        System.out.println("protected method of Ex15_Base class is available");
    }

    public void mPublic() {
        System.out.println("public method of Ex15_Base class is available");
    }

    public void test() {
        System.out.println("Testing Ex15_Base class");
        mProtected();
        mPublic();
        mPackage();
    }
}
