package smart.common.collectioon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import smart.common.collectioon.iterator.EmptyIterator;
import smart.common.functor.Func1;

/**
 *
 * @param <TKey>
 * @param <TElement>
 */
public final class LookupImpl<TKey, TElement> implements Lookup<TKey, TElement> {

    /**
     *
     * @param <TKey>
     * @param <TElement>
     */
    static class GroupingImpl<TKey, TElement> implements Grouping<TKey, TElement> {

        private final TKey key;

        private final List<TElement> elements = new ArrayList<TElement>();

        @Override
        public TKey getKey() {
            return key;
        }

        @Override
        public Iterator<TElement> iterator() {
            return elements.iterator();
        }

        /**
         *
         * @param key
         */
        public GroupingImpl(final TKey key) {
            this.key = key;
        }
    }

    private final Map<TKey, Grouping<TKey, TElement>> groupings = new LinkedHashMap<TKey, Grouping<TKey, TElement>>();

    @Override
    public Iterator<Grouping<TKey, TElement>> iterator() {
        return groupings.values().iterator();
    }

    @Override
    public boolean containsKey(final TKey key) {
        return groupings.containsKey(key);
    }

    @Override
    public int size() {
        return groupings.size();
    }

    @Override
    public boolean isEmpty() {
        return groupings.isEmpty();
    }

    @Override
    public Iterable<TElement> get(final TKey key) {
        if (groupings.containsKey(key)) {
            return groupings.get(key);
        }
        return new Iterable<TElement>() {
            @Override
            public Iterator<TElement> iterator() {
                return new EmptyIterator<TElement>();
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TKey>
     * @param <TElement>
     * @param iterable
     * @param keySelector
     * @param elementSelector
     * @return
     */
    public static <TSource, TKey, TElement> LookupImpl<TKey, TElement> create(
            final Iterator<TSource> iterator, final Func1<TSource, TKey> keySelector, final Func1<TSource, TElement> elementSelector) {
        LookupImpl<TKey, TElement> lookup = new LookupImpl<TKey, TElement>();
        while (iterator.hasNext()) {
            TSource obj = iterator.next();
            TKey key = keySelector.eval(obj);
            TElement element = elementSelector.eval(obj);
            GroupingImpl<TKey, TElement> grouping = getOrNewGrouping(lookup, key);
            grouping.elements.add(element);
        }
        return lookup;
    }

    /**
     *
     * @param <TKey>
     * @param <TElement>
     * @param lookup
     * @param key
     * @return
     */
    private static <TKey, TElement> GroupingImpl<TKey, TElement> getOrNewGrouping(final LookupImpl<TKey, TElement> lookup, final TKey key) {
        GroupingImpl<TKey, TElement> grouping;
        if (lookup.groupings.containsKey(key)) {
            return  (GroupingImpl<TKey, TElement>)lookup.groupings.get(key);
        } else {
            grouping = new GroupingImpl<TKey, TElement>(key);
            lookup.groupings.put(key, grouping);
            return  grouping;
        }
    }

    private LookupImpl() {
    }
}
