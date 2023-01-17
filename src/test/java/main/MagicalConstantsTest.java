package main;

import org.junit.Test;

public class MagicalConstantsTest {

    @Test
    public void demo() {
        String s1 = "KASSA";
        String s2 = "KАSSA";
        String s3 = "KASSА";
        String s4 = "КASSA";
        String s5 = "КАSSA";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s5));

        System.out.println(s2.equals(s3));
        System.out.println(s2.equals(s4));
        System.out.println(s2.equals(s5));

        System.out.println(s3.equals(s4));
        System.out.println(s3.equals(s5));

        System.out.println(s4.equals(s5));
    }
}