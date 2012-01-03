package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <TSource>
 */
public class ConactIterator<TSource> implements Iterator<TSource> {

    private final Iterator<TSource>[] iterators;

    private int index;

    /**
     *
     * @param source
     * @param second
     */
    public ConactIterator(final Iterator<TSource>... iterators) {
        this.iterators = iterators;
    }

    @Override
    public boolean hasNext() {
        for (; index < iterators.length; index++) {
            if (iterators[index].hasNext()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public TSource next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iterators[index].next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
