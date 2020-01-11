/****************** Exercise 5 *****************
 * Modify ProcessFiles.java so that it matches a
 * regular expression rather than a fixed
 * extension.
 ***********************************************/
package biz.markov.thinking.io;

import net.mindview.util.Directory;

import java.io.*;

public class Ex05_ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String regexp;

    public Ex05_ProcessFiles(Strategy strategy, String regexp) {
        this.strategy = strategy;
        this.regexp = regexp;
    }

    public void start(String... args) {
        try {
            if(args.length == 0)
                processDirectoryTree(new File("."));
            else {
                for (String arg : args) {
                    File fileArg = new File(arg);

                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else if (arg.matches(regexp)) {
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for(File file : Directory.walk(root.getAbsolutePath(), regexp)) {
            strategy.process(file.getCanonicalFile());
        }
    }

    // Demonstration of how to use it:
    public static void main(String[] args) {
        new Ex05_ProcessFiles(new Ex05_ProcessFiles.Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        }, ".*ab.*java").start(args);
    }
} /* (Execute to see output) *///:~
