package smart.common.collectioon.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 */
public class RangeIterator implements Iterator<Integer> {

    private int next;

    private final int end;

    private final int step;

    /**
     *
     * @param start
     * @param end
     * @param step
     */
    public RangeIterator(final int start, final int end, final int step) {
        this.next = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public boolean hasNext() {
        if (step > 0) {
            return next <= end;
        } else {
            return next >= end;
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer value = next;
        next += step;
        return value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
