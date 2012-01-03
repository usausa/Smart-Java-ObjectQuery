package smart.common.tupple;

/**
 *
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 */
public class Tuple4<T1, T2, T3, T4> {

    private T1 value1;
    private T2 value2;
    private T3 value3;
    private T4 value4;

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

    public T3 getValue3() {
        return value3;
    }

    public void setValue3(final T3 value3) {
        this.value3 = value3;
    }

    public T4 getValue4() {
        return value4;
    }

    public void setValue4(final T4 value4) {
        this.value4 = value4;
    }

    public Tuple4() {
    }

    public Tuple4(final T1 value1, final T2 value2, final T3 value3, final T4 value4) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
    }

    @Override
    public String toString() {
        return "{" + value1 + ", " + value2 + ", " + value3 + ", " + value4 + "}";
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

        Tuple4<T1, T2, T3, T4> other = (Tuple4<T1, T2, T3, T4>) obj;
        return ((value1 == other.value1) || ((value1 != null) && (value1.equals(other.value1))))
                && ((value2 == other.value2) || ((value2 != null) && (value2.equals(other.value2))))
                && ((value3 == other.value3) || ((value3 != null) && (value3.equals(other.value3))))
                && ((value4 == other.value4) || ((value4 != null) && (value4.equals(other.value4))));
    }

    @Override
    public int hashCode() {
        int result = (value1 != null ? value1.hashCode() : 0);
        result = 29 * result + (value2 != null ? value2.hashCode() : 0);
        result = 29 * result + (value3 != null ? value3.hashCode() : 0);
        result = 29 * result + (value4 != null ? value4.hashCode() : 0);
        return result;
    }
}
