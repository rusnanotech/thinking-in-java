/****************** Exercise 26 ******************
 * Change the file name string in MainException.java to
 * name a file that doesn't exist. Run the program and
 * note the result
 ************************************************/
package biz.markov.thinking.exceptions;

import java.io.*;

public class Ex26_MainException {
   // Pass all exceptions to the console:
   public static void main(String[] args) throws Exception {
      // Open the file:
      FileInputStream file =
         new FileInputStream("MainException.java");
      // Use the file ...
      // Close the file:
      file.close();
   }
}
