package smart.common.collectioon;

/**
 *
 * @param <TKey>
 * @param <TElement>
 */
public interface Grouping <TKey, TElement> extends Iterable<TElement> {

    TKey getKey();
}
