/****************** Exercise 1 *****************
 * Write a class named Outer containing an
 * inner class named Inner. Add a method to Outer
 * that returns an object of type Inner. In
 * main(), create and initialize a reference to
 * an Inner.
 ***********************************************/
package biz.markov.thinking.innerclasses;

class Ex01_Outer {
    class Ex01_Inner {
    }

    Ex01_Inner getInner() {
        return new Ex01_Inner();
    }
}

public class Ex01 {
    public static void main(String[] args) {
        Ex01_Outer.Ex01_Inner inner = new Ex01_Outer().getInner();
    }
}
