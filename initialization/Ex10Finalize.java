package exercises.initialization;

public class Ex10Finalize {
    protected void finalize() {
        System.out.println("Finalized"); // Not printed in output
    }
    public static void main(String args[]) {
        new Ex10Finalize();
    }
}
