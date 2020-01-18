package biz.markov.thinking.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Utility for printing bits of primitive values
 * based on DataOutputStream and DataInputStream
 */
public class BitFormatter {
    static final int BYTE_SIZE = 8;
    static final int SHORT_SIZE = 2 * BYTE_SIZE;
    static final int INT_SIZE = 2 * SHORT_SIZE;
    static final int LONG_SIZE = 2 * INT_SIZE;

    public static String format(byte value) {
        return format(value, BYTE_SIZE);
    }

    public static String format(short value) {
        return format(value, SHORT_SIZE);
    }

    public static String format(char value) {
        return format(value, SHORT_SIZE);
    }

    public static String format(int value) {
        return format(value, INT_SIZE);
    }

    public static String format(long value) {
        return format(value, LONG_SIZE);
    }

    public static String format(boolean value) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream(1);
        DataOutputStream dataOut = new DataOutputStream(byteOut);

        try {
            dataOut.writeBoolean(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataInputStream dataIn = new DataInputStream(
                new ByteArrayInputStream(byteOut.toByteArray())
        );

        String result;

        try {
            result = format(dataIn.readByte(), BYTE_SIZE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static String format(float value) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream(4);
        DataOutputStream dataOut = new DataOutputStream(byteOut);

        try {
            dataOut.writeFloat(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataInputStream dataIn = new DataInputStream( new ByteArrayInputStream(byteOut.toByteArray())
        );

        String result;

        try {
            result = format(dataIn.readInt(), INT_SIZE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static String format(double value) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream(8);
        DataOutputStream dataOut = new DataOutputStream(byteOut);

        try {
            dataOut.writeDouble(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataInputStream dataIn = new DataInputStream( new ByteArrayInputStream(byteOut.toByteArray())
        );

        String result;

        try {
            result = format(dataIn.readLong(), LONG_SIZE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    private static String format(long value, int valueSize) {
        StringBuilder sb = new StringBuilder();
        long bit = 0x1L;

        for (int i = 0; i < valueSize; i++) {
            sb.insert(0, Math.abs((value & bit) >> i));
            bit <<= 1;
        }

        for (int i = 0; i <= valueSize / BYTE_SIZE; i++) {
            sb.insert(i * (BYTE_SIZE + 1), ' ');
        }

        return sb.toString();
    }

}
