package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <TSource>
 */
public class EmptyIterator<TSource> implements Iterator<TSource> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public TSource next() {
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
