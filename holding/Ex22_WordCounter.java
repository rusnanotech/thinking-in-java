/****************** Exercise 22 *****************
 * Modify the previous exercise so that it uses a
 * class containing a String and a count field to
 * store each different word, and a Set of these
 * objects to maintain the list of words.
 ***********************************************/
package biz.markov.thinking.holding;

import net.mindview.util.TextFile;

import java.util.*;

class Ex22_WordBox {
    private final String word;
    private int counter;
    public static final Comparator<Ex22_WordBox> CASE_INSENSITIVE_ORDER =
            new Comparator<Ex22_WordBox>() {
        public int compare(Ex22_WordBox box1, Ex22_WordBox box2) {
            return box1.word.compareToIgnoreCase(box2.word);
        }
    };

    Ex22_WordBox(String word) {
        this.word = word;
        counter = 1;
    }

    void incCounter() { counter++; }

    int getCounter() { return counter; }

    @Override
    public boolean equals(Object object) {
        return object instanceof Ex22_WordBox &&
                word.equals(object.toString());
    }

    @Override
    public int hashCode() { return word.hashCode(); }

    @Override
    public String toString() { return word; }
}

public class Ex22_WordCounter {
    private Set<Ex22_WordBox> occurrences = new HashSet<Ex22_WordBox>();

    void count(String word) {
        Ex22_WordBox newBox = new Ex22_WordBox(word);
        if (!occurrences.contains(newBox))
            occurrences.add(newBox);
        else
            for (Ex22_WordBox box : occurrences)
                if (newBox.equals(box))
                    box.incCounter();
    }

    Set<Ex22_WordBox> getOccurrences () {
        return occurrences;
    }

    public static void main(String[] args) {
        Ex22_WordCounter counter = new Ex22_WordCounter();
        List<String> words = new ArrayList<String>(
                new TextFile(args[0], "\\W+"));

        for (String word : words)
            counter.count(word);

        List<Ex22_WordBox> list = new ArrayList<Ex22_WordBox>(
                counter.getOccurrences());

        Collections.sort(list, Ex22_WordBox.CASE_INSENSITIVE_ORDER);

        for (Ex22_WordBox word : list)
            System.out.printf("%-20s %d\n", word, word.getCounter());
    }
}
