package exercises.initialization;

class Ex04Msg {
    Ex04Msg() {
        System.out.println("Object created by default constructor");
    }
    Ex04Msg(int i) {
        System.out.println("Object " + i + " created by overloaded constructor");
    }
}

public class Ex04 {
    public static void main(String args[]) {
        new Ex04Msg();
        new Ex04Msg(1);
    }
}
