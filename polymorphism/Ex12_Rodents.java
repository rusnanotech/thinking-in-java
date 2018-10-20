/****************** Exercise 12 *****************
 * Modify Exercise 9 so it demonstrates the
 * order of initialization of the base classes
 * and derived classes. Now add member objects to
 * both the base and derived classes, and show
 * the order in which their initialization occurs
 * during construction.
 ***********************************************/
package biz.markov.thinking.polymorphism;

class Ex12_Gene {
    Ex12_Gene(String s) {
        System.out.println(s + " gene");
    }
}

class Ex12_Rodent {
    Ex12_Gene gene = new Ex12_Gene("Rodent");

    Ex12_Rodent() {
        System.out.println("Rodent");
    }

    public String toString () {
        return "Rodent";
    }
}

class Ex12_Hamster extends Ex12_Rodent {
    Ex12_Gene gene = new Ex12_Gene("Hamster");

    Ex12_Hamster() {
        System.out.println("Hamster");
    }

    public String toString () {
        return "Hamster";
    }
}

class Ex12_Mouse extends Ex12_Rodent {
    Ex12_Gene gene = new Ex12_Gene("Mouse");

    Ex12_Mouse() {
        System.out.println("Mouse");
    }

    public String toString () {
        return "Mouse";
    }
}

class Ex12_Gerbil extends Ex12_Mouse {
    Ex12_Gene gene = new Ex12_Gene("Gerbil");

    Ex12_Gerbil() {
        System.out.println("Gerbil");
    }

    public String toString () {
        return "Gerbil";
    }
}

public class Ex12_Rodents {
    public static void main(String args[]) {
        Class<?>[] rodents = {
                Ex12_Rodent.class,
                Ex12_Hamster.class,
                Ex12_Mouse.class,
                Ex12_Gerbil.class,
        };

        for (Class<?> rodent : rodents) {
            try {
                rodent.newInstance();
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException("Cannot Create", e);
            }
        }
    }
}
