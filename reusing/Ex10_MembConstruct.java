/****************** Exercise 10 *****************
 * Modify Exercise 9 so each class only has
 * non-default constructors.
 ***********************************************/
package biz.markov.thinking.reusing;

class Ex10_Component1 {
    Ex10_Component1(String s) {
        System.out.println("Component 1: " + s);
    }
}

class Ex10_Component2 {
    Ex10_Component2(String s) {
        System.out.println("Component 2: " + s);
    }
}

class Ex10_Component3 {
    Ex10_Component3(String s) {
        System.out.println("Component 3: " + s);
    }
}

class Ex10_Root {
    Ex10_Component1 c1 = new Ex10_Component1("created as field of 'new Ex10_Root()'");
    Ex10_Component2 c2 = new Ex10_Component2("created as field of 'new Ex10_Root()'");
    Ex10_Component3 c3 = new Ex10_Component3("created as field of 'new Ex10_Root()'");

    Ex10_Root(String s) {
        System.out.println("Root: " + s);
    }
}

class Ex10_Stem extends Ex10_Root {
    Ex10_Component1 c1 = new Ex10_Component1("created as field of 'new Ex10_Stem()'");
    Ex10_Component2 c2 = new Ex10_Component2("created as field of 'new Ex10_Stem()'");
    Ex10_Component3 c3 = new Ex10_Component3("created as field of 'new Ex10_Stem()'");

    Ex10_Stem(String s) {
        super("created within 'new Ex10_Stem()'");
        System.out.println("Stem: " + s);
    }
}

public class Ex10_MembConstruct {
    public static void main(String args[]) {
        new Ex10_Stem("created by 'main()'");
    }
}
