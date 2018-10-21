package biz.markov.thinking.innerclasses;

public class Ex07 {
    private char ch = '%';

    private void encode() {
        System.out.println("incrementing");
        ch++;
    }

    class Ex07_Inner {
        void access() {
            System.out.println("Initial value: " + ch);
            System.out.println("adding");
            Ex07.this.ch += 5;

            Ex07.this.encode();

            System.out.println("Result: " + ch);
        }
    }

    public static void main(String[] args) {
        Ex07 outer = new Ex07();
        Ex07_Inner inner = outer.new Ex07_Inner();
        inner.access();
    }
}
