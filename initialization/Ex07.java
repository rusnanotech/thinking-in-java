package exercises.initialization;

class Ex07Type {
    String s = "Object initialized";
    void status() {
        System.out.println(s);
    }
}

public class Ex07 {
    public static void main(String args[]) {
        Ex07Type obj = new Ex07Type();
        obj.status();
    }
}
