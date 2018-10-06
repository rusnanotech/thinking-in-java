package biz.markov.thinking.initialization;

enum Ex22_Currency { ONE, TWO, THREE, FIVE, TEN, TWENTY }

public class Ex22_EnumSwitch {
    static String testSwitch(Ex22_Currency e) {
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
        Ex22_Currency e = Ex22_Currency.FIVE;
        System.out.println(testSwitch(e));
    }
}
