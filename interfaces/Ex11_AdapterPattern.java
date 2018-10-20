/****************** Exercise 11 ******************
 * Create a class with a method that takes a String
 136
 Thinking in Java, 4th Edition Annotated Solution Guide
 * argument and produces a result that swaps each
 * pair of characters in that argument. Adapt the
 * class to work with
 * interfaceprocessor.Apply.process().
 ***********************************************/
package biz.markov.thinking.interfaces;

import biz.markov.thinking.interfaces.interfaceprocessor.Apply;
import biz.markov.thinking.interfaces.interfaceprocessor.Processor;

class Swap {
    public String name() {
        return getClass().getSimpleName();
    }

    public String process(String s) {
        if (s.length() < 2)
            return s;

        char[] chars = s.toCharArray();

        for (int i = 0; i < (chars.length / 2 * 2); i++) {
            char tmp = chars[i];
            chars[i] = chars[i + 1];
            chars[++i] = tmp;
        }

        return String.valueOf(chars);
    }
}

public class Ex11_AdapterPattern implements Processor {
    private Swap swp;

    Ex11_AdapterPattern(Swap swp) {
        this.swp = swp;
    }

    public String name() {
        return swp.name();
    }

    public Object process(Object input) {
        return swp.process((String)input);
    }

    public static void main(String args[]) {
        Processor proc = new Ex11_AdapterPattern(new Swap());
        String str = "ABCDE";

        System.out.println("Processing string " + "'" + str + "'");
        Apply.process(proc, str);
    }
}
