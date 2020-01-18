/****************** Exercise 5 *****************
 * Modify ProcessFiles.java so that it matches a
 * regular expression rather than a fixed
 * extension.
 ***********************************************/
package biz.markov.thinking.io;

import net.mindview.util.Directory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Ex05_ProcessFiles {
    private Strategy strategy;
    private String regexp;

    public Ex05_ProcessFiles(Strategy strategy, String regexp) {
        this.strategy = strategy;
        this.regexp = regexp;
    }

    // Demonstration of how to use it:
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:\njava " + Ex05_ProcessFiles.class.getSimpleName()
                    + " <pattern> {path}");
            return;
        }

        new Ex05_ProcessFiles(
                new Ex05_ProcessFiles.Strategy() {
                    public void process(File file) {
                        System.out.println(file);
                    }
                }
                , args[0])
                .start(Arrays.copyOfRange(args, 1, args.length));
    }

    public void start(String... args) {
        try {
            if (args.length == 0)
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), regexp)) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public interface Strategy {
        void process(File file);
    }
} /* (Execute to see output) *///:~
