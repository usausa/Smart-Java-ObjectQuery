package smart.common.collectioon.iterator;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @param <TSource>
 */
public class IntersectIterator<TSource> implements Iterator<TSource> {

    private final Set<TSource> set;

    private final Iterator<TSource> source;

    private Boolean hasNext = null;

    private TSource next;

    /**
     *
     * @param source
     * @param second
     * @param comparator
     */
    public IntersectIterator(final Iterator<TSource> source, final Iterator<TSource> second, final Comparator<TSource> comparator) {
        this.source = source;
        this.set = comparator != null ? new TreeSet<TSource>(comparator) : new HashSet<TSource>();
        while (second.hasNext()) {
            this.set.add(second.next());
        }
    }

    @Override
    public boolean hasNext() {
        if (hasNext != null) {
            return hasNext;
        }

        while (source.hasNext()) {
            next = source.next();
            if (set.remove(next)) {
                hasNext = true;
                return true;
            }
        }
        hasNext = false;
        return false;
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
