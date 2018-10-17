package biz.markov.thinking.polymorphism.ex05cycles;

public class Bicycle extends Cycle {
    private static int numWheels = 2;

    public int wheels() {
        return numWheels;
    }

    public void ride() {
        System.out.println("Bicycle with " + wheels() + " wheels riding");
    }
}
