package exercises.initialization;

class Ex05_Dog {
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
}

//,
public class Ex05_Overloading {
    public static void main(String args[]) {
        byte b = 1;
        Ex05_Dog.bark();
        Ex05_Dog.bark(b);
        Ex05_Dog.bark((char) b);
        Ex05_Dog.bark((short) b);
        Ex05_Dog.bark((int) b);
        Ex05_Dog.bark((long) b);
        Ex05_Dog.bark((float) b);
        Ex05_Dog.bark((double) b);
    }
}
