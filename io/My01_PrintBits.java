package biz.markov.thinking.io;

import static biz.markov.thinking.util.BitFormatter.format;

/**
 * Printing bits using DataInputStream and DataOutputStream
 */
public class My01_PrintBits {
    public static void main(String[] args) {
        System.out.println(format(1L) + " 1L");
        System.out.println(format(-1L) + " -1L");
        System.out.println(format(4L) + " 4L");
        System.out.println(format(-4L) + " -4L");
        System.out.println(format(Long.MIN_VALUE) + " Long.MIN_VALUE");
        System.out.println(format(Long.MAX_VALUE) + " Long.MAX_VALUE");

        System.out.println(format(0.0) + " " + 0.0);
        System.out.println(format(0.1) + " " + 0.1);
        System.out.println(format(-0.1) + " " + -0.1);
        System.out.println(format(Double.MIN_VALUE) + " Double.MIN_VALUE");
        System.out.println(format(Double.MAX_VALUE) + " Double.MAX_VALUE");
        System.out.println(format(0.0 / 0.0) + " NaN");
    }
}
