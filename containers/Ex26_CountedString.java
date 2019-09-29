package biz.markov.thinking.containers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.mindview.util.Print.print;

public class Ex26_CountedString {
    private static List<String> created =
            new ArrayList<String>();
    private char c;
    private String s;
    private int id = 0;
    public Ex26_CountedString(String str, char ch) {
        s = str;
        c = ch;
        created.add(s);
        // id is the total number of instances
        // of this string in use by CountedString:
        for(String s2 : created)
            if(s2.equals(s))
                id++;
    }
    public String toString() {
        return "String: " + s + " id: " + c + id +
                " hashCode(): " + hashCode();
    }
    public int hashCode() {
        // The very simple approach:
        // return s.hashCode() * id;
        // Using Joshua Bloch's recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + c;
        result = 37 * result + id;
        return result;
    }
    public boolean equals(Object o) {
        return o instanceof Ex26_CountedString &&
                s.equals(((Ex26_CountedString)o).s) &&
                c == ((Ex26_CountedString)o).c &&
                id == ((Ex26_CountedString)o).id;
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Map<Ex26_CountedString,Integer> map =
                new HashMap<Ex26_CountedString,Integer>();
        Ex26_CountedString[] cs = new Ex26_CountedString[5];
        for(int i = 0; i < cs.length; i++) {
            cs[i] = new Ex26_CountedString("hi", 'x');
            map.put(cs[i], i); // Autobox int -> Integer
        }
        print(map);
        for(Ex26_CountedString cstring : cs) {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }

        Field f = map.getClass().getDeclaredField("table");
        f.setAccessible(true);
        Map.Entry[] table = (Map.Entry[]) f.get(map);
        System.out.println(Arrays.toString(table));
    }
}
