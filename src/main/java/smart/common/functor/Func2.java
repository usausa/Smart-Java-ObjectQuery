package smart.common.functor;

/**
 *
 * @param <TParam1>
 * @param <TParam2>
 * @param <TResult>
 */
public interface Func2<TParam1, TParam2, TResult> {

    TResult eval(TParam1 param1, TParam2 param2);
}
