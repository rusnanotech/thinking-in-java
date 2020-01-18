/****************** Exercise 20 *****************
 * Using Directory.walk() and BinaryFile, verify
 * that all .class files in a directory tree begin
 * with the hex characters ‘CAFEBABE’.
 ***********************************************/
package biz.markov.thinking.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ex20_ClassFileReader {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:\njava " + Ex20_ClassFileReader.class.getSimpleName()
                    + " {path}");
            return;
        }

        new Ex05_ProcessFiles(
                new Ex05_ProcessFiles.Strategy() {
                    public void process(File file) {
                        int data;
                        RandomAccessFile accessFile = null;

                        try {
                            accessFile = new RandomAccessFile(file, "r");
                            data = accessFile.readInt();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } finally {
                            if (accessFile != null) {
                                try {
                                    accessFile.close();
                                } catch (IOException e) {
                                    System.out.println("Error in closing file " + file);
                                }
                            }
                        }

                        System.out.format("0x%08X %s\n", data, file);
                    }
                }
                , ".*\\.class")
                .start(args);

    }
}
