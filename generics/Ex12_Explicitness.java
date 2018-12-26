/****************** Exercise 12 *****************
 * Repeat the previous exercise using explicit type
 * specification.
 ************************************************/
package biz.markov.thinking.generics;

import net.mindview.util.New;
import java.util.List;

public class Ex12_Explicitness {
   private static Ex08_CharacterGenerator gen = new Ex08_CharacterGenerator();
   
   public static void test(List<StoryCharacter> list) {
      for (int i = 0; i < 10; i++)
         list.add(gen.next());
      System.out.println(list);
   }
   
   public static void main(String[] args) {
      test(New.<StoryCharacter>list());
   }
}
