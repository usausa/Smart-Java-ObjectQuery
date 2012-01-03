package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <TSource>
 */
public class RepeatIterator<TSource> implements Iterator<TSource> {

    private final TSource value;

    private int count;

    /**
     *
     * @param value
     * @param count
     */
    public RepeatIterator(final TSource value, final int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        return count > 0;
    }

    @Override
    public TSource next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        count--;
        return value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
