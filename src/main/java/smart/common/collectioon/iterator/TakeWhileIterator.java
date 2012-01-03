package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import smart.common.functor.Predicate;

/**
 *
 * @param <TSource>
 */
public class TakeWhileIterator<TSource> implements Iterator<TSource> {

    private final Iterator<TSource> source;

    private final Predicate<TSource> predicate;

    private Boolean hasNext;

    private TSource next;

    /**
     *
     * @param source
     * @param predicate
     */
    public TakeWhileIterator(final Iterator<TSource> source, final Predicate<TSource> predicate) {
        this.source = source;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        if (hasNext != null) {
            return hasNext;
        }
        if (!source.hasNext()) {
            return false;
        }
        next = source.next();
        hasNext = predicate.test(next);
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
