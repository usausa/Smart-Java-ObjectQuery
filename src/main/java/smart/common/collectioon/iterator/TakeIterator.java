package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <TSource>
 */
public class TakeIterator<TSource> implements Iterator<TSource> {

    private final Iterator<TSource> source;

    private int count;

    private Boolean hasNext;

    private TSource next;

    /**
     *
     * @param source
     * @param count
     */
    public TakeIterator(final Iterator<TSource> source, final int count) {
        this.source = source;
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        if (hasNext != null) {
            return hasNext;
        }
        if (count == 0) {
            return false;
        }
        hasNext = source.hasNext();
        if (hasNext) {
            next = source.next();
            count--;
        }
        return hasNext;
    }

    @Override
    public TSource next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        hasNext = null;
        return next;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
