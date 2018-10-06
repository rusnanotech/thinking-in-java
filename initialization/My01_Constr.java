package exercises.initialization;

public class My01_Constr {
    int a = 2;
    int b = 38;
    My01_Constr() {
        //! System.out.println("Constructor My01_Constr() started");
        this(3);
        System.out.println("Constructor My01_Constr() started");
        this.demo(50);
    }
    My01_Constr(int a) {
        this(8.4);
        System.out.println("Constructor My01_Constr(int a) started: " + this.a + " " + a);
    }
    My01_Constr(double a) {
        System.out.println("Constructor My01_Constr(double a) started: " + a);
    }
    void demo(int a) {
        int c = 9;
        System.out.print("'demo' method started: ");
        System.out.println("" + a + " " + this.a + " " + b + " " + c);
    }
    public static void main(String args[]) {
        new My01_Constr();
    }
}
