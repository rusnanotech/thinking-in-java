package biz.markov.thinking.io;
// Building the anonymous inner class "in-place."
// Modified version

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Ex00_DirList {
    public static void main(final String[] args) {
        String[] list;

        if (args.length == 0) {
            File path = new File(".");
            list = path.list();
        } else if (args.length == 1) {
            File path = new File(args[0]);
            list = path.list();
        } else {
            File path = new File(args[0]);
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[1]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
