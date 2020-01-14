/****************** Exercise 12 *****************
 * Modify Exercise 8 to also open a text file so
 * you can write text into it. Write the lines in the
 * LinkedList, along with line numbers (do not
 * attempt to use the “LineNumber” classes), out
 * to the file.
 ***********************************************/
package biz.markov.thinking.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Ex12_ReadFileToList {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage:\njava " + Ex12_ReadFileToList.class.getSimpleName()
                    + " <source file> {word} <destination file>");
            return;
        }

        StringBuilder sb = new StringBuilder(".*");

        if (args.length > 2) {
            sb.append("(");
            for (int i = 1; i < args.length; i++) {
                sb.append(args[i].toUpperCase());
                sb.append("|");
            }
            sb.replace(sb.length() - 1, sb.length(), ").*");
        }

        File source = new File(args[0]);
        Pattern pattern = Pattern.compile(sb.toString(), Pattern.CASE_INSENSITIVE);
        String line;
        int count = 1;
        List<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new FileReader(source));

        while ((line = reader.readLine()) != null) {
            if (pattern.matcher(line.toUpperCase()).matches()) {
                list.add(count + " " + line);
            }
            count++;
        }
        reader.close();

        File destination = new File(args[args.length - 1]);
        PrintWriter writer = new PrintWriter(destination);

        for (String s : list) {
            writer.println(s);
        }
        writer.close();

        reader = new BufferedReader(new FileReader(destination));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
