package exercises.initialization;

public class Ex09This {
    Ex09This() {
        this(5);
        System.out.println("Constructor Ex09This() started");
    }
    Ex09This(int i) {
        System.out.println("Constructor Ex09This(" + i + ") started");
    }
    public static void main(String args[]) {
        new Ex09This();
    }
}
