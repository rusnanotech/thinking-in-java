/****************** Exercise 9 *****************
 * Create a class called Root and an instance of
 * each of three classes, Component1, Component2, and
 * Component3. Derive a class Stem from Root that
 * also contains an instance of each "component."
 * Default constructors for each class should
 * print a message about that class.
 ***********************************************/
package biz.markov.thinking.reusing;

class Ex09_Component1 {
    Ex09_Component1() {
        System.out.println("Ex09_Component 1");
    }
}

class Ex09_Component2 {
    Ex09_Component2() {
        System.out.println("Ex09_Component 2");
    }
}

class Ex09_Component3 {
    Ex09_Component3() {
        System.out.println("Ex09_Component 3");
    }
}

class Ex09_Root {
    Ex09_Component1 c1 = new Ex09_Component1();
    Ex09_Component2 c2 = new Ex09_Component2();
    Ex09_Component3 c3 = new Ex09_Component3();

    Ex09_Root() {
        System.out.println("Ex09_Root");
    }
}

class Ex09_Stem extends Ex09_Root {
    Ex09_Component1 c1 = new Ex09_Component1();
    Ex09_Component2 c2 = new Ex09_Component2();
    Ex09_Component3 c3 = new Ex09_Component3();

    Ex09_Stem() {
        System.out.println("Ex09_Stem");
    }
}

public class Ex09_MemDefltConstruct {
    public static void main(String args[]) {
        new Ex09_Stem();
    }
}
