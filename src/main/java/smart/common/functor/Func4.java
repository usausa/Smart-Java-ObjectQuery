package smart.common.functor;

/**
 *
 * @param <TParam1>
 * @param <TParam2>
 * @param <TParam3>
 * @param <TParam4>
 * @param <TResult>
 */
public interface Func4<TParam1, TParam2, TParam3, TParam4, TResult> {

    TResult eval(TParam1 param1, TParam2 param2, TParam3 param3, TParam4 param4);
}
