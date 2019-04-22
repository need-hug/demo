package com.soft.demo.test;

import com.soft.demo.constans.Constans;

import java.util.Arrays;

/**
 * @Auther: lps
 * DateTime: 2019/3/29 15:07
 * @Version: 1.0
 */
public class Main {

    private static final int tableSizeFor(int c) {
        int n = c - 1;
        System.out.print("c - 1 :" + n);
        n |= n >>> 1;
        System.out.print("\tn |= n >>> 1 :" + n);
        n |= n >>> 2;
        System.out.print("\tn |= n >>> 2 :" + n);
        n |= n >>> 4;
        System.out.print("\tn |= n >>> 4 :" + n);
        n |= n >>> 8;
        System.out.print("\tn |= n >>> 8 :" + n);
        n |= n >>> 16;
        System.out.print("\tn |= n >>> 16:" + n);
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }

    public static void main(String[] args) {
        jdk1_8();

        jdk1_8PrintUneven();
//        System.out.println("args = [" + (1 << 30) + "]");
//        System.out.println(Constans.getTest());
//        for (int i = 1; i < 100; i++) {
//            System.out.println("\tn:" + tableSizeFor(i));
//        }

    }

    /**
     * jdk 1.8 函数式编程中，几乎所有传递的对象都不会被轻易更改
     * 类似于不变模式
     */
    private static void jdk1_8() {
        int[] arr = {1, 3, 5, 7, 8, 9};
        int[] arr_1 = Arrays.stream(arr).map((x) -> x=x+1).toArray();
        Arrays.stream(arr_1).forEach(System.out::print);
        System.out.println();
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
    }

    public static int[] array = {1, 3, 4, 5, 6, 7, 8, 9, 10};
    /**
     * 奇数加1并打印
     */
    private static void jdk1_8PrintUneven() {
        int[] arr_a = {1, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < arr_a.length; i++) {
            if (arr_a[i] % 2 != 0) {
                arr_a[i]++;
            }
            System.out.print(arr_a[i] + "\t");
        }

        System.out.println();

        int[] arr_b = {1, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(arr_b).map(x -> (x%2==0?x:x+1)).forEach(x -> System.out.print(x+"\t"));
    }
}
