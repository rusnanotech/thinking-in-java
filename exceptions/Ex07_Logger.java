/****************** Exercise 7 ******************
 * Modify Exercise 3 so that the catch clause logs
 * the results.
 ***********************************************/
package biz.markov.thinking.exceptions;

import java.util.logging.*;
import java.io.*;

public class Ex07_Logger {
   public Ex07_Logger(Exception e) {
      StringWriter trace = new StringWriter();
      e.printStackTrace(new PrintWriter(trace));
      logger.severe(trace.toString());
   }
   
   private static Logger logger = Logger.getLogger("Logger 1");
   
   public static void main(String[] args) {
      int[] a = { 1, 3, 8, };
      
      try {
         int k = a[a.length];
      } catch (ArrayIndexOutOfBoundsException e) {
         new Ex07_Logger(e);
      }
   }
}
