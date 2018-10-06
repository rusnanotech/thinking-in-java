package exercises.initialization;

public class Ex09_This {
    Ex09_This() {
        this(5);
        System.out.println("Constructor Ex09_This() started");
    }
    Ex09_This(int i) {
        System.out.println("Constructor Ex09_This(" + i + ") started");
    }
    public static void main(String args[]) {
        new Ex09_This();
    }
}
