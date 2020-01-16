package biz.markov.thinking.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Utility for printing bits of primitive values
 */
public class BitFormatter {
    static final int LONG_BITS = 64;

    public static String format(long number) {
        StringBuilder sb = new StringBuilder();
        long bit = 0x1L;

        for (int i = 0; i < LONG_BITS; i++) {
            sb.insert(0, Math.abs((number & bit) >> i));
            bit <<= 1;
        }

        for (int i = 0; i <= 8; i++) {
            sb.insert(i * 9, ' ');
        }

        return sb.toString();
    }

    public static String format(double value) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream(8);
        DataOutputStream dataOut = new DataOutputStream(byteOut);

        try {
            dataOut.writeDouble(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataInputStream dataIn = new DataInputStream(
                new ByteArrayInputStream(byteOut.toByteArray())
        );

        String result;

        try {
            result = format(dataIn.readLong());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
