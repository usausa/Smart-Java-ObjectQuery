package smart.common.functor;

import java.io.PrintStream;


/**
 *
 */
public final class Actions {

    private static final Action<Void> NO_ACTION = new Action<Void>() {
        @Override
        public void run(final Void value) {
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
    public static <T> Action<T> noAction() {
        return (Action<T>)NO_ACTION;
    }

    // ------------------------------------------------------------
    // Runnable
    // ------------------------------------------------------------

    /**
     *
     * @param run
     * @return
     */
    public static <T> Action<T> asAction(final Runnable run) {
        return new Action<T>() {
            @Override
            public void run(final T param) {
                run.run();
            }
        };
    }

    /**
     *
     * @param <T>
     * @param action
     * @return
     */
    public static <T> Runnable asRunnable(final Action<T> action) {
        return new Runnable() {
            @Override
            public void run() {
                action.run(null);
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
    public static <T> Runnable asRunnable(final Action<T> action, final T param) {
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
    public static <T> Action<T> print(final PrintStream stream) {
        return new Action<T>() {
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
    public static <T> Action<T> println(final PrintStream stream) {
        return new Action<T>() {
            @Override
            public void run(final T param) {
                stream.println(param);
            }
        };
    }

    private Actions() {
    }
}
