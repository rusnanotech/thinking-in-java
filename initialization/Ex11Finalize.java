package exercises.initialization;

public class Ex11Finalize {
    protected void finalize() {
        System.out.println("Finalized"); // Printed in output
    }
    public static void main(String args[]) {
        new Ex11Finalize();
        System.gc();
        System.runFinalization();
    }
}
