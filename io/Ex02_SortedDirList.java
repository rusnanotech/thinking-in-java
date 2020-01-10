package biz.markov.thinking.io;

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
                        return name.matches(regexp);
                    }
                }
        );
        ensureNotNull(dirList);
        return Arrays.asList(dir.list());
    }

    public List<String> list() {
        String[] dirList = dir.list();
        ensureNotNull(dirList);
        return Arrays.asList(dir.list());
    }

    private void ensureNotNull(String[] dirList) {
        if (dirList == null) {
            throw new RuntimeException("Error reading from " + dir);
        }
    }
}
