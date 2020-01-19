/****************** Exercise 22 *****************
 * Modify OSExecute.java so that, instead of
 * printing the standard output stream, it returns
 * the results of executing the program as a List
 * of Strings. Demonstrate the use of this new
 * version of the utility.
 ***********************************************/
package biz.markov.thinking.io;

import net.mindview.util.PPrint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex22_OSExecute {
    public static List<String> command(String[] command) {
        boolean err = false;
        List<String> resultList = new ArrayList<String>();
        try {
            Process process = new ProcessBuilder(command).start();

            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;

            while ((s = results.readLine()) != null) {
                resultList.add(s);
            }

            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            // Report errors and return nonzero value
            // to calling process if there are problems:
            while ((s = errors.readLine()) != null) {
                resultList.add(s);
                err = true;
            }
        } catch (Exception e) {
            resultList.add(e.toString());
        }

        if (err) {
            StringBuilder sb = new StringBuilder("'");

            for (String s : command) {
                sb.append(s);
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("'");

            resultList.add("Errors executing " + sb.toString());
        }

        return resultList;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:\njava " + Ex22_OSExecute.class.getSimpleName()
                    + " <COMMAND>");
            return;
        }

        PPrint.pprint(command(args));
    }
}
