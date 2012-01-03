package smart.common.collectioon.iterator;

import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 * @param <TSource>
 */
public class EnumerationIterator<TSource> implements Iterator<TSource> {

    private final Enumeration<TSource> enumeration;

    /**
     *
     * @param enumeration
     */
    public EnumerationIterator(final Enumeration<TSource> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public TSource next() {
        return enumeration.nextElement();
    }
}
