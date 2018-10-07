package biz.markov.thinking.access;
import biz.markov.thinking.access.local.Ex04_Type;

public class Ex04_Protected {
    public static void main(String args[]) {
        Ex04_Type x = new Ex04_Type();
        x.fPublic();
        //! x.fProtected(); // See biz.markov.thinking.access.pkg.Ex04_Protected
        //! x.fPackage();
    }
}
