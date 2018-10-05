package exercises.initialization;

class Ex15Str {
    String s;
    {
        s = "String initialized";
        System.out.println(s);
    }
    Ex15Str(int i) {
        System.out.println("Object " + i + " of class 'Ex15Str' initialized");
    }
}

public class Ex15Blocks {
    public static void main(String args[]) {
        new Ex15Str(1);
        new Ex15Str(2);
    }
}
