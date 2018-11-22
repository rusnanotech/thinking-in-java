/********************** Exercise 16 *********************
 * Modify JGrep.java to accept a directory name or a file
 * name as argument (if a directory is provided, search
 * should include all files in the directory).
 * Hint: you can generate a list of filenames with
 * File[] files = new File(".").listFiles();
 ********************************************************/

package biz.markov.thinking.strings;

import net.mindview.util.TextFile;
import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Ex16_JGrep {
   private File[] files;
   private Pattern pattern;
   private int group;
   
   public Ex16_JGrep(String path, String pattern) {
      this(path, pattern, 0);
   }
   
   public Ex16_JGrep(String path, String regex, int flag) {
      File f = new File(path);
      group = 0;
      
      if (f.isFile())
         files = new File[] { f };
      else if (f.isDirectory()) {
         files = f.listFiles();
         Arrays.sort(files);
      } else
         terminate();
   
      if (flag > 0)
         pattern = Pattern.compile(regex, flag);
      else
         pattern = Pattern.compile(regex);
   }
   
   private static void terminate() {
      System.out.println("Usage: java JGrep file|directory regex pattern");
      System.exit(0);
   }
   
   public void setGroup(int group) {
      this.group = group;
   }
   
   public void find() {
      // Iterate through the lines of the input files:
      Matcher m = pattern.matcher("");
      for (File file : files) {
         if (file.isDirectory())
            continue;
         
         int index = 1;
         boolean flag = true;
         for (String line : new TextFile(file.getAbsolutePath())) {
            m.reset(line);
            while (true) {
               if (m.find()) {
                  if (flag) {
                     System.out.println(file);
                     flag = false;
                  }
               } else
                  break;
               System.out.format("%3d:%2d:   %s\n", index, m.start(), m.group(group));
            }
            index++;
         }
      }
   }
   
   public static void main(String[] args) throws Exception {
      if(args.length < 2)
         terminate();
      
      int flag = 0;
      if (args[2].equals("UNIX_LINES"))
         flag = Pattern.UNIX_LINES;
      else if (args[2].equals("CASE_INSENSITIVE"))
         flag = Pattern.CASE_INSENSITIVE;
      else if (args[2].equals("COMMENTS"))
         flag = Pattern.COMMENTS;
      else if (args[2].equals("MULTILINE"))
         flag = Pattern.MULTILINE;
      else if (args[2].equals("LITERAL"))
         flag = Pattern.LITERAL;
      else if (args[2].equals("DOTALL"))
         flag = Pattern.DOTALL;
      else if (args[2].equals("UNICODE_CASE"))
         flag = Pattern.UNICODE_CASE;
      else if (args[2].equals("CANON_EQ"))
         flag = Pattern.CANON_EQ;
      
      new Ex16_JGrep(args[0], args[1], flag).find();
   }
}
