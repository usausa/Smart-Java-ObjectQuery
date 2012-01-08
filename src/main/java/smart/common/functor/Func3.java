package smart.common.functor;

/**
 *
 * @param <TParam1>
 * @param <TParam2>
 * @param <TParam3>
 * @param <TResult>
 */
public interface Func3<TParam1, TParam2, TParam3, TResult> {

    TResult eval(TParam1 param1, TParam2 param2, TParam3 param3);
}
