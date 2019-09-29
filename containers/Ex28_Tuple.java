package biz.markov.thinking.containers;

public class Ex28_Tuple {

    public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<A, B>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<A, B, C>(a, b, c);
    }

    public static <A, B, C, D> FourTuple<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new FourTuple<A, B, C, D>(a, b, c, d);
    }

    public static <A, B, C, D, E> FiveTuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new FiveTuple<A, B, C, D, E>(a, b, c, d, e);
    }

    public static class TwoTuple<A, B> {
        public final A first;
        public final B second;

        public TwoTuple(A a, B b) {
            this.first = a;
            this.second = b;
        }

        @Override
        public int hashCode() {
            int result = 31;
            result = result * 37 + first.hashCode();
            result = result * 37 + second.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof TwoTuple
                    && ((TwoTuple) obj).first.equals(first)
                    && ((TwoTuple) obj).second.equals(second);
        }

        @Override
        public String toString() {
            return "(" + this.first + ", " + this.second + ")";
        }
    }

    public static class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
        public final C third;

        public ThreeTuple(A a, B b, C c) {
            super(a, b);
            this.third = c;
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = result * 37 + third.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof ThreeTuple
                    && ((ThreeTuple) obj).first.equals(first)
                    && ((ThreeTuple) obj).second.equals(second)
                    && ((ThreeTuple) obj).third.equals(second);
        }

        @Override
        public String toString() {
            return "(" + this.first + ", " + this.second + ", " + this.third + ")";
        }
    }

    public static class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
        public final D fourth;

        public FourTuple(A a, B b, C c, D d) {
            super(a, b, c);
            this.fourth = d;
        }

        public String toString() {
            return "(" + this.first + ", " + this.second + ", " + this.third + ", " + this.fourth + ")";
        }
    }

    public static class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
        public final E fifth;

        public FiveTuple(A a, B b, C c, D d, E e) {
            super(a, b, c, d);
            this.fifth = e;
        }

        public String toString() {
            return "(" + this.first + ", " + this.second + ", " + this.third + ", " + this.fourth + ", " + this.fifth + ")";
        }
    }
}
