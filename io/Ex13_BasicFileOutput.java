/****************** Exercise 13 *****************
 * Modify BasicFileOutput.java so that it uses
 * LineNumberReader to keep track of the line
 * count. Note that it’s much easier to just keep
 * track programmatically.
 ***********************************************/
package biz.markov.thinking.io;//: io/BasicFileOutput.java

import net.mindview.thinking.io.BufferedInputFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;

public class Ex13_BasicFileOutput {
    static String file = "Ex13_BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        LineNumberReader in = new LineNumberReader(
                new StringReader(
                        BufferedInputFile.read("Ex13_BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;

        while ((s = in.readLine()) != null) {
            out.println(in.getLineNumber() + ": " + s);
        }

        out.close();

        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
} /* (Execute to see output) *///:~
