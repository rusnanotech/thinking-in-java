/****************** Exercise 4 *****************
 * Use Directory.walk() to sum the sizes of all
 * files in a directory tree whose names match a
 * particular regular expression.
 ***********************************************/
package biz.markov.thinking.io;

import net.mindview.util.Directory;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Ex04_Walk {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\njava " + Ex04_Walk.class.getSimpleName()
                    + " <path> <regexp>");
            return;
        }

        long sum = 0;
        List<File> files = Directory.walk(args[0], args[1]).files;
        Collections.sort(files);

        for (File file : files) {
            sum += file.length();
            System.out.println(file.getAbsolutePath() + " " + file.length());
        }
        System.out.println("\n" + files.size() + " file(s) with total size " + sum + " found");
    }
}
