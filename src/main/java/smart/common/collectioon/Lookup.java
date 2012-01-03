package smart.common.collectioon;

/**
 *
 * @param <TKey>
 * @param <TElement>
 */
public interface Lookup<TKey, TElement> extends Iterable<Grouping<TKey, TElement>> {

    /**
     *
     * @param key
     * @return
     */
    boolean containsKey(TKey key);

    /**
     *
     * @return
     */
    int size();

    /**
     *
     * @return
     */
    boolean isEmpty();

    /**
     *
     * @param key
     * @return
     */
    Iterable<TElement> get(TKey key);
}
