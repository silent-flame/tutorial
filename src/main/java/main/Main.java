package main;

import lombok.experimental.ExtensionMethod;
import main.util.CollectionUtils;
import main.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static main.util.ConditionUtils.switchValue;

@ExtensionMethod({ObjectUtils.class, CollectionUtils.class})
public class Main {
    public static void main(String[] args) {
        Integer integer = null;
        integer.orElse(2);

        var result = switchValue("this", String.class)// before java 12
                .caseValue(s -> s.equals("123"), s -> s.substring(1))
                .caseValue("123", s -> "another string")
                .orDefault(() -> "defaultString");
        System.out.println(result);


        Map<String, Function<String, String>> processorMap = new HashMap<>();
        processorMap.put("1-ый", s -> "First");

        List.of(1, 2).forEachOrdered((index, item) -> {
            System.out.println("");
        });

    }
}