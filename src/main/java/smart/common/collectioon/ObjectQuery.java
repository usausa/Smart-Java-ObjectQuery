package smart.common.collectioon;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import smart.common.collectioon.iterator.ConactIterator;
import smart.common.collectioon.iterator.DefaultIfEmptyIterator;
import smart.common.collectioon.iterator.DistinctIterator;
import smart.common.collectioon.iterator.EmptyIterator;
import smart.common.collectioon.iterator.EnumerationIterator;
import smart.common.collectioon.iterator.ExpectIterator;
import smart.common.collectioon.iterator.GroupJoinIterator;
import smart.common.collectioon.iterator.GroupedIterator;
import smart.common.collectioon.iterator.IndexedIterator;
import smart.common.collectioon.iterator.IntersectIterator;
import smart.common.collectioon.iterator.JoinIterator;
import smart.common.collectioon.iterator.RangeIterator;
import smart.common.collectioon.iterator.RepeatIterator;
import smart.common.collectioon.iterator.SelectIterator;
import smart.common.collectioon.iterator.SelectManyIterator;
import smart.common.collectioon.iterator.SingleIterator;
import smart.common.collectioon.iterator.SkipIterator;
import smart.common.collectioon.iterator.SkipWhileIterator;
import smart.common.collectioon.iterator.TakeIterator;
import smart.common.collectioon.iterator.TakeWhileIterator;
import smart.common.collectioon.iterator.UnionIterator;
import smart.common.collectioon.iterator.WhereIterator;
import smart.common.collectioon.iterator.ZipIterator;
import smart.common.functor.Action;
import smart.common.functor.Func1;
import smart.common.functor.Func2;
import smart.common.functor.Predicate;

/**
 *
 * @param <TSource>
 */
public final class ObjectQuery<TSource> implements Iterable<TSource> {

    private final Iterable<TSource> iterable;

