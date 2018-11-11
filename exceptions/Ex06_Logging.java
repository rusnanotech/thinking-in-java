/****************** Exercise 6 ******************
 * Create two exception classes, each of which
 * performs its own logging automatically.
 * Demonstrate that these work.
 ***********************************************/
package biz.markov.thinking.exceptions;

import java.util.logging.*;
import java.io.*;

class Ex06_Exeption1 extends Exception {
   public Ex06_Exeption1(String msg) {
      super(msg);
      StringWriter trace = new StringWriter();
      printStackTrace(new PrintWriter(trace));
      logger.severe(trace.toString());
   }
   
   private static Logger logger = Logger.getLogger("Logger 1");
}

class Ex06_Exception2 extends Exception {
   public Ex06_Exception2(String msg) {
      super(msg);
      StringWriter trace = new StringWriter();
      printStackTrace(new PrintWriter(trace));
      logger.severe(trace.toString());
   }
   
   private static Logger logger = Logger.getLogger("Logger 2");
}

public class Ex06_Logging {
   public static void main(String[] args) {
      try {
         System.err.println("Throwing Exception 1");
         throw new Ex06_Exeption1("Exception 1");
      } catch (Ex06_Exeption1 e) {
         System.err.println("Catching Exception 1");
         System.err.println(e);
      }
   
      try {
         System.err.println("Throwing Exception 2");
         throw new Ex06_Exception2("Exception 2");
      } catch (Ex06_Exception2 e) {
         System.err.println("Catching Exception 2");
         System.err.println(e);
      }
   }
}
