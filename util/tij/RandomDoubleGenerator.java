package biz.markov.thinking.util.tij;

import java.util.*;

public class RandomDoubleGenerator {
   private final Random rand;
   private final double min;
   private final double max;
   
   public RandomDoubleGenerator(Random rand, double min, double max) {
      this.rand = rand;
      this.min = min;
      this.max = max;
   }
   
   public double nextDouble() {
      return min + (max - min) * rand.nextDouble();
   }
   
   static class Test {
      private static final Comparator<Map.Entry<Double, Integer>> ASCENDING_ORDER =
         new Comparator<Map.Entry<Double, Integer>>() {
            public int compare(Map.Entry<Double, Integer> e1, Map.Entry<Double, Integer> e2) {
               return e1.getKey().compareTo(e2.getKey());
            }
         };
      
      public static void main(String[] args) {
         double min = 3.8, max = 7.3, min1 = max, max1 = min;
         RandomDoubleGenerator gen =
            new RandomDoubleGenerator(new Random(System.nanoTime()), min, max);
         Map<Double, Integer> m = new HashMap<Double, Integer>();
         
         for (int i = 0; i < 1000000000; i++) {
            double x = gen.nextDouble();
            
            if (x < min1)
               min1 = x;
            if (x > max1)
               max1 = x;
            
            x = (double) ((int) (x * 10)) / 10;
            
            Integer freq = m.get(x);
            m.put(x, freq == null ? 1 : freq + 1);
         }
         
         List<Map.Entry<Double, Integer>> l =
            new LinkedList<Map.Entry<Double, Integer>>(m.entrySet());
         
         Collections.sort(l, ASCENDING_ORDER);
   
         System.out.println("" + min1 + " " + max1);
         for (Map.Entry e : l)
            System.out.println(e);
      }
   }
}
