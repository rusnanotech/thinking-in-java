/****************** Exercise 5 *****************
 * Modify control/VowelsAndConsonants.java so that
 * it uses three enum types: VOWEL, SOMETIMES_A_VOWEL,
 * and CONSONANT. The enum constructor should take
 * the various letters that describe that particular
 * varargs automatically creates an array for you.
 ***********************************************/

package biz.markov.thinking.enumerated;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static net.mindview.util.Print.print;

public class Ex05_VowelsAndConsonants {
    public enum LetterType {
        VOWEL('a', 'e', 'i', 'o', 'u') {
            @Override
            public String toString() {
                return "vowel";
            }
        },
        SOMETIMES_A_VOWEL('y', 'w') {
            @Override
            public String toString() {
                return "sometimes a vowel";
            }
        },
        CONSONANT {
            @Override
            public String toString() {
                return "consonant";
            }
        };

        public static LetterType getType(Character ch) {
            for (LetterType letterType : values()) {
                if (letterType.letters.contains(ch)) {
                    return letterType;
                }
            }
            return CONSONANT;
        }

        private Set<Character> letters = new HashSet<Character>();

        LetterType(Character... letters) {
            this.letters.addAll(Arrays.asList(letters));
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int c = 'a' + random.nextInt(26);
            print((char) c + ", " + c + ": " + LetterType.getType((char) c));
        }
    }
}
