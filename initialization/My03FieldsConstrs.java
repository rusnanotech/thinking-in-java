// Static objects initialization
package exercises.initialization;

class My03Class3 {
    static My03Class2 j = new My03Class2("'static' j");
    static My03Class2 k = new My03Class2("'static' k");
    My03Class3(String s) {
        System.out.println("Constructor of My03Class3 for " + s + " object called");
    }
}

class My03Class2 {
    static int i = 0;
    My03Class2(String s) {
        System.out.println("Constructor of My03Class2 for " + s + " object called");
        i++;
    }
}

class My03Class1 {
    My03Class2 i1 = new My03Class2("'automatic' i1");
    My03Class1(String s) {
        System.out.println("Constructor of My03Class1 for " + s + " object called");
    }
    static My03Class2 i2 = new My03Class2("'static' i2");
}

public class My03FieldsConstrs {
    public static void main(String args[]) {
        new My03Class1(" 1st ");
        new My03Class1(" 2nd ");
        System.out.println("Constructor of My03Class2 calls: " + My03Class2.i);
        System.gc();
        System.runFinalization();
        System.out.println("Garbage collector called");
        System.out.println("Constructor of My03Class2 calls: " + My03Class2.i);
        new My03Class1(" 3rd ");
        int i = My03Class3.j.i;
        My03Class3.j.i = 0;
    }
}
