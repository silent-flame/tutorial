package main.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CollectionUtils {
    public static <T> List<T> filter(List<T> sourceList, Predicate<T> predicate) {
        if (sourceList == null) {
            return Collections.emptyList();
        }
        List<T> resultList = new ArrayList<>();
        for (var item : sourceList) {
            if (predicate.test(item)) {
                resultList.add(item);
            }
        }
        return resultList;
    }

    public static <T> Pair<List<T>, List<T>> partition(List<T> sourceList, Predicate<T> predicate) {
        List<T> firstList = new ArrayList<>();
        List<T> secondList = new ArrayList<>();
        for (var item : sourceList) {
            if (predicate.test(item)) {
                firstList.add(item);
            } else {
                secondList.add(item);
            }
        }
        return new Pair<>(firstList, secondList);
    }

    public static <T> void forEachOrdered(List<T> sourceList, BiConsumer<Integer, T> consumer) {
        for (int i = 0; i < sourceList.size(); i++) {
            consumer.accept(i, sourceList.get(i));
        }
    }
}