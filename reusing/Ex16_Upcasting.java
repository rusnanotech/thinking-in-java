package biz.markov.thinking.reusing;

class Ex16_Amphibian {
    private int i;

    Ex16_Amphibian(int i) {
        System.out.println("Initializing new Amphibian object " + i);
        this.i = i;
    }

    void swim() {
        System.out.println("Amphibian swimming " + i);
    }

    void walk() {
        System.out.println("Amphibian walking " + i);
    }

    static void move(Ex16_Amphibian a) {
        a.swim();
        a.walk();
    }
}

class Ex16_Frog extends Ex16_Amphibian {
    Ex16_Frog(int i) {
        super(i);
        System.out.println("Initializing new Frog object " + i);
    }
}

public class Ex16_Upcasting {
    public static void main(String args[]) {
        Ex16_Frog a = new Ex16_Frog(17);

        Ex16_Amphibian.move(a);
    }
}
