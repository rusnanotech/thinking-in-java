/****************** Exercise 5 ******************
 * For each of the basic conversion types in the
 * above table, write the most complex formatting
 * expression possible. That is, use all the
 * possible format specifiers available for that
 * conversion type.
 ************************************************/
package biz.markov.thinking.strings;

import java.math.BigInteger;

public class Ex05_ConversionTypes {
   public static void main(String[] args) {
      Object vargs[] = { 8, 'ы', false, "ABCDE", 2.71828, 3.14159, 0xABCDE, new Object() };
      
      System.out.format("|%1$010d|\n", vargs);
      System.out.format("|%2$-10c|\n", vargs);
      System.out.format("|%3$-10.1b|\n", vargs);
      System.out.format("|%4$-10.3s|\n", vargs);
      System.out.format("|%5$10.6f|\n", vargs);
      System.out.format("|%6$10.2e|\n", vargs);
      System.out.format("|%7$010x|\n", vargs);
      System.out.format("|%8$10h|\n", vargs);
   }
}
