/****************** Exercise 3 *****************
 * Modify DirList.java (or one of its variants) so
 * that it sums up the file sizes of the selected
 * files.
 ***********************************************/
package biz.markov.thinking.io;
// Building the anonymous inner class "in-place."
// Modified version

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class Ex03_DirList {
    public static void main(final String[] args) {
        File path;
        File[] list;

        if (args.length == 0) {
            path = new File(".");
            list = path.listFiles();
        } else if (args.length == 1) {
            path = new File(args[0]);
            list = path.listFiles();
        } else {
            path = new File(args[0]);
            list = path.listFiles(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[1]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }

        if (list == null) {
            throw new RuntimeException("Error reading from " + path);
        }

        Arrays.sort(list, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return f1.getName().compareToIgnoreCase(f2.getName());
            }
        });

        long size = 0L;

        for (File dirItem : list) {
            size += dirItem.length();
            System.out.format("%-40s%-10d\n", dirItem.getName(), dirItem.length());
        }
        System.out.println("\n" + list.length + " file(s) with total size " + size + " found");
    }
}
