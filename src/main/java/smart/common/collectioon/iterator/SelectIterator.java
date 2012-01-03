package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import smart.common.functor.Func1;

/**
 *
 * @param <TSource>
 * @param <TResult>
 */
public class SelectIterator<TSource, TResult> implements Iterator<TResult> {

    private final Iterator<TSource> source;

    private final Func1<TSource, TResult> resultSelector;

    /**
     *
     * @param source
     * @param resultSelector
     */
    public SelectIterator(final Iterator<TSource> source, final Func1<TSource, TResult> resultSelector) {
        this.source = source;
        this.resultSelector = resultSelector;
    }

    @Override
    public boolean hasNext() {
        return source.hasNext();
    }

    @Override
    public TResult next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return resultSelector.eval(source.next());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
