/****************** Exercise 42 *****************
 * Create two separate classes, with nothing in
 * common. Each class should hold a value, and at
 * least have methods that produce that value and
 * perform a modification upon that value. Modify
 * Functional.java so that it performs functional
 * operations on collections of your classes (these
 * operations do not have to be arithmetic as they
 * are in Functional.java).
 ************************************************/
package biz.markov.thinking.generics;

import java.util.*;

import static net.mindview.util.Print.print;

class IntegerHolder implements Comparable<IntegerHolder> {
   private int val;
   
   public IntegerHolder(int val) {
      this.val = val;
   }
   
   public int get() {
      return val;
   }
   
   public void set(int val) {
      this.val = val;
   }
   
   public int compareTo(IntegerHolder ih) {
      return val - ih.get();
   }
   
   public String toString() {
      return Integer.toString(val);
   }
}

class StringHolder implements Comparable<StringHolder> {
   private String val;
   
   public StringHolder(String val) {
      this.val = val;
   }
   
   public String get() {
      return val;
   }
   
   public void set(String val) {
      this.val = val;
   }
   
   public int compareTo(StringHolder sh) {
      return val.compareTo(sh.get());
   }
   
   public String toString() {
      return val;
   }
}

// Different types of function objects:
interface Combiner<T> {
   T combine(T x, T y);
}

interface UnaryFunction<R, T> {
   R function(T x);
}

interface Collector<T> extends UnaryFunction<T, T> {
   T result(); // Extract result of collecting parameter
}

interface UnaryPredicate<T> {
   boolean test(T x);
}

public class Ex42_Functional {
   // Calls the Combiner object on each element to combine
   // it with a running result, which is finally returned:
   public static <T> T
   reduce(Iterable<T> seq, Combiner<T> combiner) {
      Iterator<T> it = seq.iterator();
      if (it.hasNext()) {
         T result = it.next();
         while (it.hasNext())
            result = combiner.combine(result, it.next());
         return result;
      }
      // If seq is the empty list:
      return null; // Or throw exception
   }
   
   // Take a function object and call it on each object in
   // the list, ignoring the return value. The function
   // object may act as a collecting parameter, so it is
   // returned at the end.
   public static <T> Collector<T>
   forEach(Iterable<T> seq, Collector<T> func) {
      for (T t : seq)
         func.function(t);
      return func;
   }
   
   // Creates a list of results by calling a
   // function object for each object in the list:
   public static <R, T> List<R>
   transform(Iterable<T> seq, UnaryFunction<R, T> func) {
      List<R> result = new ArrayList<R>();
      for (T t : seq)
         result.add(func.function(t));
      return result;
   }
   
   // Applies a unary predicate to each item in a sequence,
   // and returns a list of items that produced "true":
   public static <T> List<T>
   filter(Iterable<T> seq, UnaryPredicate<T> pred) {
      List<T> result = new ArrayList<T>();
      for (T t : seq)
         if (pred.test(t))
            result.add(t);
      return result;
   }
   
   static class IntegerHolderAdder implements Combiner<IntegerHolder> {
      public IntegerHolder combine(IntegerHolder x, IntegerHolder y) {
         return new IntegerHolder(x.get() + y.get());
      }
   }
   
   static class StringHolderAdder implements Combiner<StringHolder> {
      private final String separator;
      
      public StringHolderAdder(String separator) {
         this.separator = separator;
      }
   
      public StringHolderAdder() {
         this.separator = "";
      }
      
      public StringHolder combine(StringHolder x, StringHolder y) {
         return new StringHolder(x.get() + separator + y.get());
      }
   }
   
   static class
   IntegerHolderSubtracter implements Combiner<IntegerHolder> {
      public IntegerHolder combine(IntegerHolder x, IntegerHolder y) {
         return new IntegerHolder(x.get() - y.get());
      }
   }
   
   static class IntegerHolderNegative
      implements UnaryFunction<IntegerHolder, IntegerHolder> {
      public IntegerHolder function(IntegerHolder x) {
         return new IntegerHolder(- x.get());
      }
   }
   
   static class IntegerToStringConverter
      implements UnaryFunction<StringHolder, IntegerHolder> {
      public StringHolder function(IntegerHolder x) {
         return new StringHolder(x.toString());
      }
   }
   
   static class StringHolderReverser
      implements UnaryFunction<StringHolder, StringHolder> {
      public StringHolder function(StringHolder x) {
         StringBuilder sb = new StringBuilder();
         String[] strings = x.get().split("");
         
         for (int i = strings.length - 1; i >= 0; i--)
            sb.append(strings[i]);
         
         return new StringHolder(sb.toString());
      }
   }
   
   static class GreaterThan<T extends Comparable<T>>
      implements UnaryPredicate<T> {
      private T bound;
      
      public GreaterThan(T bound) {
         this.bound = bound;
      }
      
      public boolean test(T x) {
         return x.compareTo(bound) > 0;
      }
   }
   
   static class MultiplyingIntegerHolderCollector
      implements Collector<IntegerHolder> {
      private int val = 1;
      
      public IntegerHolder function(IntegerHolder x) {
         val *= x.get();
         return new IntegerHolder(val);
      }
      
      public IntegerHolder result() {
         return new IntegerHolder(val);
      }
   }
   
   private static final int C = 20;
   
   public static void main(String[] args) {
      Random rand = new Random(51);
      List<IntegerHolder> li = new ArrayList<IntegerHolder>();
      for (int i = 0; i < 5; i++)
         li.add(new IntegerHolder(rand.nextInt(C)));
      print(li);
      
      IntegerHolder result = reduce(li, new IntegerHolderAdder());
      print(result);
      
      result = reduce(li, new IntegerHolderSubtracter());
      print(result);
      
      print(filter(li, new GreaterThan<IntegerHolder>(new IntegerHolder(10))));
      
      print(forEach(li,
         new MultiplyingIntegerHolderCollector()).result());
      
      print(forEach(filter(li, new GreaterThan<IntegerHolder>(new IntegerHolder(10))),
         new MultiplyingIntegerHolderCollector()).result());
   
      List<IntegerHolder> lni = transform(li, new IntegerHolderNegative());
      print(lni);
      
      List<StringHolder> si = transform(lni, new IntegerToStringConverter());
      print(transform(si, new StringHolderReverser()));
   
      si = new ArrayList<StringHolder>(
         Arrays.asList(new StringHolder("Abc"),
            new StringHolder("Def"), new StringHolder("Ghijk"),
            new StringHolder("lm"), new StringHolder("n")));
      print(si);
      
      print(reduce(si, new StringHolderAdder(" ")));
      print(transform(si, new StringHolderReverser()));
   }
}
