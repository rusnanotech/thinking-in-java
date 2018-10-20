package biz.markov.thinking.interfaces;

import biz.markov.thinking.interfaces.cycles.*;

class My02_Cycles {
    void rideCycle(Cycle c) {
        c.ride();
    }
}

public class My02_Ex18_WithoutFactory {
    public static void main(String[] args) {
        My02_Cycles c = new My02_Cycles();

        c.rideCycle(new Unicycle());
        c.rideCycle(new Bicycle());
        c.rideCycle(new Tricycle());
    }
}
