/****************** Exercise 7 ******************
 * Modify SweetShop.java so that each type of
 * object creation is controlled by a
 * command-line argument. That is, if your
 * command line is "java SweetShop Candy," then
 * only the Candy object is created. Notice how
 * you can control which Class objects are loaded
 * via the command-line argument.
 ***********************************************/
package biz.markov.thinking.typeinfo;

import static net.mindview.util.Print.print;

class Candy {
   static {
      print("Loading Candy");
   }
}

class Gum {
   static {
      print("Loading Gum");
   }
}

class Cookie {
   static {
      print("Loading Cookie");
   }
}

public class Ex07_SweetShop {
   public static void main(String[] args) throws Exception {
      if (args.length == 0) {
         System.out.println("Usage: java Ex07_SweetShop classname");
         System.exit(0);
      }
      
      for (String arg : args) {
         try {
            Class.forName(arg).newInstance();
         } catch (ClassNotFoundException e) {
            print("Couldn't find " + arg);
         }
      }
   }
}
