package biz.markov.thinking.generics;

import net.mindview.thinking.generics.coffee.*;

class Decorator extends Coffee {
   protected Coffee coffee;
   
   Decorator(Coffee coffee) {
      this.coffee = coffee;
   }
}

class WithSteamedMilk extends Decorator {
   WithSteamedMilk(Coffee coffee) {
      super(coffee);
   }
   
   public String toString() {
      return coffee + " with steamed milk";
   }
}

class WithFoam extends Decorator {
   WithFoam(Coffee coffee) {
      super(coffee);
   }
   
   public String toString() {
      return coffee + " with foam";
   }
}

class WithChocolate extends Decorator {
   WithChocolate(Coffee coffee) {
      super(coffee);
   }
   
   public String toString() {
      return coffee + " with chocolate";
   }
}

class WithCaramel extends Decorator {
   WithCaramel(Coffee coffee) {
      super(coffee);
   }
   
   public String toString() {
      return coffee + " with caramel";
   }
}

class WithWhippedCream extends Decorator {
   WithWhippedCream(Coffee coffee) {
      super(coffee);
   }
   
   public String toString() {
      return coffee + " with whipped cream";
   }
}

public class Ex38_Decoration {
   public static void main(String[] args) {
      CoffeeGenerator gen = new CoffeeGenerator();
      WithSteamedMilk withSteamedMilk = new WithSteamedMilk(gen.next());
      WithFoam withFoam = new WithFoam(gen.next());
      WithChocolate withChocolate = new WithChocolate(gen.next());
      WithCaramel withCaramel = new WithCaramel(gen.next());
      WithWhippedCream withWhippedCream = new WithWhippedCream(gen.next());
   
      System.out.println(withSteamedMilk);
      System.out.println(withFoam);
      System.out.println(withChocolate);
      System.out.println(withCaramel);
      System.out.println(withWhippedCream);
   }
}
