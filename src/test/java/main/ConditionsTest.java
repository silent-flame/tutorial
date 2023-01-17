package main;

import main.enums.MyEnum;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static main.util.ConditionUtils.switchValue;

public class ConditionsTest {

    @Test
    public void demo() {
        var input = "input";
        var arg = MyEnum.ONE;

        String result = null;
        switch (arg) {
            case ONE:
                result = "1";
                break;
            case TWO:
                result = "2";
                break;
            default: {
                if (input.equalsIgnoreCase("INPUT")) {
                    result = "another result";
                }
            }
        }
    }

    @Test
    public void demo2() {
        var input = "input";
        var arg = MyEnum.ONE;
        var result = switchValue(arg, String.class)// before java 12
                .caseValue(MyEnum.ONE, arg2 -> "1")
                .caseValue(MyEnum.TWO, s -> "2")
                .caseValue(arg2 -> input.equalsIgnoreCase("INPUT"), arg2 -> "another result")
                .orDefault(() -> "defaultString");
        System.out.println(result);
    }


    @Test
    public void demo3() {
        var input = "input";
        var arg = MyEnum.ONE;
        Map<MyEnum, Supplier<String>> processorsMap = new HashMap<>();
        processorsMap.put(MyEnum.ONE, () -> "1");
        processorsMap.put(MyEnum.TWO, () -> "2");
        Function<MyEnum, Supplier<String>> getProcessor = (myEnum -> processorsMap.getOrDefault(myEnum, () -> "defaultString"));
        var result = getProcessor.apply(MyEnum.ONE).get();
        System.out.println(result);
    }
}