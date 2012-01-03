package smart.common.collectioon;

/**
 *
 */
public final class LookupUtil {

    /**
     *
     * @param <TKey>
     * @param <TElement>
     * @param lookup
     * @param key
     * @return
     */
    public static <TKey, TElement> Iterable<TElement> getOrDefault(final Lookup<TKey, TElement> lookup, final TKey key) {
        if (lookup.containsKey(key)) {
            return lookup.get(key);
        }
        return null;
    }

    /**
     *
     * @param <TKey>
     * @param <TElement>
     * @param lookup
     * @param key
     * @param defaultValues
     * @return
     */
    public static <TKey, TElement> Iterable<TElement> getOrDefault(
            final Lookup<TKey, TElement> lookup, final TKey key, final Iterable<TElement> defaultValues) {
        if (lookup.containsKey(key)) {
            return lookup.get(key);
        }
        return defaultValues;
    }

    /**
     *
     * @param lookup
     * @return
     */
    public static boolean isEmpty(final Lookup<?, ?> lookup) {
        return (lookup == null) || lookup.isEmpty();
    }

    private LookupUtil() {
    }
}
