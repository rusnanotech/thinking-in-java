/****************** Exercise 4 ******************
 * Create a generator class that produces String objects
 * with the names of characters from your favorite
 * movie each time you call next(), and then loops
 * around to the beginning of the character list
 * when it runs out of names. Use this generator to
 * fill an array, an ArrayList, a LinkedList, a
 * HashSet, a LinkedHashSet, and a TreeSet, then
 * print each container.
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

public class Ex04_Generator {
    private static String[] characters = {
            "Buzz", "Rex", "Bo", "Hamm", "Slink",
            "Potato", "Woody", "Sarge", "Etch",
            "Lenny", "Squeeze", "Wheezy", "Jessie",
            "Stretch", "Buster", "Bullseye", "Sid",
    };
    private int i = 0;

    public String next() {
        return characters[i++ % characters.length];
    }

    public Collection<String> fill(int n) {
        ArrayList<String> a = new ArrayList<String>();
        for (int i = 0; i < n; i++)
            a.add(next());
        return a;
    }

    public static void main(String[] args) {
        Ex04_Generator generator = new Ex04_Generator();

        System.out.println("\nArrayList:");
        System.out.println(new ArrayList<String>(generator.fill(20)));
        System.out.println("\nLinkedList:");
        System.out.println(new LinkedList<String>(generator.fill(20)));
        System.out.println("\nHashSet:");
        System.out.println(new HashSet<String>(generator.fill(20)));
        System.out.println("\nLinkedHashSet:");
        System.out.println(new LinkedHashSet<String>(generator.fill(20)));
        System.out.println("\nTreeSet:");
        System.out.println(new TreeSet<String>(generator.fill(20)));
    }
}