    /**
     *
     * @param iterable
     */
    private ObjectQuery(final Iterable<TSource> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<TSource> iterator() {
        return iterable.iterator();
    }

    // ------------------------------------------------------------
    // From
    // ------------------------------------------------------------

    /**
     *
     * @param <TSource>
     * @param items
     * @return
     */
    public static <TSource> ObjectQuery<TSource> fromArray(final TSource... items) {
        return new ObjectQuery<TSource>(Arrays.asList(items));
    }

    /**
     *
     * @param <TSource>
     * @param collection
     * @return
     */
    public static <TSource> ObjectQuery<TSource> from(final Iterable<TSource> collection) {
        return new ObjectQuery<TSource>(collection);
    }

    /**
     *
     * @param <TSource>
     * @param iterator
     * @return
     */
    public static <TSource> ObjectQuery<TSource> from(final Iterator<TSource> iterator) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return iterator;
            }
        });
    }

    /**
     *
     * @param <TSource>
     * @param enumeration
     * @return
     */
    public static <TSource> ObjectQuery<TSource> fromEnumeration(final Enumeration<TSource> enumeration) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new EnumerationIterator<TSource>(enumeration);
            }
        });
    }

    /**
     *
     * @param <TSource>
     * @return
     */
    public static <TSource> ObjectQuery<TSource> fromEmpty() {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new EmptyIterator<TSource>();
            }
        });
    }

    /**
     *
     * @param <TSource>
     * @param value
     * @return
     */
    public static <TSource> ObjectQuery<TSource> fromSingle(final TSource value) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new SingleIterator<TSource>(value);
            }
        });
    }

    // ------------------------------------------------------------
    // Generate
    // ------------------------------------------------------------

    /**
     *
     * @param <TSource>
     * @param value
     * @param count
     * @return
     */
    public static <TSource> ObjectQuery<TSource> repeat(final TSource value, final int count) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new RepeatIterator<TSource>(value, count);
            }
        });
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public static ObjectQuery<Integer> range(final int start, final int end) {
        if (start > end) {
            return range(start, end, -1);
        } else {
            return range(start, end, 1);
        }
    }

    /**
     *
     * @param start
     * @param end
     * @param step
     * @return
     */
    public static ObjectQuery<Integer> range(final int start, final int end, final int step) {
        return new ObjectQuery<Integer>(new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new RangeIterator(start, end, step);
            }
        });
    }

    // ------------------------------------------------------------
    // インデックス
    // ------------------------------------------------------------

    /**
     *
     * @param iterable
     * @return
     */
    public ObjectQuery<Indexed<TSource>> rownum() {
        return new ObjectQuery<Indexed<TSource>>(new Iterable<Indexed<TSource>>() {
            @Override
            public Iterator<Indexed<TSource>> iterator() {
                return new IndexedIterator<TSource>(iterable.iterator());
            }
        });
    }

    // ------------------------------------------------------------
    // 空要素
    // ------------------------------------------------------------

    /**
     *
     * @return
     */
    public ObjectQuery<TSource> defaultIfEmpty() {
        return defaultIfEmpty(null);
    }

    /**
     *
     * @param defaultValue
     * @return
     */
    public ObjectQuery<TSource> defaultIfEmpty(final TSource defaultValue) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new DefaultIfEmptyIterator<TSource>(iterable.iterator(), defaultValue);
            }
        });
    }

    // ------------------------------------------------------------
    // 集合
    // ------------------------------------------------------------

    /**
     *
     * @param second
     * @return
     */
    public ObjectQuery<TSource> conact(final Iterable<TSource> second) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @SuppressWarnings("unchecked")
            @Override
            public Iterator<TSource> iterator() {
                return new ConactIterator<TSource>(iterable.iterator(), second.iterator());
            }
        });
    }

    /**
     *
     * @return
     */
    public ObjectQuery<TSource> distinct() {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new DistinctIterator<TSource>(iterable.iterator(), null);
            }
        });
    }

    /**
     *
     * @param comparator
     * @return
     */
    public ObjectQuery<TSource> distinct(final Comparator<TSource> comparator) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new DistinctIterator<TSource>(iterable.iterator(), comparator);
            }
        });
    }

    /**
     *
     * @param second
     * @return
     */
    public ObjectQuery<TSource> union(final Iterable<TSource> second) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new UnionIterator<TSource>(iterable.iterator(), second.iterator(), null);
            }
        });
    }

    /**
     *
     * @param second
     * @param comparator
     * @return
     */
    public ObjectQuery<TSource> union(final Iterable<TSource> second, final Comparator<TSource> comparator) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new UnionIterator<TSource>(iterable.iterator(), second.iterator(), comparator);
            }
        });
    }

    /**
     *
     * @param second
     * @return
     */
    public ObjectQuery<TSource> expect(final Iterable<TSource> second) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new ExpectIterator<TSource>(iterable.iterator(), second.iterator(), null);
            }
        });
    }

    /**
     *
     * @param second
     * @param comparator
     * @return
     */
    public ObjectQuery<TSource> expect(final Iterable<TSource> second, final Comparator<TSource> comparator) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new ExpectIterator<TSource>(iterable.iterator(), second.iterator(), comparator);
            }
        });
    }

    /**
     *
     * @param second
     * @return
     */
    public ObjectQuery<TSource> intersect(final Iterable<TSource> second) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new IntersectIterator<TSource>(iterable.iterator(), second.iterator(), null);
            }
        });
    }

    /**
     *
     * @param second
     * @param comparator
     * @return
     */
    public ObjectQuery<TSource> intersect(final Iterable<TSource> second, final Comparator<TSource> comparator) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new IntersectIterator<TSource>(iterable.iterator(), second.iterator(), comparator);
            }
        });
    }

    // ------------------------------------------------------------
    // マージ
    // ------------------------------------------------------------

    /**
     *
     * @param <TSource2>
     * @param <TResult>
     * @param collection2
     * @param resultSelector
     * @return
     */
    public <TSource2, TResult> ObjectQuery<TResult> zip(final Iterable<TSource2> collection2, final Func2<TSource, TSource2, TResult> resultSelector) {
        return new ObjectQuery<TResult>(new Iterable<TResult>() {
            @Override
            public Iterator<TResult> iterator() {
                return new ZipIterator<TSource, TSource2, TResult>(iterable.iterator(), collection2.iterator(), resultSelector);
            }
        });
    }

    // ------------------------------------------------------------
    // ページング
    // ------------------------------------------------------------

    /**
     *
     * @param count
     * @return
     */
    public ObjectQuery<TSource> skip(final int count) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new SkipIterator<TSource>(iterable.iterator(), count);
            }
        });
    }

    /**
     *
     * @param predicate
     * @return
     */
    public ObjectQuery<TSource> skipWhile(final Predicate<TSource> predicate) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new SkipWhileIterator<TSource>(iterable.iterator(), predicate);
            }
        });
    }

    /**
     *
     * @param count
     * @return
     */
    public ObjectQuery<TSource> take(final int count) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new TakeIterator<TSource>(iterable.iterator(), count);
            }
        });
    }

    /**
     *
     * @param predicate
     * @return
     */
    public ObjectQuery<TSource> takeWhile(final Predicate<TSource> predicate) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new TakeWhileIterator<TSource>(iterable.iterator(), predicate);
            }
        });
    }

    // ------------------------------------------------------------
    // ソート
    // ------------------------------------------------------------

    /**
     *
     * @param <TKey>
     * @param collection
     * @param keySelector
     * @return
     */
    public <TKey extends Comparable<? super TKey>> ObjectQuery<TSource> order(final Func1<TSource, TKey> keySelector) {
        List<TSource> list = toList();
        Collections.sort(list, new Comparator<TSource>() {
            @Override
            public int compare(final TSource source1, final TSource source2) {
                TKey key1 = keySelector.eval(source1);
                TKey key2 = keySelector.eval(source2);
                return key1.compareTo(key2);
            }
        });
        return new ObjectQuery<TSource>(list);
    }

    /**
     *
     * @param comparator
     * @return
     */
    public ObjectQuery<TSource> order(final Comparator<TSource> comparator) {
        List<TSource> list = toList();
        Collections.sort(list, new Comparator<TSource>() {
            @Override
            public int compare(final TSource source1, final TSource source2) {
                return comparator.compare(source1, source2);
            }
        });
        return new ObjectQuery<TSource>(list);
    }

    /**
     *
     * @return
     */
    public ObjectQuery<TSource> reverse() {
        List<TSource> list = toList();
        Collections.reverse(list);
        return new ObjectQuery<TSource>(list);
    }

    // ------------------------------------------------------------
    // 判定
    // ------------------------------------------------------------

    /**
     *
     * @param predicate
     * @return
     */
    public boolean all(final Predicate<TSource> predicate) {
        for (TSource obj : iterable) {
            if (!predicate.test(obj)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param predicate
     * @return
     */
    public boolean any(final Predicate<TSource> predicate) {
        for (TSource obj : iterable) {
            if (predicate.test(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param value
     * @return
     */
    public boolean contains(final TSource value) {
        if (iterable instanceof Collection) {
            return ((Collection<TSource>)iterable).contains(value);
        }
        for (TSource obj : iterable) {
            if (((obj == null) && (value == null)) || ((obj != null) && (obj.equals(value)))) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param value
     * @param comparator
     * @return
     */
    public boolean contains(final TSource value, final Comparator<TSource> comparator) {
        for (TSource obj : iterable) {
            if (comparator.compare(obj, value) == 0) {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------
    // 取得
    // ------------------------------------------------------------

    /**
     *
     * @return
     */
    public TSource singleOrDefault() {
        if (iterable instanceof List) {
            List<TSource> list = (List<TSource>)iterable;
            if (list.isEmpty()) {
                return null;
            } else if (list.size() == 1) {
                return list.get(0);
            }
        } else {
            Iterator<TSource> iterator = iterable.iterator();
            if (!iterator.hasNext()) {
                return null;
            }
            TSource result = iterator.next();
            if (!iterator.hasNext()) {
                return result;
            }
        }
        throw new IllegalStateException("MoreThanOneElement");
    }

    /**
     *
     * @param predicate
     * @return
     */
    public TSource singleOrDefault(final Predicate<TSource> predicate) {
        TSource result = null;
        int count = 0;
        for (TSource value : iterable) {
            if (predicate.test(value)) {
                result = value;
                count++;
                if (count > 1) {
                    throw new IllegalStateException("MoreThanOneElement");
                }
            }
        }
        return result;
    }

    public TSource single() {
        if (iterable instanceof List) {
            List<TSource> list = (List<TSource>)iterable;
            if (list.isEmpty()) {
                throw new IllegalStateException("NoElements");
            } else if (list.size() == 1) {
                return list.get(0);
            }
        } else {
            Iterator<TSource> iterator = iterable.iterator();
            if (!iterator.hasNext()) {
                throw new IllegalStateException("NoElements");
            }
            TSource result = iterator.next();
            if (!iterator.hasNext()) {
                return result;
            }
        }
        throw new IllegalStateException("MoreThanOneElement");
    }

    /**
     *
     * @param predicate
     * @return
     */
    public TSource single(final Predicate<TSource> predicate) {
        TSource result = null;
        int count = 0;
        for (TSource value : iterable) {
            if (predicate.test(value)) {
                result = value;
                count++;
                if (count > 1) {
                    throw new IllegalStateException("MoreThanOneElement");
                }
            }
        }
        if (count == 0) {
            throw new IllegalStateException("MoreThanOneElement");
        }
        return result;
    }

    /**
     *
     * @return
     */
    public TSource firstOrDefault() {
        if (iterable instanceof List) {
            List<TSource> list = (List<TSource>)iterable;
            if (!list.isEmpty()) {
                return list.get(0);
            }
        } else {
            Iterator<TSource> iterator = iterable.iterator();
            if (iterator.hasNext()) {
                return iterator.next();
            }
        }
        return null;
    }

    /**
     *
     * @param predicate
     * @return
     */
    public TSource firstOrDefault(final Predicate<TSource> predicate) {
        for (TSource value : iterable) {
            if (predicate.test(value)) {
                return value;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public TSource first() {
        if (iterable instanceof List) {
            List<TSource> list = (List<TSource>)iterable;
            if (!list.isEmpty()) {
                return list.get(0);
            }
        } else {
            Iterator<TSource> iterator = iterable.iterator();
            if (iterator.hasNext()) {
                return iterator.next();
            }
        }
        throw new IllegalStateException("NoElements");
    }

    /**
     *
     * @param predicate
     * @return
     */
    public TSource first(final Predicate<TSource> predicate) {
        for (TSource value : iterable) {
            if (predicate.test(value)) {
                return value;
            }
        }
        throw new IllegalStateException("NoMatch");
    }

    /**
     *
     * @return
     */
    public TSource lastOrDefault() {
        if (iterable instanceof List) {
            List<TSource> list = (List<TSource>)iterable;
            if (!list.isEmpty()) {
                list.get(list.size() - 1);
            }
        } else {
            Iterator<TSource> iterator = iterable.iterator();
            if (iterator.hasNext()) {
                TSource result;
                do {
                    result = iterator.next();
                } while (iterator.hasNext());
                return result;
            }
        }
        return null;
    }

    /**
     *
     * @param predicate
     * @return
     */
    public TSource lastOrDefault(final Predicate<TSource> predicate) {
        TSource result = null;
        for (TSource value : iterable) {
            if (predicate.test(value)) {
                result = value;
            }
        }
        return result;
    }

    /**
     *
     * @return
     */
    public TSource last() {
        if (iterable instanceof List) {
            List<TSource> list = (List<TSource>)iterable;
            if (!list.isEmpty()) {
                return list.get(list.size() - 1);
            }
        } else {
            Iterator<TSource> iterator = iterable.iterator();
            if (iterator.hasNext()) {
                TSource result;
                do {
                    result = iterator.next();
                } while (iterator.hasNext());
                return result;
            }
        }
        throw new IllegalStateException("NoElements");
    }

    /**
     *
     * @param predicate
     * @return
     */
    public TSource last(final Predicate<TSource> predicate) {
        TSource result = null;
        boolean find = false;
        for (TSource value : iterable) {
            if (predicate.test(value)) {
                result = value;
                find = true;
            }
        }
        if (find) {
            return result;
        }
        throw new IllegalStateException("NoMatch");
    }

    /**
     *
     * @param index
     * @return
     */
    public TSource elementAtOrDefault(final int index) {
        if (index > 0) {
            if (iterable instanceof List) {
                List<TSource> list = (List<TSource>)iterable;
                if (index < list.size()) {
                    return list.get(index);
                }
            } else {
                int i = index;
                for (TSource value : iterable) {
                    if (i == 0) {
                        return value;
                    }
                    i--;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param index
     * @return
     */
    public TSource elementAt(final int index) {
        if (iterable instanceof List) {
            List<TSource> list = (List<TSource>)iterable;
            return list.get(index);
        } else {
            if (index < 0) {
                throw new IndexOutOfBoundsException("Index: " + index);
            }
            int i = index;
            for (TSource value : iterable) {
                if (i == 0) {
                    return value;
                }
                i--;
            }
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    // ------------------------------------------------------------
    // カウント
    // ------------------------------------------------------------

    /**
     *
     * @return
     */
    public int count() {
        if (iterable instanceof Collection) {
            return ((Collection<TSource>)iterable).size();
        }
        Iterator<TSource> it = iterable.iterator();
        int count = 0;
        while (it.hasNext()) {
            count++;
            it.next();
        }
        return count;
    }

    /**
     *
     * @param predicate
     * @return
     */
    public int count(final Predicate<TSource> predicate) {
        int count = 0;
        for (TSource obj : iterable) {
            if (predicate.test(obj)) {
                count++;
            }
        }
        return count;
    }

    // ------------------------------------------------------------
    // 集計(汎用)
    // ------------------------------------------------------------

    /**
     *
     * @param <TResult>
     * @param func
     * @return
     */
    public <TResult> TResult aggregate(
            final Func2<TResult, TSource, TResult> func) {
        return aggregate(null, func);
    }

    /**
     *
     * @param <TResult>
     * @param seed
     * @param func
     * @return
     */
    public <TResult> TResult aggregate(
            final TResult seed,
            final Func2<TResult, TSource, TResult> func) {
        TResult value = seed;
        for (TSource obj : iterable) {
            value = func.eval(value, obj);
        }
        return value;
    }

    /**
     *
     * @param <TAccumulate>
     * @param <TResult>
     * @param func
     * @param resultSelector
     * @return
     */
    public <TAccumulate, TResult> TResult aggregate(
            final Func2<TAccumulate, TSource, TAccumulate> func,
            final Func1<TAccumulate, TResult> resultSelector) {
        return aggregate(null, func, resultSelector);
    }

    /**
     *
     * @param <TAccumulate>
     * @param <TResult>
     * @param seed
     * @param func
     * @param resultSelector
     * @return
     */
    public <TAccumulate, TResult> TResult aggregate(
            final TAccumulate seed,
            final Func2<TAccumulate, TSource, TAccumulate> func,
            final Func1<TAccumulate, TResult> resultSelector) {
        TAccumulate value = seed;
        for (TSource obj : iterable) {
            value = func.eval(value, obj);
        }
        return resultSelector.eval(value);
    }

    // ------------------------------------------------------------
    // 集計(Sum)
    // ------------------------------------------------------------

    /**
     *
     * @param selector
     * @return
     */
    public int sum(final Func1<TSource, Integer> selector) {
        return select(selector).aggregate(0, Functions.ADD_INTEGER);
    }

    /**
     *
     * @param selector
     * @return
     */
    public long sumLong(final Func1<TSource, Long> selector) {
        return select(selector).aggregate(0L, Functions.ADD_LONG);
    }

    /**
     *
     * @param selector
     * @return
     */
    public float sumFloat(final Func1<TSource, Float> selector) {
        return select(selector).aggregate(0F, Functions.ADD_FLOAT);
    }

    /**
     *
     * @param selector
     * @return
     */
    public double sumDouble(final Func1<TSource, Double> selector) {
        return select(selector).aggregate(0D, Functions.ADD_DOUBLE);
    }

    /**
     *
     * @param selector
     * @return
     */
    public BigInteger sumBigInteger(final Func1<TSource, BigInteger> selector) {
        return select(selector).aggregate(BigInteger.ZERO, Functions.ADD_BIG_INTEGER);
    }

    /**
     *
     * @param selector
     * @return
     */
    public BigDecimal sumBigDecimal(final Func1<TSource, BigDecimal> selector) {
        return select(selector).aggregate(BigDecimal.ZERO, Functions.ADD_BIG_DECIMAL);
    }

    // ------------------------------------------------------------
    // 集計(Max)
    // ------------------------------------------------------------

    /**
     *
     * @param selector
     * @return
     */
    public Integer max(final Func1<TSource, Integer> selector) {
        return select(selector).aggregate(null, Functions.MAX_INTEGER);
    }

    /**
     *
     * @param selector
     * @return
     */
    public Long maxLong(final Func1<TSource, Long> selector) {
        return select(selector).aggregate(null, Functions.MAX_LONG);
    }

    /**
     *
     * @param selector
     * @return
     */
    public Float maxFloat(final Func1<TSource, Float> selector) {
        return select(selector).aggregate(null, Functions.MAX_FLOAT);
    }

    /**
     *
     * @param selector
     * @return
     */
    public Double maxDouble(final Func1<TSource, Double> selector) {
        return select(selector).aggregate(null, Functions.MAX_DOUBLE);
    }

    /**
     *
     * @param selector
     * @return
     */
    public BigInteger maxBigInteger(final Func1<TSource, BigInteger> selector) {
        return select(selector).aggregate(null, Functions.MAX_BIG_INTEGER);
    }

    /**
     *
     * @param selector
     * @return
     */
    public BigDecimal maxBigDecimal(final Func1<TSource, BigDecimal> selector) {
        return select(selector).aggregate(null, Functions.MAX_BIG_DECIMAL);
    }

    // ------------------------------------------------------------
    // 集計(Min)
    // ------------------------------------------------------------

    /**
     *
     * @param selector
     * @return
     */
    public Integer min(final Func1<TSource, Integer> selector) {
        return select(selector).aggregate(null, Functions.MIN_INTEGER);
    }

    /**
     *
     * @param selector
     * @return
     */
    public Long minLong(final Func1<TSource, Long> selector) {
        return select(selector).aggregate(null, Functions.MIN_LONG);
    }

    /**
     *
     * @param selector
     * @return
     */
    public Float minFloat(final Func1<TSource, Float> selector) {
        return select(selector).aggregate(null, Functions.MIN_FLOAT);
    }

    /**
     *
     * @param selector
     * @return
     */
    public Double minDouble(final Func1<TSource, Double> selector) {
        return select(selector).aggregate(null, Functions.MIN_DOUBLE);
    }

    /**
     *
     * @param selector
     * @return
     */
    public BigInteger minBigInteger(final Func1<TSource, BigInteger> selector) {
        return select(selector).aggregate(null, Functions.MIN_BIG_INTEGER);
    }

    /**
     *
     * @param selector
     * @return
     */
    public BigDecimal minBigDecimal(final Func1<TSource, BigDecimal> selector) {
        return select(selector).aggregate(null, Functions.MIN_BIG_DECIMAL);
    }

    // ------------------------------------------------------------
    // 集計(Avg)
    // ------------------------------------------------------------

    /**
     *
     * @param sum
     * @param avg
     * @return
     */
    private TSource average(final Func2<TSource, TSource, TSource> sum, final Func2<TSource, Integer, TSource> avg) {
        TSource value = null;
        int i = 0;
        for (TSource obj : iterable) {
            if (obj != null) {
                value = sum.eval(value, obj);
                i++;
            }
        }
        return i > 0 ? avg.eval(value, i) : null;
    }

    /**
     *
     * @param selector
     * @return
     */
    public Integer average(final Func1<TSource, Integer> selector) {
        return select(selector).average(Functions.ADD_INTEGER, Functions.DIV_INTEGER);
    }

    /**
     *
     * @param selector
     * @return
     */
    public Long averageLong(final Func1<TSource, Long> selector) {
        return select(selector).average(Functions.ADD_LONG, Functions.DIV_LONG);
    }

    /**
     *
     * @param selector
     * @return
     */
    public Float averageFloat(final Func1<TSource, Float> selector) {
        return select(selector).average(Functions.ADD_FLOAT, Functions.DIV_FLOAT);
    }

    /**
     *
     * @param selector
     * @return
     */
    public Double averageDouble(final Func1<TSource, Double> selector) {
        return select(selector).average(Functions.ADD_DOUBLE, Functions.DIV_DOUBLE);
    }

    /**
     *
     * @param selector
     * @return
     */
    public BigInteger averageBigInteger(final Func1<TSource, BigInteger> selector) {
        return select(selector).average(Functions.ADD_BIG_INTEGER, Functions.DIV_BIG_INTEGER);
    }

    /**
     *
     * @param selector
     * @return
     */
    public BigDecimal averageBigDecimal(final Func1<TSource, BigDecimal> selector) {
        return select(selector).average(Functions.ADD_BIG_DECIMAL, Functions.DIV_BIG_DECIMAL);
    }

    // ------------------------------------------------------------
    // 条件
    // ------------------------------------------------------------

    /**
     *
     * @param <TSource>
     * @param predicate
     * @return
     */
    public ObjectQuery<TSource> where(final Predicate<TSource> predicate) {
        return new ObjectQuery<TSource>(new Iterable<TSource>() {
            @Override
            public Iterator<TSource> iterator() {
                return new WhereIterator<TSource>(iterable.iterator(), predicate);
            }
        });
    }

    // ------------------------------------------------------------
    // グルーピング
    // ------------------------------------------------------------

    /**
     *
     * @param <TKey>
     * @param keySelector
     * @return
     */
    public <TKey> ObjectQuery<Grouping<TKey, TSource>> groupBy(
            final Func1<TSource, TKey> keySelector) {
        return new ObjectQuery<Grouping<TKey, TSource>>(new Iterable<Grouping<TKey, TSource>>() {
            @Override
            public Iterator<Grouping<TKey, TSource>> iterator() {
                return new GroupedIterator<TSource, TKey, TSource, Grouping<TKey, TSource>>(
                        iterable.iterator(), keySelector, new Func1<TSource, TSource>() {
                    @Override
                    public TSource eval(final TSource source) {
                        return source;
                    }
                }, new Func1<Grouping<TKey, TSource>, Grouping<TKey, TSource>>() {
                    @Override
                    public Grouping<TKey, TSource> eval(final Grouping<TKey, TSource> grouping) {
                        return grouping;
                    }
                });
            }
        });
    }

    /**
     *
     * @param <TKey>
     * @param <TElement>
     * @param keySelector
     * @param elementSelector
     * @return
     */
    public <TKey, TElement> ObjectQuery<Grouping<TKey, TElement>> groupBy(
            final Func1<TSource, TKey> keySelector,
            final Func1<TSource, TElement> elementSelector) {
        return new ObjectQuery<Grouping<TKey, TElement>>(new Iterable<Grouping<TKey, TElement>>() {
            @Override
            public Iterator<Grouping<TKey, TElement>> iterator() {
                return new GroupedIterator<TSource, TKey, TElement, Grouping<TKey, TElement>>(
                        iterable.iterator(), keySelector, elementSelector, new Func1<Grouping<TKey, TElement>, Grouping<TKey, TElement>>() {
                    @Override
                    public Grouping<TKey, TElement> eval(final Grouping<TKey, TElement> grouping) {
                        return grouping;
                    }
                });
            }
        });
    }

    /**
     *
     * @param <TKey>
     * @param <TResult>
     * @param keySelector
     * @param resultSelector
     * @return
     */
    public <TKey, TResult> ObjectQuery<TResult> groupBy(
            final Func1<TSource, TKey> keySelector,
            final Func2<TKey, Iterable<TSource>, TResult> resultSelector) {
        return new ObjectQuery<TResult>(new Iterable<TResult>() {
            @Override
            public Iterator<TResult> iterator() {
                return new GroupedIterator<TSource, TKey, TSource, TResult>(iterable.iterator(), keySelector, new Func1<TSource, TSource>() {
                    @Override
                    public TSource eval(final TSource source) {
                        return source;
                    }
                }, new Func1<Grouping<TKey, TSource>, TResult>() {
                    @Override
                    public TResult eval(final Grouping<TKey, TSource> grouping) {
                        return resultSelector.eval(grouping.getKey(), grouping);
                    }
                });
            }
        });
    }

    /**
     *
     * @param <TKey>
     * @param <TElement>
     * @param <TResult>
     * @param keySelector
     * @param elementSelector
     * @param resultSelector
     * @return
     */
    public <TKey, TElement, TResult> ObjectQuery<TResult> groupBy(
            final Func1<TSource, TKey> keySelector,
            final Func1<TSource, TElement> elementSelector,
            final Func2<TKey, Iterable<TElement>, TResult> resultSelector) {
        return new ObjectQuery<TResult>(new Iterable<TResult>() {
            @Override
            public Iterator<TResult> iterator() {
                return new GroupedIterator<TSource, TKey, TElement, TResult>(
                        iterable.iterator(), keySelector, elementSelector, new Func1<Grouping<TKey, TElement>, TResult>() {
                    @Override
                    public TResult eval(final Grouping<TKey, TElement> grouping) {
                        return resultSelector.eval(grouping.getKey(), grouping);
                    }
                });
            }
        });
    }

    // ------------------------------------------------------------
    // マップ
    // ------------------------------------------------------------

    /**
     *
     * @param <TResult>
     * @param resultSelector
     * @return
     */
    public <TResult> ObjectQuery<TResult> select(final Func1<TSource, TResult> resultSelector) {
        return new ObjectQuery<TResult>(new Iterable<TResult>() {
            @Override
            public Iterator<TResult> iterator() {
                return new SelectIterator<TSource, TResult>(iterable.iterator(), resultSelector);
            }
        });
    }

    /**
     *
     * @param <TResult>
     * @param resultSelector
     * @return
     */
    public <TResult> ObjectQuery<TResult> selectMany(
            final Func1<TSource, Iterable<TResult>> resultSelector) {
        return new ObjectQuery<TResult>(new Iterable<TResult>() {
            @Override
            public Iterator<TResult> iterator() {
                return new SelectManyIterator<TSource, TResult, TResult>(iterable.iterator(), resultSelector, new Func2<TSource, TResult, TResult>() {
                    @Override
                    public TResult eval(final TSource source, final TResult result) {
                        return result;
                    }
                });
            }
        });
    }

    /**
     *
     * @param <TResult>
     * @param <TCollection>
     * @param collectionSelector
     * @param resultSelector
     * @return
     */
    public <TResult, TCollection> ObjectQuery<TResult> selectMany(
            final Func1<TSource, Iterable<TCollection>> collectionSelector,
            final Func2<TSource, TCollection, TResult> resultSelector) {
        return new ObjectQuery<TResult>(new Iterable<TResult>() {
            @Override
            public Iterator<TResult> iterator() {
                return new SelectManyIterator<TSource, TCollection, TResult>(iterable.iterator(), collectionSelector, resultSelector);
            }
        });
    }

    // ------------------------------------------------------------
    // 結合
    // ------------------------------------------------------------

    /**
     *
     * @param <TInner>
     * @param <TKey>
     * @param <TResult>
     * @param inner
     * @param outerKeySelector
     * @param innerKeySelector
     * @param resultSelector
     * @return
     */
    public <TInner, TKey extends Comparable<? super TKey>, TResult> ObjectQuery<TResult> join(
            final Iterable<TInner> inner,
            final Func1<TSource, TKey> outerKeySelector,
            final Func1<TInner, TKey> innerKeySelector,
            final Func2<TSource, TInner, TResult> resultSelector) {
        return new ObjectQuery<TResult>(new Iterable<TResult>() {
            @Override
            public Iterator<TResult> iterator() {
                return new JoinIterator<TSource, TInner, TKey, TResult>(
                        iterable.iterator(), inner.iterator(), outerKeySelector, innerKeySelector, resultSelector);
            }
        });
    }

    /**
     *
     * @param <TInner>
     * @param <TKey>
     * @param <TResult>
     * @param inner
     * @param outerKeySelector
     * @param innerKeySelector
     * @param resultSelector
     * @return
     */
    public <TInner, TKey extends Comparable<? super TKey>, TResult> ObjectQuery<TResult> groupJoin(
            final Iterable<TInner> inner,
            final Func1<TSource, TKey> outerKeySelector,
            final Func1<TInner, TKey> innerKeySelector,
            final Func2<TSource, Iterable<TInner>, TResult> resultSelector) {
        return new ObjectQuery<TResult>(new Iterable<TResult>() {
            @Override
            public Iterator<TResult> iterator() {
                return new GroupJoinIterator<TSource, TInner, TKey, TResult>(
                        iterable.iterator(), inner.iterator(), outerKeySelector, innerKeySelector, resultSelector);
            }
        });
    }

    // ------------------------------------------------------------
    // List
    // ------------------------------------------------------------

    /**
     * リスト変換を行います。
     *
     * @return リスト
     */
    public List<TSource> toList() {
        if (iterable instanceof Collection) {
            return new ArrayList<TSource>((Collection<TSource>)iterable);
        }
        List<TSource> list = new ArrayList<TSource>();
        for (TSource obj : iterable) {
            list.add(obj);
        }
        return list;
    }

    // ------------------------------------------------------------
    // Set
    // ------------------------------------------------------------

    /**
     * セット変換を行います。
     *
     * @return セット
     */
    public Set<TSource> toSet() {
        Set<TSource> set = new HashSet<TSource>();
        for (TSource obj : iterable) {
            set.add(obj);
        }
        return set;
    }

    /**
     * セット変換を行います。
     *
     * @param <TKey> キー型
     * @param keySelector キーセレクタ
     * @return セット
     */
    public <TKey> Set<TKey> toSet(final Func1<TSource, TKey> keySelector) {
        Set<TKey> set = new HashSet<TKey>();
        for (TSource obj : iterable) {
            set.add(keySelector.eval(obj));
        }
        return set;
    }

    // ------------------------------------------------------------
    // Map
    // ------------------------------------------------------------

    /**
     * マップ変換を行います。
     *
     * @param <TKey> キー型
     * @param keySelector キーセレクタ
     * @return マップ
     */
    public <TKey> Map<TKey, TSource> toMap(final Func1<TSource, TKey> keySelector) {
        Map<TKey, TSource> map = new HashMap<TKey, TSource>();
        for (TSource obj : iterable) {
            map.put(keySelector.eval(obj), obj);
        }
        return map;
    }

    /**
     * マップ変換を行います。
     *
     * @param <TKey> キー型
     * @param <TElement> データ型
     * @param keySelector キーセレクタ
     * @param elementSelector エレメントセレクタ
     * @return マップ
     */
    public <TKey, TElement> Map<TKey, TElement> toMap(final Func1<TSource, TKey> keySelector, final Func1<TSource, TElement> elementSelector) {
        Map<TKey, TElement> map = new HashMap<TKey, TElement>();
        for (TSource obj : iterable) {
            map.put(keySelector.eval(obj), elementSelector.eval(obj));
        }
        return map;
    }

    // ------------------------------------------------------------
    // Lookup
    // ------------------------------------------------------------

    /**
     *
     * @param <TKey>
     * @param keySelector
     * @return
     */
    public <TKey> Lookup<TKey, TSource> toLookup(final Func1<TSource, TKey> keySelector) {
        return LookupImpl.create(iterable.iterator(), keySelector, new Func1<TSource, TSource>() {
            @Override
            public TSource eval(final TSource source) {
                return source;
            }
        });
    }

    /**
     *
     * @param <TKey>
     * @param <TElement>
     * @param keySelector
     * @param elementSelector
     * @return
     */
    public <TKey, TElement> Lookup<TKey, TElement> toLookup(final Func1<TSource, TKey> keySelector, final Func1<TSource, TElement> elementSelector) {
        return LookupImpl.create(iterable.iterator(), keySelector, elementSelector);
    }

    // ------------------------------------------------------------
    // アクション
    // ------------------------------------------------------------

    /**
     *
     * @param action
     */
    public  void each(final Action<TSource> action) {
        for (TSource obj : iterable) {
            action.run(obj);
        }
    }
}
