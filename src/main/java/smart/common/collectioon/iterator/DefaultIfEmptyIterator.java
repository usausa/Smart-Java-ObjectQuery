package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <TSource>
 */
public class DefaultIfEmptyIterator<TSource> implements Iterator<TSource> {

    private final Iterator<TSource> source;

    private final TSource defaultValue;

    private boolean emptyHasNext = true;

    /**
     *
     * @param source
     * @param defaultValue
     */
    public DefaultIfEmptyIterator(final Iterator<TSource> source, final TSource defaultValue) {
        this.source = source;
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean hasNext() {
        if (source.hasNext()) {
            emptyHasNext = false;
            return true;
        }
        return emptyHasNext;
    }

    @Override
    public TSource next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        if (emptyHasNext) {
            emptyHasNext = false;
            return defaultValue;
        }
        return source.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
