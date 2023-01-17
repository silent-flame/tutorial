package main.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConditionUtils {
    public static <ARG, RESULT> ConditionChain<ARG, RESULT> switchValue(ARG arg, Class<RESULT> resultClass) {
        return new ConditionChain<>(arg);
    }

    public static class ConditionChain<ARG, RESULT> {
        private final ARG arg;

        private final List<Pair<Predicate<ARG>, Function<ARG, RESULT>>> conditionList = new ArrayList<>();

        public ConditionChain(ARG arg) {
            this.arg = arg;
        }

        public ConditionChain<ARG, RESULT> caseValue(Predicate<ARG> predicate, Function<ARG, RESULT> function) {
            conditionList.add(new Pair<>(predicate, function));
            return this;
        }

        public ConditionChain<ARG, RESULT> caseValue(ARG value, Function<ARG, RESULT> function) {
            conditionList.add(new Pair<>(arg -> Objects.equals(arg, value), function));
            return this;
        }

        public RESULT orDefault(Supplier<RESULT> supplier) {
            for (var bucket : conditionList) {
                if (bucket.first().test(arg)) {
                    return bucket.second().apply(arg);
                }
            }
            return supplier.get();
        }

        public RESULT end() {
            for (var bucket : conditionList) {
                if (bucket.first().test(arg)) {
                    return bucket.second().apply(arg);
                }
            }
            return null;
        }
    }
}