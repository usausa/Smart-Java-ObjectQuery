package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <TSource>
 */
public class SingleIterator<TSource> implements Iterator<TSource> {

    private final TSource value;

    private boolean hasNext = true;

    /**
     *
     * @param value
     */
    public SingleIterator(final TSource value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public TSource next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        hasNext = false;
        return value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
