package exercises.initialization;

class Ex17Type {
    Ex17Type(String s) {
        System.out.println("Ex17Type(" + s + ")");
    }
}

public class Ex17Arrays {
    public static void main(String args[]) {
        Ex17Type[] a = new Ex17Type[5];
    }
}
