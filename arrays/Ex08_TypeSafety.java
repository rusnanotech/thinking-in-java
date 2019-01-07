/****************** Exercise 8 *****************
 * "Erasure gets in the way again—this example
 * attempts to create arrays of types that have been
 * erased, and are thus unknown types. Notice that
 * you can create an array of Object, and cast it,
 * but you get an “unchecked” warning at compile
 * time because the array doesn’t really hold or
 * dynamically check for type T. That is, if I create
 * a String[], Java will enforce at both compile time
 * and run time that I can only place String objects
 * in that array. However, if I create an Object[],
 * I can put anything except primitive types in that
 * array."
 *
 * Demonstrate the assertions in the previous
 * paragraph.
 ***********************************************/
package biz.markov.thinking.arrays;

import biz.markov.thinking.arrays.libs.BerylliumSphere;

public class Ex08_TypeSafety {
   public static void main(String[] args) {
      String[] strings = new String[9];
      
      // Compile-time checking:
      
      //! strings[0] = new Object();
      //! strings[0] = 51;
      Object o = strings[0];
      //! Double d = strings[0];
      //! strings = new Object[9];
      
      Object[] objects = strings;
      
      // Run-time checking:
      
      try {
         objects[0] = new Object(); // real type of array is String[]
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      
      try {
         objects[0] = 51; // real type of array is String[]
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      
      // Object[] can hold anything except primitive types:
      
      objects = new Object[9];
      
      objects[0] = "abc";
      objects[1] = 7; // autoboxing
      objects[2] = new BerylliumSphere();
      objects = new BerylliumSphere[5];
      //! objects = new char[6]; // can not hold primitive types
   }
}
