package smart.common.functor;

import java.util.Comparator;

import smart.common.tupple.Tuple2;

/**
 *
 */
public final class Functors {

    private static final Func1<Object, Object> IDENTITY = new Func1<Object, Object>() {
        @Override
        public Object eval(final Object param1) {
            return param1;
        }
    };

    private static final Func2<Object, Object, Object> FIRST = new Func2<Object, Object, Object>() {
        @Override
        public Object eval(final Object param1, final Object param2) {
            return param1;
        }
    };

    private static final Func2<Object, Object, Object> SECOND = new Func2<Object, Object, Object>() {
        @Override
        public Object eval(final Object param1, final Object param2) {
            return param2;
        }
    };

    private static final Func2<Object, Object, Boolean> EQUAL = new Func2<Object, Object, Boolean>() {
        @Override
        public Boolean eval(final Object param1, final Object param2) {
            return (param1 == param2) || (param1 != null && param1.equals(param2));
        }
    };

    private static final Func2<Object, Object, Boolean> NOT_EQUAL = new Func2<Object, Object, Boolean>() {
        @Override
        public Boolean eval(final Object param1, final Object param2) {
            return (param1 != param2) || ((param1 != null) && !param1.equals(param2));
        }
    };

    // ------------------------------------------------------------
    // Basic
    // ------------------------------------------------------------

    /**
     *
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Func1<T, T> identity() {
        return (Func1<T, T>)IDENTITY;
    }

    /**
     *
     * @param <T1>
     * @param <T2>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T1, T2> Func2<T1, T2, T1> first() {
        return (Func2<T1, T2, T1>)FIRST;
    }

    /**
     *
     * @param <T1>
     * @param <T2>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T1, T2> Func2<T1, T2, T2> second() {
        return (Func2<T1, T2, T2>)SECOND;
    }

    /**
     *
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Func2<T, T, Boolean> equal() {
        return (Func2<T, T, Boolean>)EQUAL;
    }

    /**
     *
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Func2<T, T, Boolean> notEqual() {
        return (Func2<T, T, Boolean>)NOT_EQUAL;
    }

    // ------------------------------------------------------------
    // Const
    // ------------------------------------------------------------

    /**
     *
     * @param <TResult>
     * @param value
     * @return
     */
    public static <TResult> Func<TResult> constant(final TResult value) {
        return new Func<TResult>() {
            @Override
            public TResult eval() {
                return value;
            }
        };
    }

    /**
     *
     * @param <TSource>
     * @param <TResult>
     * @param value
     * @return
     */
    public static <TSource, TResult> Func1<TSource, TResult> constant1(final TResult value) {
        return new Func1<TSource, TResult>() {
            @Override
            public TResult eval(final TSource param) {
                return value;
            }
        };
    }

    // ------------------------------------------------------------
    // Calculation
    // ------------------------------------------------------------

    /**
     *
     * @param value
     * @return
     */
    public static Func1<Integer, Integer> add(final int value) {
        return new Func1<Integer, Integer>() {
            @Override
            public Integer eval(final Integer param) {
                return param + value;
            }
        };
    }

    /**
     *
     * @param value
     * @return
     */
    public static Func1<Integer, Integer> sub(final int value) {
        return new Func1<Integer, Integer>() {
            @Override
            public Integer eval(final Integer param) {
                return param - value;
            }
        };
    }

    /**
     *
     * @param value
     * @return
     */
    public static Func1<Integer, Integer> mul(final int value) {
        return new Func1<Integer, Integer>() {
            @Override
            public Integer eval(final Integer param) {
                return param * value;
            }
        };
    }

    /**
     *
     * @param value
     * @return
     */
    public static Func1<Integer, Integer> div(final int value) {
        return new Func1<Integer, Integer>() {
            @Override
            public Integer eval(final Integer param) {
                return param / value;
            }
        };
    }

    /**
     *
     * @param value
     * @return
     */
    public static Func1<Integer, Integer> mod(final int value) {
        return new Func1<Integer, Integer>() {
            @Override
            public Integer eval(final Integer param) {
                return param % value;
            }
        };
    }

    /**
     *
     * @param value
     * @return
     */
    public static Func1<Long, Long> add(final long value) {
        return new Func1<Long, Long>() {
            @Override
            public Long eval(final Long param) {
                return param + value;
            }
        };
    }

    /**
     *
     * @param value
     * @return
     */
    public static Func1<Long, Long> sub(final long value) {
        return new Func1<Long, Long>() {
            @Override
            public Long eval(final Long param) {
                return param - value;
            }
        };
    }

    /**
     *
     * @param value
     * @return
     */
    public static Func1<Long, Long> mul(final long value) {
        return new Func1<Long, Long>() {
            @Override
            public Long eval(final Long param) {
                return param * value;
            }
        };
    }

    /**
     *
     * @param value
     * @return
     */
    public static Func1<Long, Long> div(final long value) {
        return new Func1<Long, Long>() {
            @Override
            public Long eval(final Long param) {
                return param / value;
            }
        };
    }

    /**
     *
     * @param value
     * @return
     */
    public static Func1<Long, Long> mod(final long value) {
        return new Func1<Long, Long>() {
            @Override
            public Long eval(final Long param) {
                return param % value;
            }
        };
    }

    // ------------------------------------------------------------
    // Min/Max
    // ------------------------------------------------------------

