/****************** Exercise 4 ******************
 * Modify the previous exercise so that it uses
 * instanceof to check the type before performing
 * the downcast.
 ***********************************************/
package biz.markov.thinking.typeinfo;

import java.util.*;

public class Ex04_Shapes {
   public static void main(String[] args) {
      List<Shape> shapeList = Arrays.asList(
         new Circle(), new Square(), new Triangle(), new Rhomboid()
      );
      for(Shape shape : shapeList)
         shape.draw();
   
      if (shapeList.get(3) instanceof Rhomboid)
         ((Rhomboid) shapeList.get(3)).draw();
      else
         System.out.println("Downcast is not allowed");
      
      if (shapeList.get(3) instanceof Circle)
         ((Circle) shapeList.get(3)).draw();
      else
         System.out.println("Downcast is not allowed");
   }
}
