package exercises.initialization;

import java.util.Arrays;

enum Ex21Currency { ONE, TWO, THREE, FIVE, TEN, TWENTY }

public class Ex21Enums {
    public static void main(String args[]) {
        // Technique 1:
        System.out.println(Arrays.toString(Ex21Currency.values()));

        // Technique 2:
        for (Ex21Currency e : Ex21Currency.values())
            System.out.print(e + "=" + e.ordinal() + " ");
        System.out.println();

        // Technique 3:
        for (int i = 0; i < Ex21Currency.values().length; i++) {
            System.out.print(Ex21Currency.values()[i]);
            System.out.print("=" + Ex21Currency.values()[i].ordinal() + " ");
        }
        System.out.println();

        // Test examples:
        System.out.println();

        Ex21Currency e = Ex21Currency.FIVE;

        System.out.println(e);              // FIVE
        System.out.println(e.toString());   // FIVE
        System.out.println(e.ordinal());    // 3
    }
}
