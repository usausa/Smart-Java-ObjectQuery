package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import smart.common.collectioon.Lookup;
import smart.common.collectioon.LookupImpl;
import smart.common.functor.Func1;
import smart.common.functor.Func2;

/**
 *
 * @param <TOuter>
 * @param <TInner>
 * @param <TKey>
 * @param <TResult>
 */
public class JoinIterator<TOuter, TInner, TKey, TResult> implements Iterator<TResult> {

    private final Iterator<TOuter> outer;

    private final Lookup<TKey, TInner> innerLookup;

    private final Func1<TOuter, TKey> outerKeySelector;

    private final Func2<TOuter, TInner, TResult> resultSelector;

    private TOuter current;

    private Iterator<TInner> inner;

    private Boolean hasNext = null;

    private TResult next;

    /**
     *
     * @param outer
     * @param innerLookup
     * @param outerKeySelector
     * @param resultSelector
     */
    public JoinIterator(
            final Iterator<TOuter> outer,
            final Iterator<TInner> inner,
            final Func1<TOuter, TKey> outerKeySelector,
            final Func1<TInner, TKey> innerKeySelector,
            final Func2<TOuter, TInner, TResult> resultSelector) {
        this.outer = outer;
        this.innerLookup = LookupImpl.create(inner, innerKeySelector, new Func1<TInner, TInner>() {
            @Override
            public TInner eval(final TInner param) {
                return param;
            }
        });
        this.outerKeySelector = outerKeySelector;
        this.resultSelector = resultSelector;
    }

    @Override
    public boolean hasNext() {
        if (hasNext != null) {
            return hasNext;
        }

        while (true) {
            while (inner == null) {
                if (!outer.hasNext()) {
                    hasNext = false;
                    return false;
                }

                current = outer.next();
                inner = innerLookup.get(outerKeySelector.eval(current)).iterator();
            }

            if (!inner.hasNext()) {
                inner = null;
                continue;
            }

            next = resultSelector.eval(current, inner.next());
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
