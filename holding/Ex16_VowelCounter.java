/****************** Exercise 16 *****************
 * Create a Set of the vowels. Working from
 * UniqueWords.java, count and display the number of
 * vowels in each input word, and also display the
 * total number of vowels in the input file.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;
import net.mindview.util.*;

class Ex16_CharCounter {
    private final Set<Character> charset;

    Ex16_CharCounter(Character[] characters) {
        charset = new HashSet<Character>(Arrays.asList(characters));
    }

    int count(String word) {
        int num = 0;
        for (char c : word.toCharArray()) {
            if (charset.contains(c))
                num++;
        }
        return num;
    }
}

public class Ex16_VowelCounter {
    public static void main(String[] args) {
        Ex16_CharCounter counter = new Ex16_CharCounter(
                new Character[] {'a', 'e', 'i', 'o', 'u'});
        List<String> words = new ArrayList<String>(
                new TextFile(args[0], "\\W+"));

        int vowelsCount = 0;
        for (String word : words) {
            int n = counter.count(word.toLowerCase());
            System.out.printf("%-25s %d\n", word, n);
            vowelsCount += n;
        }
        System.out.println("\nNumber of vowels: " + vowelsCount);
    }
}
