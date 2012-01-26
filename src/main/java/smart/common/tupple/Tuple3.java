package smart.common.tupple;

/**
 *
 * @param <T1>
 * @param <T2>
 * @param <T3>
 */
public class Tuple3<T1, T2, T3> {

    private T1 value1;
    private T2 value2;
    private T3 value3;

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

    public Tuple3() {
    }

    public Tuple3(final T1 value1, final T2 value2, final T3 value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    @Override
    public String toString() {
        return "{" + value1 + ", " + value2 + ", " + value3 + "}";
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

        Tuple3<T1, T2, T3> other = (Tuple3<T1, T2, T3>) obj;
        return ((value1 == null) ? (other.value1 == null) : (value1.equals(other.value1))) &&
               ((value2 == null) ? (other.value2 == null) : (value2.equals(other.value2))) &&
               ((value3 == null) ? (other.value3 == null) : (value3.equals(other.value3)));
    }

    @Override
    public int hashCode() {
        int result = (value1 != null ? value1.hashCode() : 0);
        result = 29 * result + (value2 != null ? value2.hashCode() : 0);
        result = 29 * result + (value3 != null ? value3.hashCode() : 0);
        return result;
    }
}
