/********************* Exercise 24 ***********************
 * Modify IntBufferDemo.java to use doubles.
 *********************************************************/
package biz.markov.thinking.io;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public class Ex24_DoubleBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();

        // Store an array of int:
        db.put(new double[]{1.1, 4.2, 4.7, 9.9, 1.43, 81.1, 10.16});

        db.flip();
        while (db.hasRemaining()) {
            double d = db.get();
            System.out.println(d);
        }
        System.out.println();

        // Absolute location read and write:
        System.out.println(db.get(3));
        db.put(3, 1811.0);

        // Setting a new limit before rewinding the buffer.
        db.flip();
        while (db.hasRemaining()) {
            double d = db.get();
            System.out.println(d);
        }
    }
}
