/****************** Exercise 8 ******************
 * Modify Exercise 1 so it uses an Iterator to
 * move through the List while calling hop().
 ***********************************************/
package biz.markov.thinking.holding;

import java.util.*;

public class Ex08_Iterator {
    public static void main(String[] args) {
        ArrayList<Ex01_Gerbil> gerbils = new ArrayList<Ex01_Gerbil>();

        for (int i = 0; i < 8; i++)
            gerbils.add(new Ex01_Gerbil());

        Iterator<Ex01_Gerbil> itr = gerbils.iterator();
        while (itr.hasNext()) {
            itr.next().hop();
        }
    }
}