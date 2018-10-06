package exercises.initialization;

class Ex03_Msg {
    Ex03_Msg() {
        System.out.println("Object created by default constructor");
    }
}

public class Ex03 {
    public static void main(String args[]) {
        new Ex03_Msg();
    }
}
