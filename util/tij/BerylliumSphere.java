package biz.markov.thinking.util.tij;

public class BerylliumSphere {
   private static long counter;
   private final long id = counter++;
   
   public String toString() { return "Sphere " + id; }
   
   public static class Generator implements net.mindview.util.Generator<BerylliumSphere> {
      public BerylliumSphere next() {
         return new BerylliumSphere();
      }
   }
}
