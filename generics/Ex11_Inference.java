/****************** Exercise 11 *****************
 * Test New.java by creating your own classes and
 * ensuring that New will work properly with them.
 ************************************************/
package biz.markov.thinking.generics;

import net.mindview.util.New;
import java.util.List;

public class Ex11_Inference {
   public static void main(String[] args) {
      Ex08_CharacterGenerator gen = new Ex08_CharacterGenerator();
      List<StoryCharacter> characters = New.list();
   
      for (int i = 0; i < 10; i++)
         characters.add(gen.next());
   
      System.out.println(characters);
   }
}
