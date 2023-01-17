package main.util;

import java.util.function.Function;

public class ObjectUtils {

    public static <ARG, RESULT> RESULT let(ARG arg, Function<ARG, RESULT> function) {
        if (arg == null) {
            return null;
        }
        return function.apply(arg);
    }

    public static <T> T orElse(T arg, T otherValue) {
        return arg != null ? arg : otherValue;
    }
}