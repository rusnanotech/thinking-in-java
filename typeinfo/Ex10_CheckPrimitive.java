/****************** Exercise 10 *****************
 * Write a program to determine whether an array
 * of char is a primitive type or a true object.
 ***********************************************/
package biz.markov.thinking.typeinfo;

public class Ex10_CheckPrimitive {
   public static void main(String[] args) {
      char[] a = new char[1];
      
      Ex08_Hierarchy.up(a.getClass());
   }
}
/* Output:
class [C
class java.lang.Object
 */
