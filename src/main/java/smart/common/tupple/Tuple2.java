package smart.common.tupple;

/**
 *
 * @param <T1>
 * @param <T2>
 */
public class Tuple2<T1, T2> {

    private T1 value1;
    private T2 value2;

    public static <T1, T2> Tuple2<T1, T2> pair(final T1 value1, final T2 value2) {
        return new Tuple2<T1, T2>(value1, value2);
    }

    public Tuple2() {
    }

    public Tuple2(final T1 value1, final T2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T1 getValue1() {
        return value1;
    }

    public void setValue1(final T1 value1) {
        this.value1 = value1;
    }

    public T2 getValue2() {
        return value2;
    }

    public void setValue2(final T2 value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "{" + value1 + ", " + value2 + "}";
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        Tuple2<T1, T2> other = (Tuple2<T1, T2>) obj;
        return ((value1 == null) ? (other.value1 == null) : (value1.equals(other.value1))) &&
               ((value2 == null) ? (other.value2 == null) : (value2.equals(other.value2)));
    }

    @Override
    public int hashCode() {
        int result = (value1 != null ? value1.hashCode() : 0);
        result = 29 * result + (value2 != null ? value2.hashCode() : 0);
        return result;
    }
}
