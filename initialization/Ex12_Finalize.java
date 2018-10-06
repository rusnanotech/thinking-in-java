package exercises.initialization;

class Ex12_Tank {
    static int numOfTanks = 0;
    int tankId = ++numOfTanks;
    float volume;

    Ex12_Tank() {
        volume = 0.0f;
        msg();
    }
    Ex12_Tank(float x) {
        volume = x;
        msg();
    }

    private void msg() {
        System.out.println("Tank " + tankId + " of volume " + volume + " created");
    }

    boolean isEmpty() {
        return volume == 0.0;
    }

    protected void finalize() {
        if (isEmpty()) {
            System.out.println("Unused tank " + tankId + " (" + volume + ") cleared");
            volume = 0.0f;
        }
    }
}

public class Ex12_Finalize {
    public static void main(String args[]) {
        Ex12_Tank t1 = new Ex12_Tank();
        Ex12_Tank t2 = new Ex12_Tank(23.8f);
        Ex12_Tank t3 = new Ex12_Tank(0.6f);
        t1 = t2 = t3;
        System.gc();    // Clears tank t2
        System.runFinalization();
    }
}
