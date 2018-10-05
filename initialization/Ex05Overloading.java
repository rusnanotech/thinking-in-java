package exercises.initialization;

class Ex05Dog {
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
public class Ex05Overloading {
    public static void main(String args[]) {
        byte b = 1;
        Ex05Dog.bark();
        Ex05Dog.bark(b);
        Ex05Dog.bark((char) b);
        Ex05Dog.bark((short) b);
        Ex05Dog.bark((int) b);
        Ex05Dog.bark((long) b);
        Ex05Dog.bark((float) b);
        Ex05Dog.bark((double) b);
    }
}
