package biz.markov.thinking.reusing;

class My06_A {
   static {
      System.out.println("My06_A");
   }
}

class My06_B extends My06_A {
   static {
      System.out.println("My06_B");
   }
}

class My06_C extends My06_B {
   static int i;
   
   static {
      System.out.println("My06_C");
   }
}

public class My06_Static {
   public static void main(String[] args) {
      My06_C.i = 1;
   }
}
