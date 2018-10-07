package biz.markov.thinking.access;
import biz.markov.thinking.access.local.My02_Obj;

public class My02 {
    public static void main(String args[]) {
        My02_Obj a = new My02_Obj();
        System.out.println(a.publicMethod());
        //! System.out.println(a.i);
        //! a.packageMethod();
        //! a.privateMethod();
    }
}
