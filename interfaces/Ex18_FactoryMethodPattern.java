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

public class Ex18_FactoryMethodPattern {
    static void rideCycle(CycleFactory cf) {
        Cycle c = cf.getCycle();
        c.ride();
    }

    public static void main(String[] args) {
        rideCycle(new UnicycleFactory());
        rideCycle(new BicycleFactory());
        rideCycle(new TricycleFactory());
    }
}
