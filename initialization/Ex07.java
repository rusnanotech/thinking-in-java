package biz.markov.thinking.initialization;

class Ex07_Type {
    String s = "Object initialized";
    void status() {
        System.out.println(s);
    }
}

public class Ex07 {
    public static void main(String args[]) {
        Ex07_Type obj = new Ex07_Type();
        obj.status();
    }
}
