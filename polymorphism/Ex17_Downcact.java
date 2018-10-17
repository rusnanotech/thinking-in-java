package biz.markov.thinking.polymorphism;

import biz.markov.thinking.polymorphism.ex01cycles.Cycle;
import biz.markov.thinking.polymorphism.ex01cycles.Tricycle;
import biz.markov.thinking.polymorphism.ex17cycles.*;

public class Ex17_Downcact {
    public static void main(String args[]) {
        Cycle[] cycles = {
                new UnicycleBalanced(),
                new BicycleBalanced(),
                new Tricycle()
        };

        //! for (Cycle cycle : cycles)
            //! cycle.balance();

        ((UnicycleBalanced)cycles[0]).balance();
        ((BicycleBalanced)cycles[1]).balance();
        //! ((Tricycle)cycles[1]).balance();
    }
}
