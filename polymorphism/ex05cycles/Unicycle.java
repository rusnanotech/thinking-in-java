package biz.markov.thinking.polymorphism.ex05cycles;

public class Unicycle extends Cycle {
    private static int numWheels = 1;

    public int wheels() {
        return numWheels;
    }

    public void ride() {
        System.out.println("Unicycle with " + wheels() + " wheel riding");
    }
}
