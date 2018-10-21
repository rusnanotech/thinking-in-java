package biz.markov.thinking.innerclasses;

public class Ex07 {
    private char ch = '%';

    private void encode() {
        System.out.println("incrementing");
        ch++;
    }

    class Ex07_Inner {
        Ex07 outer;

        Ex07_Inner(Ex07 outer) {
            this.outer = outer;
        }

        void access() {
            System.out.println("Initial value: " + ch);
            System.out.println("adding");
            outer.ch += 5;

            outer.encode();

            System.out.println("Result: " + ch);
        }
    }

    public static void main(String[] args) {
        Ex07 outer = new Ex07();
        Ex07_Inner inner = outer.new Ex07_Inner(outer);
        inner.access();
    }
}
