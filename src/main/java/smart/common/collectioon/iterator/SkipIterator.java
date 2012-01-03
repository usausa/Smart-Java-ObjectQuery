package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <TSource>
 */
public class SkipIterator<TSource> implements Iterator<TSource> {

    private final Iterator<TSource> source;

    private final int count;

    private boolean skipped = false;

    /**
     *
     * @param source
     * @param count
     */
    public SkipIterator(final Iterator<TSource> source, final int count) {
        this.source = source;
        this.count = count;
    }

    @Override
    public boolean hasNext() {
        if (!skipped) {
            for (int i = 0; i < count; i++) {
                if (!source.hasNext()) {
                    return false;
                }
                source.next();
            }
            skipped = true;
        }
        return source.hasNext();
    }

    @Override
    public TSource next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return source.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
