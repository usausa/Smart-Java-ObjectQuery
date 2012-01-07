package smart.common.functions;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import smart.common.functor.Func1;
import smart.common.functor.Predicate;

/**
 *
 */
public final class Predicates {

    // ------------------------------------------------------------
    // Integer
    // ------------------------------------------------------------

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Integer> equal(final int compare) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(final Integer value) {
                return value == compare;
            }
        };
    }

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Integer> notEqual(final int compare) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(final Integer value) {
                return value != compare;
            }
        };
    }

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Integer> lessThan(final int compare) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(final Integer value) {
                return value < compare;
            }
        };
    }

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Integer> lessEqualThan(final int compare) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(final Integer value) {
                return value <= compare;
            }
        };
    }

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Integer> greaterThan(final int compare) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(final Integer value) {
                return value > compare;
            }
        };
    }

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Integer> greaterEqualThan(final int compare) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(final Integer value) {
                return value >= compare;
            }
        };
    }

    /**
     *
     * @param divisor
     * @return
     */
    public static Predicate<Integer> divisible(final int divisor) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(final Integer dividend) {
                return dividend % divisor == 0;
            }
        };
    }

    /**
     *
     * @param divisor
     * @return
     */
    public static Predicate<Integer> notDivisible(final int divisor) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(final Integer dividend) {
                return dividend % divisor != 0;
            }
        };
    }

    // ------------------------------------------------------------
    // Integer(Selector)
    // ------------------------------------------------------------

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> equal(final Func1<TSource, Integer> selector, final int compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Integer value = selector.eval(source);
                return (value != null) && (value.intValue() == compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> notEqual(final Func1<TSource, Integer> selector, final int compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Integer value = selector.eval(source);
                return (value != null) && (value.intValue() != compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> lessThan(final Func1<TSource, Integer> selector, final int compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Integer value = selector.eval(source);
                return (value != null) && (value.intValue() < compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> lessEqualThan(final Func1<TSource, Integer> selector, final int compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Integer value = selector.eval(source);
                return (value != null) && (value.intValue() <= compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> greaterThan(final Func1<TSource, Integer> selector, final int compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Integer value = selector.eval(source);
                return (value != null) && (value.intValue() > compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> greaterEqualThan(final Func1<TSource, Integer> selector, final int compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Integer value = selector.eval(source);
                return (value != null) && (value.intValue() >= compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param divisor
     * @return
     */
    public static <TSource> Predicate<TSource> divisible(final Func1<TSource, Integer> selector, final int divisor) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Integer value = selector.eval(source);
                return (value != null) && (value % divisor == 0);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param divisor
     * @return
     */
    public static <TSource> Predicate<TSource> notDivisible(final Func1<TSource, Integer> selector, final int divisor) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Integer value = selector.eval(source);
                return (value != null) && (value % divisor != 0);
            }
        };
    }

    // ------------------------------------------------------------
    // Long
    // ------------------------------------------------------------

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Long> equal(final long compare) {
        return new Predicate<Long>() {
            @Override
            public boolean test(final Long value) {
                return value == compare;
            }
        };
    }

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Long> notEqual(final long compare) {
        return new Predicate<Long>() {
            @Override
            public boolean test(final Long value) {
                return value != compare;
            }
        };
    }

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Long> lessThan(final long compare) {
        return new Predicate<Long>() {
            @Override
            public boolean test(final Long value) {
                return value < compare;
            }
        };
    }

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Long> lessEqualThan(final long compare) {
        return new Predicate<Long>() {
            @Override
            public boolean test(final Long value) {
                return value <= compare;
            }
        };
    }

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Long> greaterThan(final long compare) {
        return new Predicate<Long>() {
            @Override
            public boolean test(final Long value) {
                return value > compare;
            }
        };
    }

    /**
     *
     * @param compare
     * @return
     */
    public static Predicate<Long> greaterEqualThan(final long compare) {
        return new Predicate<Long>() {
            @Override
            public boolean test(final Long value) {
                return value >= compare;
            }
        };
    }

    /**
     *
     * @param divisor
     * @return
     */
    public static Predicate<Long> divisible(final long divisor) {
        return new Predicate<Long>() {
            @Override
            public boolean test(final Long dividend) {
                return dividend % divisor == 0;
            }
        };
    }

    /**
     *
     * @param divisor
     * @return
     */
    public static Predicate<Long> notDivisible(final long divisor) {
        return new Predicate<Long>() {
            @Override
            public boolean test(final Long dividend) {
                return dividend % divisor != 0;
            }
        };
    }

    // ------------------------------------------------------------
    // Long(Selector)
    // ------------------------------------------------------------

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> equal(final Func1<TSource, Long> selector, final long compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Long value = selector.eval(source);
                return (value != null) && (value.longValue() == compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> notEqual(final Func1<TSource, Long> selector, final long compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Long value = selector.eval(source);
                return (value != null) && (value.longValue() != compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> lessThan(final Func1<TSource, Long> selector, final long compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Long value = selector.eval(source);
                return (value != null) && (value.longValue() < compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> lessEqualThan(final Func1<TSource, Long> selector, final long compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Long value = selector.eval(source);
                return (value != null) && (value.longValue() <= compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> greaterThan(final Func1<TSource, Long> selector, final long compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Long value = selector.eval(source);
                return (value != null) && (value.longValue() > compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource> Predicate<TSource> greaterEqualThan(final Func1<TSource, Long> selector, final long compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Long value = selector.eval(source);
                return (value != null) && (value.longValue() >= compare);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param divisor
     * @return
     */
    public static <TSource> Predicate<TSource> divisible(final Func1<TSource, Long> selector, final long divisor) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Long value = selector.eval(source);
                return (value != null) && (value % divisor == 0);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @param divisor
     * @return
     */
    public static <TSource> Predicate<TSource> notDivisible(final Func1<TSource, Long> selector, final long divisor) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                Long value = selector.eval(source);
                return (value != null) && (value % divisor != 0);
            }
        };
    }

    // ------------------------------------------------------------
    // Comparable
    // ------------------------------------------------------------

    /**
     *
     * @param compare
     * @return
     */
    public static <TValue extends Comparable<TValue>> Predicate<TValue> equal(final TValue compare) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return ((value == null) && (compare == null)) || ((value != null) && (value.compareTo(compare) == 0));
            }
        };
    }

    /**
     *
     * @param <TValue>
     * @param compare
     * @return
     */
    public static <TValue extends Comparable<TValue>> Predicate<TValue> notEqual(final TValue compare) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return ((value == null) && (compare != null)) || ((value != null) && (value.compareTo(compare) != 0));
            }
        };
    }

    /**
     *
     * @param <TValue>
     * @param compare
     * @return
     */
    public static <TValue extends Comparable<TValue>> Predicate<TValue> lessThan(final TValue compare) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return (value != null) && (value.compareTo(compare) < 0);
            }
        };
    }

    /**
     *
     * @param <TValue>
     * @param compare
     * @return
     */
    public static <TValue extends Comparable<TValue>> Predicate<TValue> lessEqualThan(final TValue compare) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return ((value == null) && (compare == null)) || ((value != null) && (value.compareTo(compare) <= 0));
            }
        };
    }

    /**
     *
     * @param <TValue>
     * @param compare
     * @return
     */
    public static <TValue extends Comparable<TValue>> Predicate<TValue> greaterThan(final TValue compare) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return (value != null) && (value.compareTo(compare) > 0);
            }
        };
    }

    /**
     *
     * @param <TValue>
     * @param compare
     * @return
     */
    public static <TValue extends Comparable<TValue>> Predicate<TValue> greaterEqualThan(final TValue compare) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return ((value == null) && (compare == null)) || ((value != null) && (value.compareTo(compare) >= 0));
            }
        };
    }

    // ------------------------------------------------------------
    // Comparable(Selector)
    // ------------------------------------------------------------

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource, TValue extends Comparable<TValue>> Predicate<TSource> equal(
            final Func1<TSource, TValue> selector, final TValue compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return ((value == null) && (compare == null)) || ((value != null) && (value.compareTo(compare) == 0));
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource, TValue extends Comparable<TValue>> Predicate<TSource> notEqual(
            final Func1<TSource, TValue> selector, final TValue compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return ((value == null) && (compare != null)) || ((value != null) && (value.compareTo(compare) != 0));
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource, TValue extends Comparable<TValue>> Predicate<TSource> lessThan(
            final Func1<TSource, TValue> selector, final TValue compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return (value != null) && (value.compareTo(compare) < 0);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource, TValue extends Comparable<TValue>> Predicate<TSource> lessEqualThan(
            final Func1<TSource, TValue> selector, final TValue compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return ((value == null) && (compare == null)) || ((value != null) && (value.compareTo(compare) <= 0));
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource, TValue extends Comparable<TValue>> Predicate<TSource> greaterThan(
            final Func1<TSource, TValue> selector, final TValue compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return (value != null) && (value.compareTo(compare) > 0);
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @return
     */
    public static <TSource, TValue extends Comparable<TValue>> Predicate<TSource> greaterEqualThan(
            final Func1<TSource, TValue> selector, final TValue compare) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return ((value == null) && (compare == null)) || ((value != null) && (value.compareTo(compare) >= 0));
            }
        };
    }

    // ------------------------------------------------------------
    // Comparator
    // ------------------------------------------------------------

    /**
     *
     * @param <TValue>
     * @param compare
     * @param comparator
     * @return
     */
    public static <TValue> Predicate<TValue> equal(final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return ((value == null) && (compare == null)) || ((value != null) && (comparator.compare(value, compare) == 0));
            }
        };
    }

    /**
     *
     * @param <TValue>
     * @param compare
     * @param comparator
     * @return
     */
    public static <TValue> Predicate<TValue> notEqual(final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return ((value == null) && (compare != null)) || ((value != null) && (comparator.compare(value, compare) != 0));
            }
        };
    }

    /**
     *
     * @param <TValue>
     * @param compare
     * @param comparator
     * @return
     */
    public static <TValue> Predicate<TValue> lessThan(final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return ((value != null) && (comparator.compare(value, compare) < 0));
            }
        };
    }

    /**
     *
     * @param <TValue>
     * @param compare
     * @param comparator
     * @return
     */
    public static <TValue> Predicate<TValue> lessEqualThan(final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return ((value == null) && (compare == null)) || ((value != null) && (comparator.compare(value, compare) <= 0));
            }
        };
    }

    /**
     *
     * @param <TValue>
     * @param compare
     * @param comparator
     * @return
     */
    public static <TValue> Predicate<TValue> greaterThan(final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return ((value != null) && (comparator.compare(value, compare) > 0));
            }
        };
    }

    /**
     *
     * @param <TValue>
     * @param compare
     * @param comparator
     * @return
     */
    public static <TValue> Predicate<TValue> greaterEqualThan(final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return ((value == null) && (compare == null)) || ((value != null) && (comparator.compare(value, compare) >= 0));
            }
        };
    }

    // ------------------------------------------------------------
    // Comparator(Selector)
    // ------------------------------------------------------------

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @param comparator
     * @return
     */
    public static <TSource, TValue> Predicate<TSource> equal(
            final Func1<TSource, TValue> selector, final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return ((value == null) && (compare == null)) || ((value != null) && (comparator.compare(value, compare) == 0));
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @param comparator
     * @return
     */
    public static <TSource, TValue> Predicate<TSource> notEqual(
            final Func1<TSource, TValue> selector, final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return ((value == null) && (compare != null)) || ((value != null) && (comparator.compare(value, compare) != 0));
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @param comparator
     * @return
     */
    public static <TSource, TValue> Predicate<TSource> lessThan(
            final Func1<TSource, TValue> selector, final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return ((value != null) && (comparator.compare(value, compare) < 0));
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @param comparator
     * @return
     */
    public static <TSource, TValue> Predicate<TSource> lessEqualThan(
            final Func1<TSource, TValue> selector, final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return ((value == null) && (compare == null)) || ((value != null) && (comparator.compare(value, compare) <= 0));
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @param comparator
     * @return
     */
    public static <TSource, TValue> Predicate<TSource> greaterThan(
            final Func1<TSource, TValue> selector, final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return ((value != null) && (comparator.compare(value, compare) > 0));
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param compare
     * @param comparator
     * @return
     */
    public static <TSource, TValue> Predicate<TSource> greaterEqualThan(
            final Func1<TSource, TValue> selector, final TValue compare, final Comparator<TValue> comparator) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                TValue value = selector.eval(source);
                return ((value == null) && (compare == null)) || ((value != null) && (comparator.compare(value, compare) >= 0));
            }
        };
    }

    // ------------------------------------------------------------
    // Set/Map
    // ------------------------------------------------------------

    /**
     *
     * @param <TValue>
     * @param set
     * @return
     */
    public static <TValue> Predicate<TValue> contained(final Set<TValue> set) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return set.contains(value);
            }
        };
    }

    /**
     *
     * @param <TValue>
     * @param set
     * @return
     */
    public static <TValue> Predicate<TValue> notContained(final Set<TValue> set) {
        return new Predicate<TValue>() {
            @Override
            public boolean test(final TValue value) {
                return set.contains(value);
            }
        };
    }

    /**
     *
     * @param <TKey>
     * @param <TValue>
     * @param map
     * @return
     */
    public static <TKey, TValue> Predicate<TKey> keyContained(final Map<TKey, TValue> map) {
        return new Predicate<TKey>() {
            @Override
            public boolean test(final TKey key) {
                return map.containsKey(key);
            }
        };
    }

    /**
     *
     * @param <TKey>
     * @param <TValue>
     * @param map
     * @return
     */
    public static <TKey, TValue> Predicate<TKey> keyNotContained(final Map<TKey, TValue> map) {
        return new Predicate<TKey>() {
            @Override
            public boolean test(final TKey key) {
                return !map.containsKey(key);
            }
        };
    }

    // ------------------------------------------------------------
    // Set/Map(Selector)
    // ------------------------------------------------------------

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param set
     * @return
     */
    public static <TSource, TValue> Predicate<TSource> contained(final Func1<TSource, TValue> selector, final Set<TValue> set) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                return set.contains(selector.eval(source));
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TValue>
     * @param selector
     * @param set
     * @return
     */
    public static <TSource, TValue> Predicate<TSource> notContained(final Func1<TSource, TValue> selector, final Set<TValue> set) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                return set.contains(selector.eval(source));
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TKey>
     * @param <TValue>
     * @param selector
     * @param map
     * @return
     */
    public static <TSource, TKey, TValue> Predicate<TSource> keyContained(final Func1<TSource, TKey> selector, final Map<TKey, TValue> map) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                return map.containsKey(selector.eval(source));
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TKey>
     * @param <TValue>
     * @param selector
     * @param map
     * @return
     */
    public static <TSource, TKey, TValue> Predicate<TSource> keyNotContained(final Func1<TSource, TKey> selector, final Map<TKey, TValue> map) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                return !map.containsKey(selector.eval(source));
            }
        };
    }

    // ------------------------------------------------------------
    // String
    // ------------------------------------------------------------

    /**
     *
     * @return
     */
    public static Predicate<String> isEmpty() {
        return new Predicate<String>() {
            @Override
            public boolean test(final String value) {
                return ((value == null) || value.isEmpty());
            }
        };
    }

    /**
     *
     * @return
     */
    public static Predicate<String> isNotEmpty() {
        return new Predicate<String>() {
            @Override
            public boolean test(final String value) {
                return !((value == null) || value.isEmpty());
            }
        };
    }

    // ------------------------------------------------------------
    // String(Selector)
    // ------------------------------------------------------------

    /**
     *
     * @param <TSource>
     * @param selector
     * @return
     */
    public static <TSource> Predicate<TSource> isEmpty(final Func1<TSource, String> selector) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                String value = selector.eval(source);
                return ((value == null) || value.isEmpty());
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param selector
     * @return
     */
    public static <TSource> Predicate<TSource> isNotEmpty(final Func1<TSource, String> selector) {
        return new Predicate<TSource>() {
            @Override
            public boolean test(final TSource source) {
                String value = selector.eval(source);
                return !((value == null) || value.isEmpty());
            }
        };
    }

    private Predicates() {
    }
}
