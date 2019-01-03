package biz.markov.thinking.generics;

class My02_A<T extends My02_A> {
   void set(T o) {
      System.out.println("My02_A.set()");
   }
}

class My02_B1 extends My02_A<My02_A> {
   public void set(My02_B1 b) {
      System.out.println("My02_B1.set()");
   }
}

class My02_B2 extends My02_A<My02_B2> {
   public void set(My02_B2 b) {
      System.out.println("My02_B2.set()");
   }
}

public class My02 {
   public static void main(String[] args) {
      My02_A<My02_A> aa = new My02_A<My02_A>();
      My02_A<My02_B1> ab1 = new My02_A<My02_B1>();
      My02_A<My02_B2> ab2 = new My02_A<My02_B2>();
      
      My02_B1 b1 = new My02_B1();
      My02_B2 b2 = new My02_B2();
   
      System.out.println("1:");
      
      b1.set(aa);
      b1.set(ab1);
      b1.set(ab2);
      b1.set(b1);
      b1.set(b2);
   
      System.out.println("2:");
      
      //! b2.set(aa);
      //! b2.set(ab1)
      //! b2.set(ab2);
      //! b2.set(b1);
      b2.set(b2);
   
      System.out.println("3:");
      
      aa.set(aa);
      aa.set(ab1);
      aa.set(ab2);
      aa.set(b1);
      aa.set(b2);
   
      System.out.println("4:");
      
      //! ab1.set(aa);
      //! ab1.set(ab1);
      //! ab1.set(ab2);
      ab1.set(b1);
      //! ab1.set(b2);
   
      System.out.println("5:");
      
      //! ab2.set(aa);
      //! ab2.set(ab1);
      //! ab2.set(ab2);
      //! ab2.set(b1);
      ab2.set(b2);
   
      System.out.println("6:");
   
      b1.set(aa);
      b1.set(ab1);
      b1.set(ab2);
      b1.set(b1);
      b1.set(b2);
   
      System.out.println("7:");
   
      //! b2.set(aa);
      //! b2.set(ab1);
      //! b2.set(ab2);
      //! b2.set(b1);
      b2.set(b2);
   
      aa = b1;
      //! ab1 = b1;
      //! ab2 = b1;
      //! aa = b2;
      //! ab1 = b2;
      ab2 = b2;
   
      System.out.println("8:");
   
      aa.set(aa);
      aa.set(ab1);
      aa.set(ab2);
      aa.set(b1);
      aa.set(b2);
   
      System.out.println("9:");
   
      //! ab2.set(aa);
      //! ab2.set(ab1);
      //! ab2.set(ab2);
      //! ab2.set(b1);
      ab2.set(b2); // Bridge method set(My02A a) in My02_B2 class allows polymorphism
   }
}
