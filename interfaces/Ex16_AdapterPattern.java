/****************** Exercise 16 ******************
 * Create a class that produces a sequence of chars.
 * Adapt this class so that it can be an input to a
 * Scanner object.
 ***********************************************/
package biz.markov.thinking.interfaces;
import java.nio.*;
import java.util.*;

class Ex16_RandomChars {
    private static Random rand = new Random(33);
    private char c = 'a';

    // Generates cyrillic characters from selected Unicode block:
    public char[] getCharArray() {
        char[] chars = new char[50];

        for (int i = 0; i < chars.length - 1; i++)
            chars[i] = (char)(0x0410 + rand.nextInt(0x3f));
        chars[chars.length - 1] = '\n';

        return chars;
    }
}

class Ex16_RandomCharsAdapter extends Ex16_RandomChars
                              implements Readable {
    private int counter;

    Ex16_RandomCharsAdapter(int i) {
        counter = i;
    }

    public int read(CharBuffer cb) {
        if (counter-- == 0)
            return -1;

        cb.put(getCharArray());

        return getCharArray().length;
    }
}

public class Ex16_AdapterPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(new Ex16_RandomCharsAdapter(20));

        while (s.hasNext())
            System.out.println(s.next());
    }
}
