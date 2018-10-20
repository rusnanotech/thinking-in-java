/****************** Exercise 18 ******************
 * Create a Cycle interface, with implementations
 * Unicycle, Bicycle, and Tricycle. Create factories
 * for each type of Cycle, and code that uses
 * these factories.
 ***********************************************/
package biz.markov.thinking.interfaces;
import biz.markov.thinking.interfaces.cycles.*;

interface CycleFactory {
    Cycle getCycle();
}

class UnicycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class TricycleFactory implements CycleFactory {
    public Cycle getCycle() {
        return new Tricycle();
    }
}

class Cycles {
    void rideCycle(CycleFactory cf) {
        Cycle c = cf.getCycle();
        c.ride();
    }
}

public class Ex18_FactoryMethodPattern {
    public static void main(String[] args) {
        Cycles c = new Cycles();

        c.rideCycle(new UnicycleFactory());
        c.rideCycle(new BicycleFactory());
        c.rideCycle(new TricycleFactory());
    }
}