    /**
     *
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> Func2<T, T, T> max() {
        return new Func2<T, T, T>() {
            @Override
            public T eval(final T param1, final T param2) {
                if ((param1 == null) || (param2 == null)) {
                    return param1 == null ? param2 : param1;
                }
                return param1.compareTo(param2) < 0 ? param2 : param1;
            };
        };
    }

    /**
     *
     * @param <T>
     * @param comparator
     * @return
     */
    public static <T> Func2<T, T, T> max(final Comparator<? super T> comparator) {
        return new Func2<T, T, T>() {
            @Override
            public T eval(final T param1, final T param2) {
                if ((param1 == null) || (param2 == null)) {
                    return param1 == null ? param2 : param1;
                }
                return comparator.compare(param1, param2) < 0 ? param2 : param1;
            };
        };
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> Func2<T, T, T> min() {
        return new Func2<T, T, T>() {
            @Override
            public T eval(final T param1, final T param2) {
                if ((param1 == null) || (param2 == null)) {
                    return param1 == null ? param2 : param1;
                }
                return param1.compareTo(param2) > 0 ? param2 : param1;
            };
        };
    }

    /**
     *
     * @param <T>
     * @param comparator
     * @return
     */
    public static <T> Func2<T, T, T> min(final Comparator<? super T> comparator) {
        return new Func2<T, T, T>() {
            @Override
            public T eval(final T param1, final T param2) {
                if ((param1 == null) || (param2 == null)) {
                    return param1 == null ? param2 : param1;
                }
                return comparator.compare(param1, param2) > 0 ? param2 : param1;
            };
        };
    }

    // ------------------------------------------------------------
    // Compare
    // ------------------------------------------------------------

    /**
     *
     * @param <T>
     * @param func
     * @return
     */
    public static <T> Comparator<T> asComparator(final Func2<? super T, ? super T, Integer> func) {
        return new Comparator<T>() {
            @Override
            public int compare(final T o1, final T o2) {
                return func.eval(o1, o2);
            };
        };
    }

    /**
     *
     * @param <T>
     * @param comparator
     * @return
     */
    public static <T> Func2<T, T, Integer> asFunction(final Comparator<? super T> comparator) {
        return new Func2<T, T, Integer>() {
            @Override
            public Integer eval(final T param1, final T param2) {
                return comparator.compare(param1, param2);
            };
        };
    }

    // ------------------------------------------------------------
    // Runnable
    // ------------------------------------------------------------

    /**
     *
     * @param <TResult>
     * @param run
     * @return
     */
    public static <TResult> Func<TResult> asAction(final Runnable run) {
        return new Func<TResult>() {
            @Override
            public TResult eval() {
                run.run();
                return null;
            }
        };
    }

    /**
     *
     * @param <TResult>
     * @param func
     * @return
     */
    public static <TResult> Runnable asRunnable(final Func<TResult> func) {
        return new Runnable() {
            @Override
            public void run() {
                func.eval();
            }
        };
    }

    /**
     *
     * @param <TParam1>
     * @param <TResult>
     * @param func
     * @param param1
     * @return
     */
    public static <TParam1, TResult> Runnable asRunnable(
            final Func1<TParam1, TResult> func,
            final TParam1 param1) {
        return new Runnable() {
            @Override
            public void run() {
                func.eval(param1);
            }
        };
    }

    /**
     *
     * @param <TParam1>
     * @param <TParam2>
     * @param <TResult>
     * @param func
     * @param param1
     * @param param2
     * @return
     */
    public static <TParam1, TParam2, TResult> Runnable asRunnable(
            final Func2<TParam1, TParam2, TResult> func,
            final TParam1 param1, final TParam2 param2) {
        return new Runnable() {
            @Override
            public void run() {
                func.eval(param1, param2);
            }
        };
    }

    /**
     *
     * @param <TParam1>
     * @param <TParam2>
     * @param <TParam3>
     * @param <TResult>
     * @param func
     * @param param1
     * @param param2
     * @param param3
     * @return
     */
    public static <TParam1, TParam2, TParam3, TResult> Runnable asRunnable(
            final Func3<TParam1, TParam2, TParam3, TResult> func,
            final TParam1 param1, final TParam2 param2, final TParam3 param3) {
        return new Runnable() {
            @Override
            public void run() {
                func.eval(param1, param2, param3);
            }
        };
    }

    /**
     *
     * @param <TParam1>
     * @param <TParam2>
     * @param <TParam3>
     * @param <TParam4>
     * @param <TResult>
     * @param func
     * @param param1
     * @param param2
     * @param param3
     * @param param4
     * @return
     */
    public static <TParam1, TParam2, TParam3, TParam4, TResult> Runnable asRunnable(
            final Func4<TParam1, TParam2, TParam3, TParam4, TResult> func,
            final TParam1 param1, final TParam2 param2, final TParam3 param3, final TParam4 param4) {
        return new Runnable() {
            @Override
            public void run() {
                func.eval(param1, param2, param3, param4);
            }
        };
    }

    /**
     *
     * @param <TParam1>
     * @param <TParam2>
     * @param <TParam3>
     * @param <TParam4>
     * @param <TParam5>
     * @param <TResult>
     * @param func
     * @param param1
     * @param param2
     * @param param3
     * @param param4
     * @param param5
     * @return
     */
    public static <TParam1, TParam2, TParam3, TParam4, TParam5, TResult> Runnable asRunnable(
            final Func5<TParam1, TParam2, TParam3, TParam4, TParam5, TResult> func,
            final TParam1 param1, final TParam2 param2, final TParam3 param3, final TParam4 param4, final TParam5 param5) {
        return new Runnable() {
            @Override
            public void run() {
                func.eval(param1, param2, param3, param4, param5);
            }
        };
    }

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
