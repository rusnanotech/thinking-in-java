/****************** Exercise 16 ******************
 * Use anonymous inner classes to modify the
 * solution to Exercise 18 from the Interfaces chapter.
 ***********************************************/
package biz.markov.thinking.innerclasses;

import biz.markov.thinking.interfaces.cycles.*;

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle2 extends Unicycle {
    private Unicycle2() {}

    public static CycleFactory factory = new CycleFactory() {
        public Unicycle2 getCycle() {
            return new Unicycle2();
        }
    };
}

class Bicycle2 extends Bicycle {
    private Bicycle2() {}

    public static CycleFactory factory = new CycleFactory() {
        public Bicycle2 getCycle() {
            return new Bicycle2();
        }
    };
}

class Tricycle2 extends Tricycle {
    private Tricycle2() {}

    public static CycleFactory factory = new CycleFactory() {
        public Tricycle2 getCycle() {
            return new Tricycle2();
        }
    };
}

public class Ex16_FactoryMethodPattern {
    static void rideCycle(CycleFactory cf) {
        Cycle c = cf.getCycle();
        c.ride();
    }

    public static void main(String[] args) {
        rideCycle(Unicycle2.factory);
        rideCycle(Bicycle2.factory);
        rideCycle(Tricycle2.factory);
    }
}
