/****************** Exercise 5 ******************
 * Implement a rotate(Shape) method in Shapes.java,
 * such that it checks to see if it is rotating a
 * Circle (and, if so, doesn’t perform the
 * operation).
 ***********************************************/
package biz.markov.thinking.typeinfo;

import java.util.*;

public class Ex05_Rotate {
   public static void rotate(Shape sh) {
      if (sh.getClass() == Circle.class)
         System.out.println("Circle!");
      else
         System.out.println("Rotating " + sh);
   }
   
   public static void main(String[] args) {
      List<Shape> shapeList = Arrays.asList(
         new Circle(), new Square(), new Triangle(), new Rhomboid()
      );
      
      for(Shape shape : shapeList)
         rotate(shape);
   }
}
