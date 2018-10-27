/****************** Exercise 19 *****************
 * Create a class containing an inner class that
 * itself contains an inner class. Repeat this
 * using static inner classes. Note the names of
 * the .class files produced by the compiler.
 ***********************************************/
package biz.markov.thinking.innerclasses;

class Ex19_Outer {
    class Inner {
    }
}

public class Ex19 {
    static class Nested {
    }

    public static void main(String[] args) {
        new Ex19_Outer().new Inner();
        new Ex19();
        new Ex19.Nested();
    }
}
/* File names:
Ex19.class,
Ex19$Nested.class,
Ex19_Outer.lass,
Ex19_Outer$Inner.class.
*/
