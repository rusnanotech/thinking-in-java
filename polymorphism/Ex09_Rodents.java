package biz.markov.thinking.polymorphism;

class Rodent {
    public String toString () {
        return "Rodent";
    }
}

class Hamster extends Rodent {
    public String toString () {
        return "Hamster";
    }
}

class Mouse extends Rodent {
    public String toString () {
        return "Mouse";
    }
}

class Gerbil extends Mouse {
    public String toString () {
        return "Gerbil";
    }
}

public class Ex09_Rodents {
    public static void main(String args[]) {
        Rodent[] rodents = { new Rodent(), new Hamster(), new Mouse(), new Gerbil(), };

        for (Rodent rodent : rodents)
            System.out.println(rodent);
    }
}
