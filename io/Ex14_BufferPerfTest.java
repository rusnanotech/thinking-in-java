/****************** Exercise 14 *****************
 * Starting with BasicFileOutput.java, write a
 * program that compares the performance of writing
 * to a file when using buffered and unbuffered I/O.
 ***********************************************/
package biz.markov.thinking.io;

import net.mindview.util.TextFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex14_BufferPerfTest {
    public static void main(String[] args) throws IOException {
        String data = TextFile.read(args[0]);
        Writer out = new FileWriter(new File(args[1]));
        Writer bufferedOut = new BufferedWriter(
                        new FileWriter(
                                new File(args[1])));
        Writer printOut = new PrintWriter(new File(args[1]));


        System.out.println(writeArrayTest(data, out));
        System.out.println(writeArrayTest(data, bufferedOut));
        System.out.println(writeArrayTest(data, printOut));
        System.out.println();
        System.out.println(writeCharTest(data, out));
        System.out.println(writeCharTest(data, bufferedOut));
        System.out.println(writeCharTest(data, printOut));
    }

    static long writeArrayTest(String data, Writer out) throws IOException {
        long start = System.nanoTime();
        out.write(data.toCharArray());
        return System.nanoTime() - start;
    }

    static long writeCharTest(String data, Writer out) throws IOException {
        long start = System.nanoTime();
        for (char ch : data.toCharArray()) {
            out.write(ch);
        }
        return System.nanoTime() - start;
    }
}
