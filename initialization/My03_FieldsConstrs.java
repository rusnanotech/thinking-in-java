// Static objects initialization
package exercises.initialization;

class My03_Class3 {
    static My03_Class2 j = new My03_Class2("'static' j");
    static My03_Class2 k = new My03_Class2("'static' k");
    My03_Class3(String s) {
        System.out.println("Constructor of My03_Class3 for " + s + " object called");
    }
}

class My03_Class2 {
    static int i = 0;
    My03_Class2(String s) {
        System.out.println("Constructor of My03_Class2 for " + s + " object called");
        i++;
    }
}

class My03_Class1 {
    My03_Class2 i1 = new My03_Class2("'automatic' i1");
    My03_Class1(String s) {
        System.out.println("Constructor of My03_Class1 for " + s + " object called");
    }
    static My03_Class2 i2 = new My03_Class2("'static' i2");
}

public class My03_FieldsConstrs {
    public static void main(String args[]) {
        new My03_Class1(" 1st ");
        new My03_Class1(" 2nd ");
        System.out.println("Constructor of My03_Class2 calls: " + My03_Class2.i);
        System.gc();
        System.runFinalization();
        System.out.println("Garbage collector called");
        System.out.println("Constructor of My03_Class2 calls: " + My03_Class2.i);
        new My03_Class1(" 3rd ");
        int i = My03_Class3.j.i;
        My03_Class3.j.i = 0;
    }
}
