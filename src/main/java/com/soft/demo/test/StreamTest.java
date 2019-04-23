package com.soft.demo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/** 传统for循环、Stream、parallelStream 效率对比
 * @Auther: lps
 * DateTime: 2019/4/23 17:24
 * @Version: 1.0
 */
public class StreamTest {

    /**
     * 构建一个list
     * @return Collections.unmodifiableList(numbers) 返回一个不可修改的list
     */
    public static List<Integer> buildList() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 60000; i++)
            numbers.add(i);
        return Collections.unmodifiableList(numbers);
    }

    public static final CountDownLatch cdl = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        long count = System.currentTimeMillis();
        List<Integer> source = buildList();

        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < source.size(); i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("传统方式："+(System.currentTimeMillis() - startTime) + "ms");
            cdl.countDown();
        }).start();

        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            source.stream().forEach(r -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("单管道stream："+(System.currentTimeMillis() - startTime) + "ms");
            cdl.countDown();
        }).start();

        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            source.parallelStream().forEach(r -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("parallelStream："+(System.currentTimeMillis() - startTime) + "ms");
            cdl.countDown();
        }).start();

        System.out.println("执行到现在耗时:" + (System.currentTimeMillis() - count) + "ms");

        cdl.await();

        System.out.println("等待线程执行完毕总耗时:" + (System.currentTimeMillis() - count) + "ms");


    }

}
