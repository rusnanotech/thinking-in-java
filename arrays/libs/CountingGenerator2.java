package biz.markov.thinking.arrays.libs;

import net.mindview.util.Generator;

public class CountingGenerator2 {
   public static class
   Boolean implements Generator<java.lang.Boolean> {
      private boolean value = false;
      private boolean step = true;
      public Boolean() {}
      public Boolean(boolean step) {
         this.step = step;
      }
      public java.lang.Boolean next() {
         value = step ? !value : value;
         return value;
      }
   }
   public static class
   Byte implements Generator<java.lang.Byte> {
      private byte value = 0;
      private byte step = 1;
      public Byte() {}
      public Byte(int step) {
         this.step = (byte) step;
      }
      public java.lang.Byte next() {
         byte result = value;
         value += step;
         return result;
      }
   }
   static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
      "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
   public static class
   Character implements Generator<java.lang.Character> {
      int index = -1;
      int step = 1;
      public Character() {}
      public Character(int step) {
         this.step = step;
      }
      public java.lang.Character next() {
         index = (index + step) % chars.length;
         return chars[index];
      }
   }
   public static class
   String implements Generator<java.lang.String> {
      private int length = 7;
      Generator<java.lang.Character> cg;
      public String() {}
      public String(int length, int step) {
         cg = new Character(step);
         this.length = length;
      }
      public java.lang.String next() {
         char[] buf = new char[length];
         for(int i = 0; i < length; i++)
            buf[i] = cg.next();
         return new java.lang.String(buf);
      }
   }
   public static class
   Short implements Generator<java.lang.Short> {
      private short value = 0;
      private short step = 1;
      public Short() {}
      public Short(int step) {
         this.step = (short) step;
      }
      public java.lang.Short next() {
         short result = value;
         value += step;
         return result;
      }
   }
   public static class
   Integer implements Generator<java.lang.Integer> {
      private int value = 0;
      private int step = 1;
      public Integer() {}
      public Integer(int step) {
         this.step = step;
      }
      public java.lang.Integer next() {
         int result = value;
         value += step;
         return result;
      }
   }
   public static class
   Long implements Generator<java.lang.Long> {
      private long value = 0;
      private long step = 1;
      public Long() {}
      public Long(long step) {
         this.step = step;
      }
      public java.lang.Long next() {
         long result = value;
         value += step;
         return result;
      }
   }
   public static class
   Float implements Generator<java.lang.Float> {
      private float value = 0;
      private float step = 1;
      public Float() {}
      public Float(float step) {
         this.step = step;
      }
      public java.lang.Float next() {
         float result = value;
         value += step;
         return result;
      }
   }
   public static class
   Double implements Generator<java.lang.Double> {
      private double value = 0.0;
      private double step = 1.0;
      public Double() {}
      public Double(double step) {
         this.step = step;
      }
      public java.lang.Double next() {
         double result = value;
         value += step;
         return result;
      }
   }
}

