package biz.markov.thinking.polymorphism.ex05cycles;

public class Cycle extends
             biz.markov.thinking.polymorphism.ex01cycles.Cycle {
    private static int numWheels = 0;

    public int wheels() {
        return numWheels;
    }
}
