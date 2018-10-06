package exercises.initialization;

public class Ex11_Finalize {
    protected void finalize() {
        System.out.println("Finalized"); // Printed in output
    }
    public static void main(String args[]) {
        new Ex11_Finalize();
        System.gc();
        System.runFinalization();
    }
}
