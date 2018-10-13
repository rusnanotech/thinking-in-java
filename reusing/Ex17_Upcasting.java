package biz.markov.thinking.reusing;

class Ex17_Amphibian {
    private int i;

    Ex17_Amphibian(int i) {
        System.out.println("Initializing new Amphibian object " + i);
        this.i = i;
    }

    void swim() {
        System.out.println("Amphibian swimming " + i);
    }

    void walk() {
        System.out.println("Amphibian walking " + i);
    }

    static void move(Ex17_Amphibian a) {
        a.swim();
        a.walk();
    }
}

class Ex17_Frog extends Ex17_Amphibian {
    Ex17_Frog(int i) {
        super(i);
        System.out.println("Initializing new Frog object " + i);
    }

    void swim() {
        System.out.println("Frog swimming ");
    }

    void walk() {
        System.out.println("Frog walking ");
    }
}

public class Ex17_Upcasting {
    public static void main(String args[]) {
        Ex17_Frog a = new Ex17_Frog(17);

        Ex17_Amphibian.move(a);
    }
}

/*
Initializing new Amphibian object 17
Initializing new Frog object 17
Frog swimming
Frog walking
 */
