/****************** Exercise 13 *****************
 * Use AssociativeArray.java to create a
 * word-occurrence counter, mapping String to Integer.
 * Using the net.mindview.util.TextFile utility in
 * this book, open a text file and break up the
 * words in that file using whitespace and
 * punctuation, and count the occurrence of the
 * words in that file.
 ***********************************************/
package biz.markov.thinking.containers;

import net.mindview.util.TextFile;
import biz.markov.thinking.containers.lib.mindview.AssociativeArray;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ex13_WordCounter {
    public static AssociativeArray<String, Integer> count(List<String> words) {
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);

        AssociativeArray<String, Integer> array
                = new AssociativeArray<String, Integer>(words.size());

        String uniqWord = "";
        int counter = 1;
        Iterator<String> itr = words.iterator();
        if (itr.hasNext()) {
            uniqWord = itr.next();
        }
        while (itr.hasNext()) {
            String word = itr.next();
            if (uniqWord.equals(word)) {
                counter++;
            } else {
                array.put(uniqWord, counter);
                uniqWord = word;
                counter = 1;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        List<String> words = new TextFile(args[0], "\\W+");
        System.out.println(count(words));
    }
}
