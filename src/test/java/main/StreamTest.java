package main;

import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    private List<Integer> generate() {
        return IntStream.range(1, 100).boxed().collect(Collectors.toList());
    }

    @Test
    public void demo() {
        var list = generate();
        var integer = new AtomicInteger();
        var result = list.stream().map(Objects::toString)
                .map(s -> s + integer.getAndIncrement())
                .collect(Collectors.toList());
        System.out.println(result);
    }
}