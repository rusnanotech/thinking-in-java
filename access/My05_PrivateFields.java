package biz.markov.thinking.access;

class My05_Object {
    private static long counter = 1;
    private final long id = counter++;

    public void f(My05_Object obj) {
        System.out.print(obj.getClass().getSimpleName());
        System.out.println(" " + obj.id);
    }
}

public class My05_PrivateFields {
    public void f(My05_Object obj) {
        System.out.print(obj.getClass().getSimpleName());
        //! System.out.println(" " + obj.id);
    }

    public static void main(String[] args) {
        My05_Object o1 = new My05_Object();
        My05_Object o2 = new My05_Object();

        o1.f(o2);
        o2.f(o1);
    }
}