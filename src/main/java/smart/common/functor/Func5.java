package smart.common.functor;

/**
 *
 * @param <TParam1>
 * @param <TParam2>
 * @param <TParam3>
 * @param <TParam4>
 * @param <TParam5>
 * @param <TResult>
 */
public interface Func5<TParam1, TParam2, TParam3, TParam4, TParam5, TResult> {

    TResult eval(TParam1 param1, TParam2 param2, TParam3 param3, TParam4 param4, TParam5 param5);
}
