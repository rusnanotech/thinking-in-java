package exercises.initialization;

class Ex14_Str {
    static String str1 = "static string";
    static String str2;
    static {
        str2 = new String("static block string");
    }
    static void print() {
        System.out.println(str1);
        System.out.println(str2);
    }
}
public class Ex14_StaticBlocks {
    public static void main(String args[]) {
        Ex14_Str.print();
    }
}
