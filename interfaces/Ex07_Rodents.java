/****************** Exercise 7 ******************
 * Change Rodent to an interface in Exercise 9 of
 * the Polymorphism chapter.
 ***********************************************/
package biz.markov.thinking.interfaces;

interface Ex07_Rodent {
    String what();
}

class Ex07_Hamster implements Ex07_Rodent {
    public String what() {
        return "Hamster";
    }
}

class Ex07_Mouse implements Ex07_Rodent {
    public String what() {
        return "Mouse";
    }
}

class Ex07_Gerbil extends Ex07_Mouse {
    public String what() {
        return "Gerbil";
    }
}

public class Ex07_Rodents {
    public static void main(String args[]) {
        Ex07_Rodent[] rodents = { new Ex07_Hamster(), new Ex07_Mouse(), new Ex07_Gerbil(), };

        for (Ex07_Rodent rodent : rodents)
            System.out.println(rodent.what());
    }
}
