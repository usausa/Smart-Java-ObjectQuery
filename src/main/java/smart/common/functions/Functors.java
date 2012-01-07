package smart.common.functions;

import smart.common.functor.Func2;
import smart.common.tupple.Tuple2;

/**
 *
 */
public final class Functors {

    // ------------------------------------------------------------
    // Tuple
    // ------------------------------------------------------------

    /**
     *
     * @param <T1>
     * @param <T2>
     * @return
     */
    public static <T1, T2> Func2<T1, T2, Tuple2<T1, T2>> tuple() {
        return new Func2<T1, T2, Tuple2<T1, T2>>() {
            @Override
            public Tuple2<T1, T2> eval(final T1 value1, final T2 value2) {
                return new Tuple2<T1, T2>(value1, value2);
            }
        };
    }

    private Functors() {
    }
}
