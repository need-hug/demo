package com.soft.demo.test;

/**
 * @Auther: lps
 * DateTime: 2019/4/26 11:35
 * @Version: 1.0
 */
public class BinaryTest {

    public static void main(String[] args) {
        String birthday =  "31010819920820381X";
        System.out.println(birthday.substring(6, 14));
        int a = 10;
        int b = a >> 2; // 右移一位相当于除2，右移n位相当于除以2的n次方。
        int c = a << 2;  // 在数字没有溢出的前提下，对于正数和负数，左移一位都相当于乘以2的1次方，左移n位就相当于乘以2的n次方

        int d = 1 << 3;
        System.out.println(String.format(a + " : "+Integer.toBinaryString(a)));
        System.out.println("a >> 2: " + b +" , binary : " + Integer.toBinaryString(b));
        System.out.println("a << 2: " + c +" , binary : " + Integer.toBinaryString(c));
        System.out.println(d +" : " + Integer.toBinaryString(d));
    }

    public static <T extends Number> T binary() {


        return null;
    }
}
