/****************** Exercise 15 *****************
 * Modify ContainerComparison.java by creating a
 * Generator for BerylliumSphere, and change main()
 * to use that Generator with Generated.array().
 ************************************************/
package biz.markov.thinking.arrays;

import biz.markov.thinking.util.tij.BerylliumSphere;
import net.mindview.util.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static net.mindview.util.Print.print;

public class Ex15_ContainerComparison {
   public static void main(String[] args) {
      BerylliumSphere[] spheres = new BerylliumSphere[10];
      Generated.array(spheres, new BerylliumSphere.Generator());
      print(Arrays.toString(spheres));
      print(spheres[4]);
      
      List<BerylliumSphere> sphereList =
         new ArrayList<BerylliumSphere>(
            Arrays.asList(
               Generated.array(
                  new BerylliumSphere[5], new BerylliumSphere.Generator())));
      print(sphereList);
      print(sphereList.get(4));
   }
}
