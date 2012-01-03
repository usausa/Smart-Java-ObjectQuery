package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import smart.common.functor.Predicate;

/**
 *
 * @param <TSource>
 */
public class SkipWhileIterator<TSource> implements Iterator<TSource> {

    private final Iterator<TSource> source;

    private final Predicate<TSource> predicate;

    private Boolean hasNext;

    private TSource next;

    /**
     *
     * @param source
     * @param predicate
     */
    public SkipWhileIterator(final Iterator<TSource> source, final Predicate<TSource> predicate) {
        this.source = source;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        if (hasNext != null) {
            return hasNext;
        }
        while (true) {
            if (!source.hasNext()) {
                return false;
            }
            next = source.next();
            if (!predicate.test(next)) {
                hasNext = true;
                return true;
            }
        }
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
