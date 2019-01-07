/****************** Exercise 17 *****************
 * Create and test a Generator for BigDecimal, and
 * ensure that it works with the Generated methods.
 ************************************************/
package biz.markov.thinking.arrays;

import net.mindview.util.Generated;
import net.mindview.util.Generator;
import java.math.BigDecimal;
import java.util.Arrays;

class BigDecimalGenerator implements Generator<BigDecimal> {
   private BigDecimal value = new BigDecimal(0);
   public BigDecimal next() {
      BigDecimal result = value;
      value = value.add(new BigDecimal(1));
      return result;
   }
}

public class Ex17_BigDecimalGenerator {
   public static void main(String[] args) {
      BigDecimal[] a = Generated.array(
            BigDecimal.class, new BigDecimalGenerator(), 9);
      System.out.println(Arrays.toString(a));
   }
}