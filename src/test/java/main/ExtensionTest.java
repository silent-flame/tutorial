package main;

import lombok.experimental.ExtensionMethod;
import main.util.ObjectUtils;
import org.junit.Test;

@ExtensionMethod(ObjectUtils.class)
public class ExtensionTest {

    @Test
    public void demo() {
        Integer index = null;
        Integer result = null;
        if (index != null) {
            if (result != null) {
                result = index;
            }
        }
        System.out.println(result);
    }

    @Test
    public void demo2() {
        Integer index = null;
        Integer result = index.orElse(index).orElse(33);
        System.out.println(result);
    }

    @Test
    public void demo3() {
        Integer index = 33;
        String result = index.let(Object::toString);
        System.out.println(result);
    }
}