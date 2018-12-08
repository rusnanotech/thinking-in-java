package biz.markov.thinking.reusing;

class My04_Super {
   My04_Super s;
   
   My04_Super() {
      s = this;
   }
}

class My04_Derived extends My04_Super {
   My04_Super s;
   
   My04_Derived() {
      //s = super;
   }
}

public class My04_ThisInSuper {
   public static void main(String[] args) {
      My04_Super d = new My04_Derived();
      System.out.println(d.s.getClass().getSimpleName());
   }
}
/* Output:
My04_Derived
*/