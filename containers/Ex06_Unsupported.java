/****************** Exercise 6 ******************
 * Note that List has additional "optional"
 * operations that are not included in Collection.
 * Write a version of Unsupported.java that tests
 * these additional optional operations.
 ************************************************/
package biz.markov.thinking.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex06_Unsupported {
    public static void test(String msg, List<String> list) {
        System.out.println("\n--- " + msg + " ---");
        System.out.println(list + "\n");

        try {
            list.addAll(1, list.subList(2, 5));
        } catch (Exception e) {
            System.out.println("list.addAll(index, sublist): " + e);
        }
        System.out.println(list);

        try {
            list.add(1, "JUPITER");
        } catch (Exception e) {
            System.out.println("list.add(index, str): " + e);
        }
        System.out.println(list);

        try {
            list.remove(4);
        } catch (Exception e) {
            System.out.println("list.remove(index): " + e);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        List<String> list =
                Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<String>(list));
        test("Arrays.asList()", list);
        test("unmodifiableList()",
                Collections.unmodifiableList((
                        new ArrayList<String>(list))));
    }
}
