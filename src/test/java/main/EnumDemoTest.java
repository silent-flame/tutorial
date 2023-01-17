package main;

import lombok.SneakyThrows;
import main.enums.MyEnum;
import org.junit.Test;

import static main.enums.MyEnum.ONE;
import static main.enums.MyEnum.TWO;


public class EnumDemoTest {

    @SneakyThrows
    @Test
    public void demo() {
        System.out.println(ONE.equals(ONE));
        System.out.println(ONE.getClass().getSuperclass());


        System.out.println(ONE == TWO);
    }

    // https://stackoverflow.com/questions/9614282/how-to-create-an-instance-of-enum-using-reflection-in-java
    @SneakyThrows
    @Test
    public void demo2() {
        MyEnum instance = (MyEnum) MyEnum.class.getConstructors()[0].newInstance();
        System.out.println(instance);
        System.out.println(instance.getClass());
    }
}