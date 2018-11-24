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
   
   public Ex16_JGrep(String pattern) {
      this(pattern, 0);
   }
   
   public Ex16_JGrep(String regex, int flag) {
      group = 0;
      
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
   
   public void process(String path) {
      File f = new File(path);
      
      if (f.isFile())
         files = new File[] { f };
      else if (f.isDirectory()) {
         files = f.listFiles();
         Arrays.sort(files);
      } else
         terminate();
   
      // Iterate through the lines of the input files:
      Matcher m = pattern.matcher("");
      int total = 0;
      for (File file : files) {
         if (file.isDirectory())
            continue;
         
         int index = 1;
         int count = 0;
         boolean flag = true;
         for (String line : new TextFile(file.getAbsolutePath())) {
            m.reset(line);
            while (true) {
               if (m.find()) {
                  count++;
                  if (flag) {
                     System.out.format("\n%s\n", file);
                     flag = false;
                  }
                  System.out.format("%3d:%2d:   %s\n",
                     index, m.start()+1, m.group(group) == null ? "" : m.group(group));
               } else
                  break;
            }
            index++;
         }
         total += count;
         if (count > 0)
            System.out.println("-------------------\nmatches in file: " + count);
      }
      System.out.println("\nTotal of matches: " + total);
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
      
      new Ex16_JGrep(args[1], flag).process(args[0]);
   }
}
