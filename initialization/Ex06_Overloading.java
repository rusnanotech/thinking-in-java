package biz.markov.thinking.initialization;

class Ex06_Dog {
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
public class Ex06_Overloading {

    public static void main(String args[]) {
        byte b = 1;
        Ex06_Dog.bark();
        Ex06_Dog.bark(b);
        Ex06_Dog.bark((char) b);
        Ex06_Dog.bark((short) b);
        Ex06_Dog.bark((int) b);
        Ex06_Dog.bark((long) b);
        Ex06_Dog.bark((float) b);
        Ex06_Dog.bark((double) b);
        Ex06_Dog.bark((double) b, (long) b);
        Ex06_Dog.bark((long) b, (double) b);
    }
}
