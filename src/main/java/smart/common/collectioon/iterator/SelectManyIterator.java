package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import smart.common.functor.Func1;
import smart.common.functor.Func2;

/**
 *
 * @param <TSource>
 * @param <TCollection>
 * @param <TResult>
 */
public class SelectManyIterator<TSource, TCollection, TResult> implements Iterator<TResult> {

    private final Iterator<TSource> source;

    private final Func1<TSource, Iterable<TCollection>> collectionSelector;

    private final Func2<TSource, TCollection, TResult> resultSelector;

    private Iterator<TCollection> collection;

    private Boolean hasNext = null;

    private TResult next;

    /**
     *
     * @param source
     * @param collectionSelector
     * @param resultSelector
     */
    public SelectManyIterator(
            final Iterator<TSource> source,
            final Func1<TSource, Iterable<TCollection>> collectionSelector,
            final Func2<TSource, TCollection, TResult> resultSelector) {
        this.source = source;
        this.collectionSelector = collectionSelector;
        this.resultSelector = resultSelector;
    }

    @Override
    public boolean hasNext() {
        if (hasNext != null) {
            return hasNext;
        }

        while (true) {
            TSource current = null;
            while (collection == null) {
                if (!source.hasNext()) {
                    hasNext = false;
                    return false;
                }

                current = source.next();
                collection = collectionSelector.eval(current).iterator();
            }

            if (!collection.hasNext()) {
                collection = null;
                continue;
            }

            next = resultSelector.eval(current, collection.next());
            hasNext = true;
            return hasNext;
        }
    }

    @Override
    public TResult next() {
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
