package exercises.initialization;

import java.util.Arrays;

public class Ex19Args {
    static void f(String... args) {
        System.out.print(Arrays.toString(args));
        System.out.println();
    }

    public static void main(String args[]) {
        f("ab", "cde", "f", "ghi");
        f(new String[] {"ABCD", "EF", "GHI"});
    }
}
