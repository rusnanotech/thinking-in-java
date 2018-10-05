package exercises.initialization;

import java.util.Arrays;

enum Ex22Currency { ONE, TWO, THREE, FIVE, TEN, TWENTY }

public class Ex22EnumSwitch {
    static String testSwitch(Ex22Currency e) {
        switch (e) {
            case ONE: case TWO: case THREE:
                return "Less than five";
            case FIVE:
                return "Equal to five";
            case TEN: case TWENTY: default:
                return "More than five";
        }
    }

    public static void main(String args[]) {
        Ex22Currency e = Ex22Currency.FIVE;
        System.out.println(testSwitch(e));
    }
}
