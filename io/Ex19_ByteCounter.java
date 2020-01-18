/****************** Exercise 19 *****************
 * Using BinaryFile and a Map<Byte,Integer>, create
 * a program that counts the occurrence of all the
 * different bytes in a file.
 ***********************************************/
package biz.markov.thinking.io;

import net.mindview.util.BinaryFile;
import net.mindview.util.PPrint;
import net.mindview.util.TextFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex19_ByteCounter {
    public static void main(String[] args) throws IOException {
        byte[] bytes = BinaryFile.read(args[0]);
        Map<Byte, Integer> charMap = new HashMap<Byte, Integer>();

        for (Byte bt : bytes) {
            Integer count = charMap.get(bt);

            charMap.put(
                    bt,
                    count == null
                            ? 1
                            : count + 1
            );
        }

        List<Map.Entry<Byte, Integer>> chars
                = new ArrayList<Map.Entry<Byte, Integer>>(charMap.entrySet());

        Collections.sort(
                chars,
                new Comparator<Map.Entry<Byte, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Byte, Integer> e1,
                                       Map.Entry<Byte, Integer> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        PPrint.pprint(chars);
    }
}
