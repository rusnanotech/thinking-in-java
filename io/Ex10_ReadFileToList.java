/****************** Exercise 7 *****************
 * Open a text file so that you can read the file
 * one line at a time. Read each line as a String
 * and place that String object into a LinkedList.
 * Print all of the lines in the LinkedList in reverse
 * order.
 ****************** Exercise 8 *****************
 * Modify Exercise 7 so that the name of the file
 * you read is provided as a command-line argument.
 ****************** Exercise 9 *****************
 * Modify Exercise 8 to force all the lines in
 * the LinkedList to uppercase and send the results
 * to System.out.
 ****************** Exercise 10 *****************
 * Modify Exercise 8 to take additional command-line
 * arguments of words to find in the file. Print
 * all lines in which any of the words match.
 ***********************************************/
package biz.markov.thinking.io;

import net.mindview.util.PPrint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Ex10_ReadFileToList {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage:\njava " + Ex10_ReadFileToList.class.getSimpleName()
                    + " <source file> {word}");
            return;
        }

        File file = new File(args[0]);

        StringBuilder sb = new StringBuilder(".*");
        if (args.length > 1) {
            sb.append("(");
            for (int i = 1; i < args.length; i++) {
                sb.append(args[i].toUpperCase());
                sb.append("|");
            }
            sb.replace(sb.length() - 1, sb.length(), ").*");
        }

        Pattern pattern = Pattern.compile(sb.toString());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Deque<String> deque = new LinkedList<String>();
        String line;

        while ((line = reader.readLine()) != null) {
            String upperLine = line.toUpperCase();
            if (pattern.matcher(upperLine).matches()) {
                deque.addFirst(upperLine);
            }
        }
        reader.close();

        PPrint.pprint(deque);
    }
}
