package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <TSource>
 * @param <TResult>
 */
public class OfTypeIterator<TSource, TResult> implements Iterator<TResult> {

    private final Iterator<TSource> source;

    private final Class<TResult> clazz;

    private Boolean hasNext;

    private TResult next;

    /**
     *
     * @param source
     */
    public OfTypeIterator(final Iterator<TSource> source, final Class<TResult> clazz) {
        this.source = source;
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean hasNext() {
        if (hasNext != null) {
            return hasNext;
        }
        while (true) {
            if (!source.hasNext()) {
                return false;
            }
            TSource obj = source.next();
            if ((obj != null) && (obj.getClass().isAssignableFrom(clazz))) {
                next = (TResult)obj;
                hasNext = true;
                return true;
            }
        }
    }

    @Override
    public TResult next() {
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
