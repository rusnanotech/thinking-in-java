package biz.markov.thinking.access.local;

public class Ex04_Type {
    public Ex04_Type() {
        System.out.println("biz.markov.thinking.access.pkg.Ex04_Type");
    }

    public void fPublic() {
        System.out.println("Public method");
    }

    protected void fProtected() {
        System.out.println("Protected method");
    }

    void fPackage() {
        System.out.println("Package method");
    }
}
