package smart.common.functor;

/**
 *
 * @param <TParam1>
 * @param <TResult>
 */
public interface Func1<TParam1, TResult> {

    TResult eval(TParam1 param1);
}
