package biz.markov.thinking.holding;

import net.mindview.util.TextFile;

import java.util.*;

class Ex22_WordBox2 {
    private final String word;
    private int counter = 1;

    Ex22_WordBox2(String word) { this.word = word; }

    int getCounter() { return counter; }

    @Override
    public boolean equals(Object object) {
        if (word.equals(object.toString())) {
            ((Ex22_WordBox2)object).counter += this.counter;
            return true;
        } else
            return false;
    }

    @Override
    public String toString() { return word; }
}

public class Ex22_WordCounter2 {
    private List<Ex22_WordBox2> occurrences = new ArrayList<Ex22_WordBox2>();

    void count(String word) {
        Ex22_WordBox2 wordBox = new Ex22_WordBox2(word);
        if (!occurrences.contains(wordBox))
            occurrences.add(wordBox);
    }

    List<Ex22_WordBox2> getOccurrences () {
        return occurrences;
    }

    public static void main(String[] args) {
        Ex22_WordCounter2 counter = new Ex22_WordCounter2();
        List<String> words = new ArrayList<String>(
                new TextFile(args[0], "\\W+"));

        for (String word : words)
            counter.count(word);

        List<Ex22_WordBox2> occurrences = counter.getOccurrences();

        for (Ex22_WordBox2 word : occurrences)
            System.out.printf("%-25s %d\n", word, word.getCounter());
    }
}
