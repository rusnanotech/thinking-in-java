/****************** Exercise 1 *****************
 * Modify DirList.java (or one of its variants) so
 * that the FilenameFilter opens and reads each file
 * (using the net.mindview.util.TextFile utility) and
 * accepts the file based on whether any of the
 * trailing arguments on the command line exist in
 * that file.
 ***********************************************/
package biz.markov.thinking.io;

import net.mindview.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Ex01_DirList {
    public static void main(final String[] args) {
        File path;

        if (args.length > 0) {
            path = new File(args[0]);
        } else {
            path = new File(".");
        }

        String[] list = path.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".java")
                        && TextFile.read(new File(dir, name).getAbsolutePath())
                        .matches("(?s).*args\\[[0-9]+].*");
            }
        });

        if (list == null) {
            throw new RuntimeException("Error reading from " + path);
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
        System.out.println("\n" + list.length + " file(s) found");
    }
}
