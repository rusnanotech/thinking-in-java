/****************** Exercise 28 *****************
 * Modify net/mindview/util/Tuple.java to make it
 * a general-purpose class by adding hashCode(),
 * equals(), and implementing Comparable for each
 * type of Tuple.
 ***********************************************/
package biz.markov.thinking.containers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

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

    public static class TwoTuple<A, B> implements Comparable<TwoTuple<A, B>> {
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
                    result = (other.first == null);
                }

                if (result) {
                    if (this.second != null) {
                        result = this.second.equals(other.second);
                    } else {
                        result = (other.second == null);
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

        @Override
        public int compareTo(TwoTuple<A, B> other) {
            if (!checkInstance(other)) {
                throw new ClassCastException();
            }

            @SuppressWarnings("unchecked")
            Comparable<A> first = (Comparable<A>) this.first;

            @SuppressWarnings("unchecked")
            Comparable<B> second = (Comparable<B>) this.second;

            if (this.first == null || this.second == null
                    || other.first == null || other.second == null) {
                throw new NullPointerException();
            }

            int result = first.compareTo(other.first);

            if (result == 0) {
                result = second.compareTo(other.second);
            }

            return result;
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
                    result = (other.third == null);
                }
            }

            return result;
        }

        @Override
        public String toString() {
            return "(" + this.first + ", " + this.second + ", " + this.third + ")";
        }

        @Override
        public int compareTo(TwoTuple<A, B> other) {
            ThreeTuple<A, B, C> otherTuple = (ThreeTuple<A, B, C>) other;

            @SuppressWarnings("unchecked")
            Comparable<C> third = (Comparable<C>) this.third;

            if (this.third == null || otherTuple.third == null) {
                throw new NullPointerException();
            }

            int result = super.compareTo(otherTuple);

            if (result == 0) {
                result = third.compareTo(otherTuple.third);
            }

            return result;
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
                    result = (other.fourth == null);
                }
            }

            return result;
        }

        @Override
        public String toString() {
            return "(" + this.first + ", " + this.second + ", " + this.third + ", " + this.fourth + ")";
        }

        @Override
        public int compareTo(TwoTuple<A, B> other) {
            FourTuple<A, B, C, D> otherTuple = (FourTuple<A, B, C, D>) other;

            @SuppressWarnings("unchecked")
            Comparable<D> fourth = (Comparable<D>) this.fourth;

            if (this.fourth == null || otherTuple.fourth == null) {
                throw new NullPointerException();
            }

            int result = super.compareTo(otherTuple);

            if (result == 0) {
                result = fourth.compareTo(otherTuple.fourth);
            }

            return result;
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
                    result = (other.fifth == null);
                }
            }

            return result;
        }

        @Override
        public String toString() {
            return "(" + this.first + ", " + this.second + ", " + this.third + ", "
                    + this.fourth + ", " + this.fifth + ")";
        }

        @Override
        public int compareTo(TwoTuple<A, B> other) {
            FiveTuple<A, B, C, D, E> otherTuple = (FiveTuple<A, B, C, D, E>) other;

            @SuppressWarnings("unchecked")
            Comparable<E> fifth = (Comparable<E>) this.fifth;

            if (this.fifth == null || otherTuple.fifth == null) {
                throw new NullPointerException();
            }

            int result = super.compareTo(otherTuple);

            if (result == 0) {
                result = fifth.compareTo(otherTuple.fifth);
            }

            return result;
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

        assert(!fiveTuple1.equals(null));
        assert(fiveTuple1.equals(fiveTuple1));
        assert(fiveTuple1.equals(fiveTuple2));
        assert(fiveTuple2.equals(fiveTuple1));
        assert(!fiveTuple1.equals(fiveTuple3));
        assert(!fiveTuple3.equals(fiveTuple1));

        List<FiveTuple<Integer, String, Character, Double, ThreeTuple<Long, String, Float>>> list = Arrays.asList(
                new FiveTuple<Integer, String, Character, Double, ThreeTuple<Long, String, Float>>(
                        48, "bcx", 'a', 52.8, new ThreeTuple<Long, String, Float>(50L, "rbs", 0.8F)
                ),
                new FiveTuple<Integer, String, Character, Double, ThreeTuple<Long, String, Float>>(
                        48, "aab", 'x', 10.2, new ThreeTuple<Long, String, Float>(50L, "rbs", 0.8F)
                ),
                new FiveTuple<Integer, String, Character, Double, ThreeTuple<Long, String, Float>>(
                        48, "bcx", 'b', 11.1, new ThreeTuple<Long, String, Float>(50L, "rbs", 0.7F)
                ),
                new FiveTuple<Integer, String, Character, Double, ThreeTuple<Long, String, Float>>(
                        48, "bcx", 'b', 11.1, new ThreeTuple<Long, String, Float>(50L, "rbs", 0.8F)
                ),
                new FiveTuple<Integer, String, Character, Double, ThreeTuple<Long, String, Float>>(
                        3, "bcx", 'a', 10.2, new ThreeTuple<Long, String, Float>(50L, "rbs", 0.8F)
                )
        );

        System.out.println(list);
        System.out.println(new TreeSet<FiveTuple<Integer, String, Character, Double, ThreeTuple<Long, String, Float>>>(list));
        Collections.sort(list);
        System.out.println(list);

        FourTuple<Integer, String, Long, Double> fourTuple
                = new FourTuple<Integer, String, Long, Double>(223, "abc", 96786L, 2243.988);
        ThreeTuple<Integer, String, Long> threeTuple
                = new ThreeTuple<Integer, String, Long>(132, "3245", 896L);
        ThreeTuple<Integer, String, Long> threeTuple2
                = new ThreeTuple<Integer, String, Long>(234, null, 898L);

        boolean result = false;
        try {
            fourTuple.compareTo(threeTuple);
        } catch (ClassCastException ex) {
            result = true;
        }
        assert (result);

        result = false;
        try {
            threeTuple.compareTo(fourTuple);
        } catch (ClassCastException ex) {
            result = true;
        }
        assert (result);

        result = false;
        try {
            threeTuple.compareTo(threeTuple2);
        } catch (NullPointerException ex) {
            result = true;
        }
        assert (result);
    }
}
