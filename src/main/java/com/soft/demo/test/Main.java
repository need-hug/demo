package com.soft.demo.test;

import com.soft.demo.constans.Constans;

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
        System.out.println("args = [" + (1 << 30) + "]");
        System.out.println(Constans.getTest());
//        for (int i = 1; i < 100; i++) {
//            System.out.println("\tn:" + tableSizeFor(i));
//        }

    }

}
