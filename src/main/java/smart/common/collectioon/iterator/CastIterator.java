package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <TSource>
 * @param <TResult>
 */
public class CastIterator<TSource, TResult> implements Iterator<TResult> {

    private final Iterator<TSource> source;

    /**
     *
     * @param source
     */
    public CastIterator(final Iterator<TSource> source) {
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        return source.hasNext();
    }

    @SuppressWarnings("unchecked")
    @Override
    public TResult next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (TResult)source.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
