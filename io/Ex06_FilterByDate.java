/****************** Exercise 6 *****************
 * Use ProcessFiles to find all the Java
 * source-code files in a particular directory
 * subtree that have been modified after a
 * particular date.
 ***********************************************/
package biz.markov.thinking.io;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Ex06_FilterByDate {
    public static void main(String[] args) throws ParseException {
        if (args.length < 3) {
            System.out.println("Missing arguments");

            return;
        }

        String path = args[0];
        String regexp = args[1];
        final long minDate = DateFormat.getDateInstance().parse(args[2]).getTime();

        new Ex05_ProcessFiles(
                new Ex05_ProcessFiles.Strategy() {

                    @Override
                    public void process(File file) {
                        if (file.lastModified() > minDate) {
                            System.out.println(new Date(file.lastModified()) + " " + file.getAbsolutePath());
                        }
                    }
                }
                , regexp
        ).start(path);
    }
}
