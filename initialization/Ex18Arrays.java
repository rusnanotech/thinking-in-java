package exercises.initialization;

class Ex18Type {
    Ex18Type(String s) {
        System.out.println("Ex18Type(" + s + ")");
    }
}

public class Ex18Arrays {
    public static void main(String args[]) {
        Ex18Type[] a = new Ex18Type[5];
        for (int i = 0; i < a.length; i++)
            a[i] = new Ex18Type("string " + i);
    }
}
