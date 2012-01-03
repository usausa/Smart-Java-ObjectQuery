package smart.common.collectioon.iterator;

import java.util.Iterator;

import smart.common.collectioon.Indexed;


/**
 *
 * @param <TSource>
 */
public class IndexedIterator<TSource> implements Iterator<Indexed<TSource>> {

    private final Iterator<TSource> iterator;

    private int index;

    public IndexedIterator(final Iterator<TSource> iterator) {
        this.iterator = iterator;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Indexed<TSource> next() {
        return new Indexed<TSource>(iterator.next(), index++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
