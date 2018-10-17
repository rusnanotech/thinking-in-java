package biz.markov.thinking.polymorphism;

class Ex14_Sequence {
    private static long counter = 0;
    private final long id = ++counter;
    private int refCounter = 0;

    public Ex14_Sequence() {
        System.out.println("Creating sequence " + id);
    }

    void addRef() {
        refCounter++;
    }

    protected void dispose() {
        if (--refCounter == 0)
            System.out.println("Disposing sequence " + id);
    }
}

class Ex14_Gene {
    private Ex14_Sequence sequence;
    private static long counter = 0;
    private final long id = ++counter;

    public Ex14_Gene(Ex14_Sequence sequence) {
        System.out.println("Creating gene " + id);
        this.sequence = sequence;
        sequence.addRef();
    }

    protected void dispose() {
        System.out.println("Disposing gene " + id);
        sequence.dispose();
    }
}

class Ex14_Rodent {
    Ex14_Gene gene1;
    Ex14_Gene gene2;
    Ex14_Gene gene3;

    Ex14_Rodent() {
        System.out.println("Creating rodent");

        Ex14_Sequence sequence = new Ex14_Sequence();

        gene1 = new Ex14_Gene(sequence);
        gene2 = new Ex14_Gene(sequence);
        gene3 = new Ex14_Gene(sequence);
    }

    public String toString () {
        return "Rodent";
    }

    protected void dispose() {
        System.out.println("Disposing rodent");
        gene3.dispose();
        gene2.dispose();
        gene1.dispose();
    }
}

class Ex14_Hamster extends Ex14_Rodent {
    Ex14_Gene gene1;
    Ex14_Gene gene2;
    Ex14_Gene gene3;

    Ex14_Hamster() {
        System.out.println("Creating hamster");

        Ex14_Sequence sequence = new Ex14_Sequence();

        gene1 = new Ex14_Gene(sequence);
        gene2 = new Ex14_Gene(sequence);
        gene3 = new Ex14_Gene(sequence);
    }

    public String toString () {
        return "Hamster";
    }

    protected void dispose() {
        System.out.println("Disposing hamster");
        gene3.dispose();
        gene2.dispose();
        gene1.dispose();
        super.dispose();
    }
}

class Ex14_Mouse extends Ex14_Rodent {
    Ex14_Gene gene1;
    Ex14_Gene gene2;
    Ex14_Gene gene3;

    Ex14_Mouse() {
        System.out.println("Creating mouse");

        Ex14_Sequence sequence = new Ex14_Sequence();

        gene1 = new Ex14_Gene(sequence);
        gene2 = new Ex14_Gene(sequence);
        gene3 = new Ex14_Gene(sequence);
    }

    public String toString () {
        return "Mouse";
    }

    protected void dispose() {
        System.out.println("Disposing mouse");
        gene3.dispose();
        gene2.dispose();
        gene1.dispose();
        super.dispose();
    }
}

class Ex14_Gerbil extends Ex14_Mouse {
    Ex14_Gene gene1;
    Ex14_Gene gene2;
    Ex14_Gene gene3;

    Ex14_Gerbil() {
        System.out.println("Creating gerbil");

        Ex14_Sequence sequence = new Ex14_Sequence();

        gene1 = new Ex14_Gene(sequence);
        gene2 = new Ex14_Gene(sequence);
        gene3 = new Ex14_Gene(sequence);
    }

    public String toString () {
        return "Gerbil";
    }

    protected void dispose() {
        System.out.println("Disposing gerbil");
        gene3.dispose();
        gene2.dispose();
        gene1.dispose();
        super.dispose();
    }
}

public class Ex14_Rodents {
    public static void main(String args[]) {
        Class<?>[] rodentClasses = {
                Ex14_Rodent.class,
                Ex14_Hamster.class,
                Ex14_Mouse.class,
                Ex14_Gerbil.class,
        };

        Ex14_Rodent[] rodents = new Ex14_Rodent[rodentClasses.length];

        for (int i = 0; i < rodents.length; i++) {
            try {
                rodents[i] = (Ex14_Rodent) rodentClasses[i].newInstance();
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException("Cannot Create", e);
            }
        }

        for (int i = rodents.length - 1; i >= 0; i--) {
            rodents[i].dispose();
            System.out.println();
        }
    }
}
