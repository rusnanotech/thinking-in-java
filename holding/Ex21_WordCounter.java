/****************** Exercise 21 *****************
 * Using a Map<String,Integer>, follow the form of
 * UniqueWords.java to create a program that counts
 * the occurrence of words in a file. Sort the
 * results using Collections.sort() with a second
 * argument of String.CASE_INSENSITIVE_ORDER (to
 * produce an alphabetic sort), and display the result.
 ***********************************************/
package biz.markov.thinking.holding;

import net.mindview.util.TextFile;

import java.util.*;

public class Ex21_WordCounter {
    private Map<String, Integer> occurrences = new HashMap<String, Integer>();

    int count(String word) {
        if (occurrences.containsKey(word))
            occurrences.put(word, occurrences.get(word) + 1);
        else
            occurrences.put(word, 1);
        return occurrences.get(word);
    }

    Map<String, Integer> getOccurrences () {
        return occurrences;
    }

    public static void main(String[] args) {
        Ex21_WordCounter counter = new Ex21_WordCounter();
        List<String> words = new ArrayList<String>(
                new TextFile(args[0], "\\W+"));

        for (String word : words)
            counter.count(word);

        Map<String, Integer> occurrences = counter.getOccurrences();
        List<String> wordSet = new LinkedList<String>(occurrences.keySet());
        Collections.sort(wordSet, String.CASE_INSENSITIVE_ORDER);

        for (String word : wordSet)
            System.out.printf("%-25s %d\n", word, occurrences.get(word));
    }
}
