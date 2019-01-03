/****************** Exercise 37 *****************
 * Add a new mixin class Colored to Mixins.java,
 * mix it in to Mixin, and show that it works.
 ************************************************/
package biz.markov.thinking.generics;//: generics/Mixins.java

import java.util.Date;
import net.mindview.util.ThreeTuple;
import static net.mindview.util.Tuple.*;

interface TimeStamped {
   long getStamp();
}

class TimeStampedImp implements TimeStamped {
   private final long timeStamp;
   
   public TimeStampedImp() {
      timeStamp = new Date().getTime();
   }
   
   public long getStamp() {
      return timeStamp;
   }
}

interface SerialNumbered {
   long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
   private static long counter = 1;
   private final long serialNumber = counter++;
   
   public long getSerialNumber() {
      return serialNumber;
   }
}

interface Colored {
   ThreeTuple<Integer, Integer, Integer> getColor();
   
   void setColor(int red, int green, int blue);
}

class ColoredImp implements Colored {
   private static final int MAX_VALUE = 255;
   private ThreeTuple<Integer, Integer, Integer> color;
   
   protected int correctColor(int value) {
      if (value > MAX_VALUE)
         value = MAX_VALUE;
      else if (value < 0)
         value = 0;
      
      return value;
   }
   
   public void setColor(int red, int green, int blue) {
      red = correctColor(red);
      green = correctColor(green);
      blue = correctColor(blue);
      
      color = tuple(red, green, blue);
   }
   
   public ThreeTuple<Integer, Integer, Integer> getColor() {
      return color;
   }
}

interface Basic {
   public void set(String val);
   
   public String get();
}

class BasicImp implements Basic {
   private String value;
   
   public void set(String val) {
      value = val;
   }
   
   public String get() {
      return value;
   }
}

class Mixin extends BasicImp
   implements TimeStamped, SerialNumbered, Colored {
   private TimeStamped timeStamp = new TimeStampedImp();
   private SerialNumbered serialNumber =
      new SerialNumberedImp();
   private Colored color = new ColoredImp();
   
   public long getStamp() {
      return timeStamp.getStamp();
   }
   
   public long getSerialNumber() {
      return serialNumber.getSerialNumber();
   }
   
   public void setColor(int red, int green, int blue) {
      color.setColor(red, green, blue);
   }
   
   public ThreeTuple<Integer, Integer, Integer> getColor() {
      return color.getColor();
   }
}

public class Ex37_Mixins {
   public static void main(String[] args) {
      Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
      mixin1.set("test string 1");
      mixin1.setColor(64, -3, 140);
      mixin2.set("test string 2");
      mixin2.setColor(300, 168, 128);
      
      System.out.println(mixin1.get() + " " + mixin1.getColor() + " " +
         mixin1.getStamp() + " " + mixin1.getSerialNumber());
      System.out.println(mixin2.get() + " " + mixin2.getColor() + " " +
         mixin2.getStamp() + " " + mixin2.getSerialNumber());
   }
}
