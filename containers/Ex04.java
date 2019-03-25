package biz.markov.thinking.containers;

import net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

public class Ex04 {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(new TextFile(args[0], "\\W+"));
        System.out.println(words);
    }
}
