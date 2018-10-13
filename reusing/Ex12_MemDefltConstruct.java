package biz.markov.thinking.reusing;

class Ex12_Component1 {
    Ex12_Component1() {
        System.out.println("Ex12_Component 1");
    }

    void dispose() {
        System.out.println("Ex12_Component 1 dispose");
    }
}

class Ex12_Component2 {
    Ex12_Component2() {
        System.out.println("Ex12_Component 2");
    }

    void dispose() {
        System.out.println("Ex12_Component 2 dispose");
    }
}

class Ex12_Component3 {
    Ex12_Component3() {
        System.out.println("Ex12_Component 3");
    }

    void dispose() {
        System.out.println("Ex12_Component 3 dispose");
    }
}

class Ex12_Root {
    Ex12_Component1 c1 = new Ex12_Component1();
    Ex12_Component2 c2 = new Ex12_Component2();
    Ex12_Component3 c3 = new Ex12_Component3();

    Ex12_Root() {
        System.out.println("Ex12_Root");
    }

    void dispose() {
        System.out.println("Ex12_Root dispose");
        c3.dispose();
        c2.dispose();
        c1.dispose();
    }
}

class Ex12_Stem extends Ex12_Root {
    Ex12_Component1 c1 = new Ex12_Component1();
    Ex12_Component2 c2 = new Ex12_Component2();
    Ex12_Component3 c3 = new Ex12_Component3();

    Ex12_Stem() {
        System.out.println("Ex12_Stem");
    }

    void dispose() {
        System.out.println("Ex12_Stem dispose");
        c3.dispose();
        c2.dispose();
        c1.dispose();
        super.dispose();
    }
}

public class Ex12_MemDefltConstruct {
    public static void main(String args[]) {
        Ex12_Stem x = new Ex12_Stem();
        x.dispose();
    }
}
