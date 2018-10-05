package exercises.initialization;

import java.util.Arrays;

public class Ex16Arrays {
    public static void main(String args[]) {
        String[] s1 = {
                "s1_abcd",
                " s1_fghi",
                " s1_jklm" ,
        };

        String[] s2 = {
                "s2_ABCD",
                " s2_EFGH",
                " s2_IJKL",
        };

        String[] s3 = new String[] {
                "s3_AbCd",
                " s3_EfGh",
                " s3_IjKl",
        };

        String[] s4 = new String[3];
        for (int i = 0; i < s4.length; i++)
            s4[i] = "s4_" + i;

        for (String s : s1)
            System.out.print(s);
        System.out.println();

        for (String s : s2)
            System.out.print(s);
        System.out.println();

        System.out.println(Arrays.toString(s3));

        System.out.println(Arrays.toString(s4));

        System.out.println(Arrays.toString(new String[] {"s5_ab", "s5_bc", "s5_de"}));
    }
}
