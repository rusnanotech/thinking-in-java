package exercises.initialization;

class Ex02_String {
    String s = "This string is initialized at the point of definition.";
}

class Ex02_MyString {
    String s;
    Ex02_MyString() {
        s = "This string is initialized by the constructor.";
    }
}

public class Ex02 {
    public static void main(String args[]) {
        Ex02_String s2 = new Ex02_String();
        System.out.println(s2.s);
        Ex02_MyString s3 = new Ex02_MyString();
        System.out.println(s3.s);
    }
}
