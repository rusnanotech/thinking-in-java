/****************** Exercise 20 *****************
 * Modify Exercise 16 to count the occurrence of
 * each vowel.
 ***********************************************/
package biz.markov.thinking.holding;

import net.mindview.util.TextFile;

import java.util.*;

class Ex20_CharCounter {
    private final Set<Character> charset;
    private Map<Character, Integer> occurrences = new TreeMap<Character, Integer>();

    Ex20_CharCounter(Character[] characters) {
        charset = new HashSet<Character>(Arrays.asList(characters));
    }

    int count(String word) {
        int num = 0;
        for (char c : word.toCharArray()) {
            if (charset.contains(c)) {
                num++;
                if (occurrences.containsKey(c))
                    occurrences.put(c, occurrences.get(c) + 1);
                else
                    occurrences.put(c, 1);
            }
        }
        return num;
    }

    Map<Character, Integer> getOccurrences () {
        return occurrences;
    }
}

public class Ex20_VowelCounter {
    public static void main(String[] args) {
        Ex20_CharCounter counter = new Ex20_CharCounter(
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
        System.out.println(counter.getOccurrences());
    }
}
