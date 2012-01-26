package smart.common.functor;

import java.io.PrintStream;


/**
 *
 */
public final class Actions {

    private static final Action0 NO_ACTION0 = new Action0() {
        @Override
        public void run() {
        }
    };

    private static final Action1<Void> NO_ACTION1 = new Action1<Void>() {
        @Override
        public void run(final Void value) {
        }
    };

    // ------------------------------------------------------------
    // Basic
    // ------------------------------------------------------------

    /**
     *
     * @return
     */
    public static Action0 noAction0() {
        return NO_ACTION0;
    }

    /**
     *
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Action1<T> noAction1() {
        return (Action1<T>)NO_ACTION1;
    }

    // ------------------------------------------------------------
    // Runnable
    // ------------------------------------------------------------

    /**
     *
     * @param run
     * @return
     */
    public static Action0 asAction0(final Runnable run) {
        return new Action0() {
            @Override
            public void run() {
                run.run();
            }
        };
    }

    /**
     *
     * @param run
     * @return
     */
    public static <T> Action1<T> asAction1(final Runnable run) {
        return new Action1<T>() {
            @Override
            public void run(final T param) {
                run.run();
            }
        };
    }

    /**
     *
     * @param action
     * @return
     */
    public static Runnable asRunnable(final Action0 action) {
        return new Runnable() {
            @Override
            public void run() {
                action.run();
            }
        };
    }

    /**
     *
     * @param <T>
     * @param action
     * @param param
     * @return
     */
    public static <T> Runnable asRunnable(final Action1<T> action, final T param) {
        return new Runnable() {
            @Override
            public void run() {
                action.run(param);
            }
        };
    }

    // ------------------------------------------------------------
    // PrintStream
    // ------------------------------------------------------------

    /**
     *
     * @param <T>
     * @param stream
     * @return
     */
    public static <T> Action1<T> print(final PrintStream stream) {
        return new Action1<T>() {
            @Override
            public void run(final T param) {
                stream.print(param);
            }
        };
    }

    /**
     *
     * @param <T>
     * @param stream
     * @return
     */
    public static <T> Action1<T> println(final PrintStream stream) {
        return new Action1<T>() {
            @Override
            public void run(final T param) {
                stream.println(param);
            }
        };
    }

    private Actions() {
    }
}
