package biz.markov.thinking.containers;

import java.util.Map;

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
            int result = 1;
            result = result * 59 + (first == null ? 43 : first.hashCode());
            result = result * 59 + (second == null ? 43 : second.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = checkInstance(obj);

            if (result) {
                TwoTuple other = (TwoTuple) obj;

                if (this.first != null) {
                    result = this.first.equals(other.first);
                } else {
                    result = (this.first == other.first);
                }

                if (result) {
                    if (this.second != null) {
                        result = this.second.equals(other.second);
                    } else {
                        result = (this.second == other.second);
                    }
                }
            }

            return result;
        }

        private boolean checkInstance(Object obj) {
            return (obj != null) && (this.getClass() == obj.getClass());
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
            result = result * 59 + (third == null ? 43 : third.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = super.equals(obj);

            if (result) {
                ThreeTuple other = (ThreeTuple) obj;

                if (this.third != null) {
                    result = this.third.equals(other.third);
                } else {
                    result = (this.third == other.third);
                }
            }

            return result;
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

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = result * 59 + (fourth == null ? 43 : fourth.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = super.equals(obj);

            if (result) {
                FourTuple other = (FourTuple) obj;

                if (this.fourth != null) {
                    result = this.fourth.equals(other.fourth);
                } else {
                    result = (this.fourth == other.fourth);
                }
            }

            return result;
        }

        @Override
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

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = result * 59 + (fifth == null ? 43 : fifth.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = super.equals(obj);

            if (result) {
                FiveTuple other = (FiveTuple) obj;

                if (this.fifth != null) {
                    result = this.fifth.equals(other.fifth);
                } else {
                    result = (this.fifth == other.fifth);
                }
            }

            return result;
        }

        @Override
        public String toString() {
            return "(" + this.first + ", " + this.second + ", " + this.third + ", "
                    + this.fourth + ", " + this.fifth + ")";
        }
    }

    public static void main(String[] args) {
        FiveTuple<String, Long, Integer, String, ThreeTuple<String, Integer, Number>> fiveTuple1
                = new FiveTuple<String, Long, Integer, String, ThreeTuple<String, Integer, Number>>(
                "A", null, 3, new String("94q3g8"),
                    new ThreeTuple<String, Integer, Number>("2rf", 555, null)
        );
        FiveTuple<String, Long, Integer, String, ThreeTuple<String, Integer, Number>> fiveTuple2
                = new FiveTuple<String, Long, Integer, String, ThreeTuple<String, Integer, Number>>(
                "A", null, 3, new String("94q3g8"),
                    new ThreeTuple<String, Integer, Number>("2rf", 555, null)
        );
        FiveTuple<String, Long, Integer, String, ThreeTuple<String, Integer, Number>> fiveTuple3
                = new FiveTuple<String, Long, Integer, String, ThreeTuple<String, Integer, Number>>(
                "A", null, 3, new String("94q3g8"),
                    new FourTuple<String, Integer, Number, Class>("2rf", 555, null, Map.class)
        );

        assert(fiveTuple1.equals(null) == false);
        assert(fiveTuple1.equals(fiveTuple1) == true);
        assert(fiveTuple1.equals(fiveTuple2) == true);
        assert(fiveTuple2.equals(fiveTuple1) == true);
        assert(fiveTuple1.equals(fiveTuple3) == false);
        assert(fiveTuple3.equals(fiveTuple1) == false);
    }
}
