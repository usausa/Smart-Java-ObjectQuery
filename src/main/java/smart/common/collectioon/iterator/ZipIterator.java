package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import smart.common.functor.Func2;

/**
 *
 * @param <TSource1>
 * @param <TSource2>
 * @param <TResult>
 */
public class ZipIterator<TSource1, TSource2, TResult> implements Iterator<TResult> {

    private final Iterator<TSource1> source1;

    private final Iterator<TSource2> source2;

    private final Func2<TSource1, TSource2, TResult> resultSelector;

    /**
     *
     * @param source1
     * @param source2
     * @param resultSelector
     */
    public ZipIterator(final Iterator<TSource1> source1, final Iterator<TSource2> source2, final Func2<TSource1, TSource2, TResult> resultSelector) {
        this.source1 = source1;
        this.source2 = source2;
        this.resultSelector = resultSelector;
    }

    @Override
    public boolean hasNext() {
        return source1.hasNext() && source2.hasNext();
    }

    @Override
    public TResult next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return resultSelector.eval(source1.next(), source2.next());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
