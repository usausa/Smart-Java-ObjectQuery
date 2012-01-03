package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import smart.common.collectioon.Grouping;
import smart.common.collectioon.LookupImpl;
import smart.common.functor.Func1;

/**
 *
 * @param <TSource>
 * @param <TKey>
 * @param <TElement>
 * @param <TResult>
 */
public class GroupedIterator<TSource, TKey, TElement, TResult> implements Iterator<TResult> {

    private final Iterator<Grouping<TKey, TElement>> iterator;

    private final Func1<Grouping<TKey, TElement>, TResult> resultSelector;

    /**
     *
     * @param source
     * @param keySelector
     * @param elementSelector
     * @param resultSelector
     */
    public GroupedIterator(
            final Iterator<TSource> source,
            final Func1<TSource, TKey> keySelector,
            final Func1<TSource, TElement> elementSelector,
            final Func1<Grouping<TKey, TElement>, TResult> resultSelector) {
        this.iterator = LookupImpl.create(source, keySelector, elementSelector).iterator();
        this.resultSelector = resultSelector;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public TResult next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return resultSelector.eval(iterator.next());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
