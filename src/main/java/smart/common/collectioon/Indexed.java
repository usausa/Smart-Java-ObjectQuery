package smart.common.collectioon;

/**
 *
 * @param <T>
 */
public class Indexed<T> {

    private final T element;

    private final int index;

    public Indexed(final T element, final int index) {
        this.element = element;
        this.index = index;
    }

    public T getElement() {
        return element;
    }

    public int getIndex() {
        return index;
    }
}
