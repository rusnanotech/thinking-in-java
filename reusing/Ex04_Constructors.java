/****************** Exercise 4 ******************
 * Prove that base-class constructors are (a)
 * always called and (b) called before
 * derived-class constructors.
 ***********************************************/
package biz.markov.thinking.reusing;

class Ex04_BaseClass {
    Ex04_BaseClass() {
        System.out.println("Ex04_BaseClass constructor called");
    }
}

class Ex04_DerivedClass extends Ex04_BaseClass {
    Ex04_DerivedClass() {
        System.out.println("Ex04_DerivedClass constructor called");
    }
}

public class Ex04_Constructors {
    public static void main(String args[]) {
        new Ex04_DerivedClass();
    }
}
