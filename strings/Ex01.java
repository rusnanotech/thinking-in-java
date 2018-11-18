/********************** Exercise 1 ********************
 * Analyze SprinklerSystem.toString( ) in
 * reusing/SprinklerSystem.java to discover
 * whether writing the toString( ) with an explicit
 * StringBuilder will save any StringBuilder creations.
 ******************************************************/

package biz.markov.thinking.strings;

class WaterSource {
   private String s;
   WaterSource() {
      System.out.println("WaterSource()");
      s = "Constructed";
   }
   public String toString() { return s; }
}

class Ex01_SprinklerSystem {
   private String valve1, valve2, valve3, valve4;
   private WaterSource source = new WaterSource();
   private int i;
   private float f;
   public String toString() {
      return
         "valve1 = " + valve1 + " " +
            "valve2 = " + valve2 + " " +
            "valve3 = " + valve3 + " " +
            "valve4 = " + valve4 + "\n" +
            "i = " + i + " " + "f = " + f + " " +
            "source = " + source;
   }
}

class Ex01_SprinklerSystem2 {
   private String valve1, valve2, valve3, valve4;
   private WaterSource source = new WaterSource();
   private int i;
   private float f;
   public String toString() {
      StringBuilder sb = new StringBuilder("valve1 = ");
      sb.append(valve1);
      sb.append(" ");
      sb.append("valve2 = ");
      sb.append(valve2);
      sb.append(" ");
      sb.append("valve3 = ");
      sb.append(valve3);
      sb.append(" ");
      sb.append("valve4 = ");
      sb.append(valve4);
      sb.append("\n");
      sb.append("i = ");
      sb.append(i);
      sb.append(" ");
      sb.append("f = ");
      sb.append(f);
      sb.append(" ");
      sb.append("source = ");
      sb.append(source);
      
      return sb.toString();
   }
}

public class Ex01 {
   public static void main(String[] args) {
      Ex01_SprinklerSystem sprinklers = new Ex01_SprinklerSystem();
      System.out.println(sprinklers);
      
      Ex01_SprinklerSystem2 sprinklers2 = new Ex01_SprinklerSystem2();
      System.out.println(sprinklers2);
   }
}