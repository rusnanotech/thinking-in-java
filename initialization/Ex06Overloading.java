package exercises.initialization;

class Ex06Dog {
    public static void bark() {
        System.out.println("Sleeping");
    }
    public static void bark(byte x) {
        System.out.println("Squeaking");
    }
    public static void bark(char x) {
        System.out.println("Tugging");
    }
    public static void bark(short x) {
        System.out.println("Snoring");
    }
    public static void bark(int x) {
        System.out.println("Growling");
    }
    public static void bark(long x) {
        System.out.println("Barking");
    }
    public static void bark(float x) {
        System.out.println("Yelping");
    }
    public static void bark(double x) {
        System.out.println("Howling");
    }
    public static void bark(long x, double y) {
        System.out.println("Barking and howling");
    }
    public static void bark(double x, long y) {
        System.out.println("Howling and barking");
    }
}

//,
public class Ex06Overloading {

    public static void main(String args[]) {
        byte b = 1;
        Ex06Dog.bark();
        Ex06Dog.bark(b);
        Ex06Dog.bark((char) b);
        Ex06Dog.bark((short) b);
        Ex06Dog.bark((int) b);
        Ex06Dog.bark((long) b);
        Ex06Dog.bark((float) b);
        Ex06Dog.bark((double) b);
        Ex06Dog.bark((double) b, (long) b);
        Ex06Dog.bark((long) b, (double) b);
    }
}
