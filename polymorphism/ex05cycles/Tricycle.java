package biz.markov.thinking.polymorphism.ex05cycles;

public class Tricycle extends Cycle {
    private static int numWheels = 3;

    public int wheels() {
        return numWheels;
    }

    public void ride() {
        System.out.println("Tricycle with " + wheels() + " wheels riding");
    }
}
