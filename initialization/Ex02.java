package exercises.initialization;

class Ex02String {
    String s = "This string is initialized at the point of definition.";
}

class Ex02MyString2 {
    String s;
    Ex02MyString2() {
        s = "This string is initialized by the constructor.";
    }
}

public class Ex02 {
    public static void main(String args[]) {
        Ex02String s2 = new Ex02String();
        System.out.println(s2.s);
        Ex02MyString2 s3 = new Ex02MyString2();
        System.out.println(s3.s);
    }
}
