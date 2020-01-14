/****************** Exercise 2 ******************
 * Create a class called SortedDirList with a
 * constructor that takes a File object and builds
 * a sorted directory list from the files at that
 * File. Add to this class two overloaded list()
 * methods: the first produces the whole list, and
 * the second produces the subset of the list that
 * matches its argument (which is a regular
 * expression).
 ***********************************************/
package biz.markov.thinking.io;

import net.mindview.util.PPrint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class Ex02_SortedDirList {
    private final File dir;

    public Ex02_SortedDirList() {
        this(new File("."));
    }

    public Ex02_SortedDirList(File dir) {
        this.dir = dir;
    }

    public List<String> list(final String regexp) {
        String[] dirList = dir.list(
                new FilenameFilter() {

                    @Override
                    public boolean accept(File dir, String name) {
                        boolean r = name.matches(regexp);
                        return name.matches(regexp);
                    }
                }
        );

        ensureNotNull(dirList);
        Arrays.sort(dirList);

        return Arrays.asList(dirList);
    }

    public List<String> list() {
        String[] dirList = dir.list();

        ensureNotNull(dirList);
        Arrays.sort(dirList);

        return Arrays.asList(dirList);
    }

    private void ensureNotNull(String[] dirList) {
        if (dirList == null) {
            throw new RuntimeException("Error reading from " + dir);
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\njava " + Ex02_SortedDirList.class.getSimpleName()
                    + " <path> <regexp>");
            return;
        }

        File path = new File(args[0]);
        String regexp = args[1];
        List<String> files = new Ex02_SortedDirList(path).list(regexp);

        PPrint.pprint(files);
    }
}
